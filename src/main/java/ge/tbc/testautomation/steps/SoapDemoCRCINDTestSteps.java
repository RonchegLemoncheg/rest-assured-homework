package ge.tbc.testautomation.steps;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.tempuri.Person;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class SoapDemoCRCINDTestSteps {
    public SoapDemoCRCINDTestSteps validatePerson(Person person) {
        // 1. Validate the presence of the FindPersonResult element
        MatcherAssert.assertThat(person, Matchers.notNullValue());

        // 2. Validate the person's name
        String name = person.getName();
        MatcherAssert.assertThat(name, Matchers.notNullValue());

        // 3. Validate the SSN value
        String ssn = person.getSSN();
        MatcherAssert.assertThat(ssn, Matchers.notNullValue());

        // 4. Validate the date of birth
        XMLGregorianCalendar dob = person.getDOB();
        MatcherAssert.assertThat(dob, Matchers.notNullValue());

        // 5. Validate the presence of the favorite colors
        List<String> favoriteColors = person.getFavoriteColors().getFavoriteColorsItem();
        MatcherAssert.assertThat(favoriteColors, Matchers.not(Matchers.empty()));

        // 6. Validate the person's last name
        String[] nameParts = name.split(" ");
        String lastName = nameParts[nameParts.length - 1];
        MatcherAssert.assertThat(lastName, Matchers.notNullValue());

        // 7. Check if the person has Red as one of their favorite colors
        MatcherAssert.assertThat(favoriteColors, Matchers.hasItem("Red"));

        // 8. Validate the number of characters in the SSN
        MatcherAssert.assertThat(ssn.length(), Matchers.equalTo(11));

        // 9. Check if both home and office addresses have street elements (using StreamAPI)
        boolean hasStreetElements = person.getHome().getStreet() != null && person.getOffice().getStreet() != null;
        MatcherAssert.assertThat(hasStreetElements, Matchers.is(true));

        // 10. Validate the combined city and state for the home address in one expression
        String homeCityState = person.getHome().getCity() + ", " + person.getHome().getState();
        MatcherAssert.assertThat(homeCityState, Matchers.notNullValue());

        // 11. Check if the SSN follows the pattern NNN-NN-NNNN (with digits only)
        MatcherAssert.assertThat(ssn, Matchers.matchesPattern("\\d{3}-\\d{2}-\\d{4}"));

        // 12. Ensure the person's age is calculated correctly based on the DOB
        LocalDate birthDate = person.getDOB().toGregorianCalendar().toZonedDateTime().toLocalDate();
        int calculatedAge = Period.between(birthDate, LocalDate.now()).getYears();
        MatcherAssert.assertThat((long) calculatedAge, Matchers.equalTo(person.getAge()));

        // 13. Validate that the office zip code is not the same as the home zip code
        String homeZip = person.getHome().getZip();
        String officeZip = person.getOffice().getZip();
        MatcherAssert.assertThat(homeZip, Matchers.not(Matchers.equalTo(officeZip)));
        return this;
    }
}
