package ge.tbc.testautomation.data.models.Responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import util.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record Planet(
        String name,
        String rotation_period,
        String orbital_period,
        String diameter,
        String climate,
        String gravity,
        String terrain,
        String surface_water,
        String population,
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime created,
        String edited,
        String url,
        List<String> residents,
        List<String> films
) {}
