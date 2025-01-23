import ge.tbc.testautomation.data.DataSupplier;
import ge.tbc.testautomation.data.models.User.UserProfile;
import ge.tbc.testautomation.steps.AuthSteps;
import ge.tbc.testautomation.steps.ProfileSteps;
import ge.tbc.testautomation.steps.UserSteps;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AuthTest {
    UserSteps userSteps;
    AuthSteps authSteps;
    ProfileSteps profileSteps;
    UserProfile expectedProfile;

    @BeforeTest
    public void setUp(){
        userSteps = new UserSteps();
        authSteps = new AuthSteps();
        profileSteps = new ProfileSteps();
        expectedProfile = new UserProfile();
    }


    @Test(dataProvider = "userInfoProvider", dataProviderClass = DataSupplier.class)
    public void testUserCreationAndValidation(String email, String name, String password, String avatar) throws Exception {

        userSteps.createUser(email, name, password, avatar);
        authSteps.login(email, password);

        String accessToken = authSteps.getAccessToken();

        profileSteps.fetchProfile(accessToken);

        expectedProfile.setEmail(email);
        expectedProfile.setName(name);
        expectedProfile.setAvatar(avatar);

        profileSteps.validateProfile(expectedProfile);
    }
}
