package models.booking;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateBookingResponse(
        @JsonProperty("bookingid") int bookingId,
        @JsonProperty("booking") BookingResponse booking
) {
}
