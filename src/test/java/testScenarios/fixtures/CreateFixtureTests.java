package testScenarios.fixtures;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.createFixture.Fixture;
import testScenarios.BaseTest;

import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;

public class CreateFixtureTests extends BaseTest {

    @Test(description = "Ensure the newly added fixture has a TeamId of \"home\"", groups = {"fixtures"})
    public void newlyAddedFixtureTeamId() {
        String fixtureId = storeNewFixtureHelper.createFixtureAndReturnFixtureId();
        Response response = when().get(BASE_URL + "/fixtures");
        Fixture[] responseBody = gson.fromJson(response.body().asString(), Fixture[].class);

        for (Fixture fixture : responseBody) {
            if (fixture.getFixtureId().equalsIgnoreCase(fixtureId)) {
                assertThat(fixture.getFootballFullState().getTeams().get(0).getTeamId(), is(equalToIgnoringCase("HOME")));
            }
        }
    }
}
