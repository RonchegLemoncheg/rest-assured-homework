package ge.tbc.testautomation.data.models.Requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

import lombok.*;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateBookingRequest {

    private Integer bookingId;
    @JsonProperty("firstname")
    private String first_name;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("totalprice")
    private int totalprice;

    @JsonProperty("depositpaid")
    private boolean depositpaid;

    private BookingDates bookingdates;

    private String additionalneeds;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Double saleprice;

    private String passportNo;

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

