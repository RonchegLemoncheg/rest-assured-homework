package ge.tbc.testautomation.steps;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ge.tbc.testautomation.data.models.Responses.Planet;
import ge.tbc.testautomation.data.models.Responses.PlanetResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PlanetSteps {

    private final List<Planet> planets = new ArrayList<>();
    private List<Planet> recentPlanets = new ArrayList<>();
    private Planet topPlanet;
    private String residentUrl;

    public PlanetSteps fetchPlanets() throws Exception {
        RestAssured.baseURI = "https://swapi.dev/api/planets/?format=json";
        Response response = given().get();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        PlanetResponse planetResponse = mapper.readValue(
                response.asString(), PlanetResponse.class
        );
        planets.clear();
        planets.addAll(planetResponse.results);
        return this;
    }

    public PlanetSteps getMostRecentPlanets() {
        planets.sort(Comparator.comparing(Planet::created).reversed());
        recentPlanets = planets.subList(0, Math.min(planets.size(), 3));
        return this;
    }

    public PlanetSteps validateRecentPlanetFields() {
        recentPlanets.forEach(this::validatePlanetFields);
        return this;
    }

    private void validatePlanetFields(Planet planet) {
        assert planet.name() != null : "Name is null";
        assert planet.rotation_period() != null : "Rotation period is null";
        assert planet.diameter() != null : "Diameter is null";
        assert planet.climate() != null : "Climate is null";
        assert planet.terrain() != null : "Terrain is null";
    }

    public PlanetSteps getTopPlanetByRotation() {
        topPlanet = planets.stream()
                .max(Comparator.comparingInt(p -> Integer.parseInt(p.rotation_period())))
                .orElseThrow(() -> new RuntimeException("No planets found"));
        return this;
    }

    public PlanetSteps fetchFirstResidentUrl() {
        if (topPlanet.residents().isEmpty()) {
            throw new RuntimeException("No residents available for the planet");
        }
        residentUrl = topPlanet.residents().getFirst();
        return this;
    }

    public PlanetSteps validateResidentUrl() {
        int statusCode = given().get(residentUrl).statusCode();
        assert statusCode == 200 : "Resident URL is not accessible, status code: " + statusCode;
        return this;
    }

    public List<Planet> getRecentPlanets() {
        return recentPlanets;
    }

    public Planet getTopPlanet() {
        return topPlanet;
    }

    public String getResidentUrl() {
        return residentUrl;
    }
}

