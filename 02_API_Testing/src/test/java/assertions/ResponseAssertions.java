package assertions;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import mapper.ResponseMapper;
import models.booking.CreateBookingResponse;

public final class ResponseAssertions {

    private final Response response;

    private ResponseAssertions(Response response) {
        this.response = response;
    }

    public static ResponseAssertions assertThat(Response response) {
        return new ResponseAssertions(response);
    }

    public ResponseAssertions hasStatusCode(int expected) {
        if (response.getStatusCode() != expected) {
            throw new AssertionError(
                    "Expected status " + expected +
                            " but was " + response.getStatusCode()
            );
        }
        return this;
    }

    public ResponseAssertions hasResponseTimeBelow(long millis) {
        if (response.getTime() > millis) {
            throw new AssertionError(
                    "Response time exceeded limit: " + response.getTime()
            );
        }
        return this;
    }

    public ResponseAssertions hasFistName(String firstName){
        CreateBookingResponse created = ResponseMapper.map(response, CreateBookingResponse.class);
        return this;
    }

    public ResponseAssertions hasLastName(String lastName){
        CreateBookingResponse created = ResponseMapper.map(response, CreateBookingResponse.class);
        return this;
    }

    public ResponseAssertions hasPrice(int price){
        CreateBookingResponse created = ResponseMapper.map(response, CreateBookingResponse.class);
        return this;
    }

    public ResponseAssertions matchesSchema(String schemaPath) {
        response.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath));
        return this;
    }

    public Response getResponse() {
        return response;
    }
}
