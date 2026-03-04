package models.booking;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BookingDates(
        @JsonProperty("checkin") String checkin,
        @JsonProperty("checkout") String checkout){
}