package helpers;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static java.lang.String.format;
import static io.restassured.RestAssured.given;


public class Browserstack {

    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    public static String videoUrl(String sessionId) {

        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .log().all()
                .auth().basic(config.username(), config.password())
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
