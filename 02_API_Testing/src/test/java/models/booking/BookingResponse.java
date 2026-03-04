package models.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookingResponse(
        @JsonProperty("firstname") String firstname,
        @JsonProperty("lastname")String lastname,
        @JsonProperty("totalprice") int totalPrice,
        @JsonProperty("depositpaid") boolean depositPaid,
        @JsonProperty("bookingdates") BookingDates bookingDates,
        @JsonProperty("additionalneeds") String additionalNeeds
){
}
