package api;

import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_OK;

public class CommentTest {

    private final static String BASIC_PATH = "https://jsonplaceholder.typicode.com/";

    @Test
    public static void shouldGetAComment() {
        String endpoint = "posts/2";
        given()
                .when()
                .get(BASIC_PATH + endpoint)
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .body(matchesJsonSchemaInClasspath("schemas/api/comment.json"));
    }
}
