package client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.booking.BookingRequest;

public class BookingClient extends BaseClient {

    private static final String BOOKING_PATH = "/booking";

    public BookingClient(RequestSpecification requestSpec) {
        super(requestSpec);
    }

    public Response createBooking(BookingRequest request) {
        return post(BOOKING_PATH, request);
    }

    public Response getBooking(int bookingId) {
        return get(BOOKING_PATH + "/" + bookingId);
    }

    public Response updateBooking(int bookingId, BookingRequest request) {
        return put(BOOKING_PATH + "/" + bookingId, request);
    }

    public Response deleteBooking(int bookingId) {
        return delete(BOOKING_PATH + "/" + bookingId);
    }
}