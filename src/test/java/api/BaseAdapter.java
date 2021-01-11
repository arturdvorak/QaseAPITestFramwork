package api;

import com.google.gson.Gson;
import utils.PropertyReader;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class BaseAdapter {
    //String urlAPI = System.getenv().getOrDefault("url", PropertyReader.getProperty("url"));
    String newProjectCode;

    Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

    public Response post(String uri, String body, int expectedStatusCode) {
        return
                given()
                        .header("Token", System.getenv().getOrDefault("token", PropertyReader.getProperty("token")))
                        .header("Content-Type", MediaType.APPLICATION_JSON)
                        .body(body)
                        .when()
                        .post(baseURI + uri)
                        .then()
                        .log().ifError()
                        .statusCode(expectedStatusCode)
                        .extract().response();
    }
}
