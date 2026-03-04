package models.booking;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BookingRequest(
        @JsonProperty("firstname") String firstname,
        @JsonProperty("lastname")String lastname,
        @JsonProperty("totalprice") int totalPrice,
        @JsonProperty("depositpaid") boolean depositPaid,
        @JsonProperty("bookingdates") BookingDates bookingDates,
        @JsonProperty("additionalneeds") String additionalNeeds
){
}
