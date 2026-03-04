package tests;

import assertions.ResponseAssertions;
import client.AuthClient;
import client.BookingClient;
import client.RequestSpecFactory;
import config.ConfigManager;
import data.FakerUtils;
import io.restassured.response.Response;
import mapper.ResponseMapper;
import models.auth.AuthResponse;
import models.booking.BookingDates;
import models.booking.BookingRequest;
import models.booking.CreateBookingResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.time.LocalDate;

public class BookingLifeCycleTest extends BaseTest {
    private BookingClient bookingClient;
    private int bookingId;
    private BookingRequest bookingRequest;

    @BeforeClass
    public void init(){
        bookingClient = new BookingClient(requestSpec);
        LocalDate  checkIn = FakerUtils.randomDate();
        LocalDate checkout = FakerUtils.randomDate(checkIn);
        BookingDates bookingDates = new BookingDates(checkIn.toString(), checkout.toString());
        bookingRequest = new BookingRequest(
                FakerUtils.randomFirstName(),
                FakerUtils.randomLastName(),
                FakerUtils.randomPrice(),
                true,
                bookingDates,
                FakerUtils.randomAdditionalNeeds()
                );
    }

    @Test(priority = 1)
    public void shouldCreateToken(){
        AuthClient authClient = new AuthClient(requestSpec);

        Response response = authClient.createToken();
        ResponseAssertions
                .assertThat(response)
                .hasStatusCode(200)
                .matchesSchema("schemas/create-token-schema.json")
                .hasResponseTimeBelow(ConfigManager.getMaxResponseTime());

        AuthResponse authResponse = ResponseMapper.map(response, AuthResponse.class);
        String token = authResponse.token();
        RequestSpecFactory.addHeader(
                requestSpec,
                "Cookie",
                "token="  + token
        );
    }

    @Test(priority = 2, dependsOnMethods = "shouldCreateToken")
    public void shouldCreateBooking(){

        Response response = bookingClient.createBooking(bookingRequest);
        ResponseAssertions.assertThat(response)
                .hasStatusCode(200)
                .matchesSchema("schemas/create-booking-schema.json")
                .hasResponseTimeBelow(ConfigManager.getMaxResponseTime())
                .hasFistName(bookingRequest.firstname())
                .hasLastName(bookingRequest.lastname());

        bookingId = ResponseMapper.map(response, CreateBookingResponse.class).bookingId();


    }

    @Test(priority = 3, dependsOnMethods = "shouldCreateBooking")
    public void shouldGetBooking() {

        Response response = bookingClient.getBooking(bookingId);

        ResponseAssertions.assertThat(response)
                .hasStatusCode(200)
                .matchesSchema("schemas/booking-schema.json")
                .hasResponseTimeBelow(ConfigManager.getMaxResponseTime())
                .hasFistName(bookingRequest.firstname())
                .hasLastName(bookingRequest.lastname());

    }

    @Test(priority = 4, dependsOnMethods = "shouldGetBooking")
    public void shouldUpdateBooking() {

        String newName = FakerUtils.randomFirstName();
        int newPrice = FakerUtils.randomPrice();

        bookingRequest = new BookingRequest(
                newName,
                bookingRequest.lastname(),
                newPrice,
                bookingRequest.depositPaid(),
                bookingRequest.bookingDates(),
                bookingRequest.additionalNeeds());

        Response response =
                bookingClient.updateBooking(bookingId, bookingRequest);

        ResponseAssertions.assertThat(response)
                .hasStatusCode(200)
                .matchesSchema("schemas/booking-schema.json")
                .hasResponseTimeBelow(ConfigManager.getMaxResponseTime())
                .hasFistName(newName)
                .hasPrice(newPrice);
    }

    @Test(priority = 5, dependsOnMethods = "shouldUpdateBooking")
    public void shouldDeleteBooking() {

        Response response =
                bookingClient.deleteBooking(bookingId);

        ResponseAssertions.assertThat(response)
            .hasStatusCode(201)
            .hasResponseTimeBelow(ConfigManager.getMaxResponseTime());

    }

    @Test(priority = 6, dependsOnMethods = "shouldDeleteBooking")
    public void shouldVerifyBookingDeleted() {

        Response response = bookingClient.getBooking(bookingId);

        ResponseAssertions.assertThat(response)
            .hasStatusCode(404)
            .hasResponseTimeBelow(ConfigManager.getMaxResponseTime());
    }

}
