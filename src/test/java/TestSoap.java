import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.xml.XmlPath;
import java.util.List;
import java.util.stream.Collectors;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestSoap {
    // არ მუშაობდა ესენი და სხვა გზით დავწერე
//    ObjectFactory objectFactory = new ObjectFactory();
//    String url = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
//    String action = "http://www.oorsprong.org/websamples.countryinfo/CountryInfoServiceSoapType/ListOfCountryNamesGroupedByContinentRequest";

    private final String URL = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/ListOfContinentsByName";

    @Test
    public void validateContinentsResponse() {
        Response response = given()
                .when()
                .get(URL)
                .then()
                .statusCode(200)
                .extract().response();

        XmlPath xmlPath = new XmlPath(response.asString());

        List<String> sNames = xmlPath.getList("ArrayOftContinent.tContinent.sName");
        List<String> sCodes = xmlPath.getList("ArrayOftContinent.tContinent.sCode");

        assertThat(sNames.size(), greaterThan(0));

        assertThat(sNames, not(empty()));

        String sNameForAN = xmlPath.getString("ArrayOftContinent.tContinent.find { it.sCode == 'AN' }.sName");
        Assert.assertEquals(sNameForAN,"Antarctica");

        Assert.assertEquals(sNames.getLast(),"The Americas");

        Assert.assertEquals((int)sNames.size(),sNames.stream().distinct().count());

        sNames.stream()
                .map(sName -> sName.toLowerCase().startsWith("the ") ? sName.substring(4) : sName)
                .map(modifiedName -> modifiedName.substring(0, 2).toUpperCase())
                .forEach(abbreviation -> {
                    if (!sCodes.contains(abbreviation)) {
                        throw new AssertionError("Code for continent abbreviation " + abbreviation + " not found in sCodes.");
                    }
                });

        assertThat(sCodes, everyItem(matchesPattern("[A-Z]{2}")));

        List<String> sortedSNames = sNames.stream().sorted().collect(Collectors.toList());
        assertThat(sNames, equalTo(sortedSNames));

        assertThat(sNames, hasItems("Africa", "Antarctica", "Asia", "Europe", "The Americas", "Ocenania"));

        String oceania = xmlPath.getString("ArrayOftContinent.tContinent.find { it.sCode == 'OC' }.sName");
        assertThat(oceania, equalTo("Ocenania"));

        List<String> filteredSNames = sNames.stream()
                .filter(name -> name.startsWith("A") && name.endsWith("ca"))
                .collect(Collectors.toList());
        assertThat(filteredSNames, not(empty()));

        assertThat(sNames, everyItem(not(matchesPattern(".*\\d.*"))));
    }
}