package ge.tbc.testautomation.data.models.Responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateBookingResponse {

    private int bookingId;

    private String firstname;

    private String lastname;

    private int totalprice;

    @JsonProperty("depositpaid")
    private Boolean deposit_paid;

    private BookingDates bookingdates;

    @JsonProperty("additionalneeds")
    private String additionalNeeds;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Builder
    public static class BookingDates {
        private String checkin;
        private String checkout;
    }

}

