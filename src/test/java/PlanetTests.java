import ge.tbc.testautomation.steps.OrderSteps;
import ge.tbc.testautomation.steps.PlanetSteps;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class PlanetTests {

    PlanetSteps steps;

    @BeforeMethod
    public void setUp(){
        steps = new PlanetSteps();
        RestAssured.filters(new AllureRestAssured());
    }

    @Test
    public void validateTop3RecentPlanets() throws Exception {
        steps.fetchPlanets()
                .getMostRecentPlanets()
                .validateRecentPlanetFields();

        System.out.println("Top 3 recent planets: " + steps.getRecentPlanets());
    }

    @Test
    public void validateTopPlanetResidentUrl() throws Exception {
        steps.fetchPlanets()
                .getTopPlanetByRotation()
                .fetchFirstResidentUrl()
                .validateResidentUrl();

        System.out.println("Top planet by rotation period: " + steps.getTopPlanet());
        System.out.println("Resident URL of the top planet: " + steps.getResidentUrl());
    }
}
