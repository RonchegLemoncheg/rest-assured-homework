package ge.tbc.testautomation.data.models.Responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import javax.validation.constraints.NotNull;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetResponse {
    @NotNull(message = "Results cannot be null")
    public List<Planet> results;
}

