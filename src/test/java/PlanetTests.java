import ge.tbc.testautomation.steps.PlanetSteps;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class PlanetTests {

    private final PlanetSteps steps = new PlanetSteps();

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
