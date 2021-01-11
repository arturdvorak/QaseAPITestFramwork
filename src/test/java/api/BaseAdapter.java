package api;

import com.google.gson.Gson;
import utils.PropertyReader;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class BaseAdapter {
    String urlAPI = System.getenv().getOrDefault("url", PropertyReader.getProperty("url"));

    Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

    public Response post(String uri, String body) {
        return
                given()
                        .header("Token", System.getenv().getOrDefault("token", PropertyReader.getProperty("token")))
                        .header("Content-Type", "application/json")
                        .body(body)
                        .when()
                        .post(urlAPI + uri)
                        .then()
                        .log().ifError()
                        .statusCode(200)
                        .extract().response();
    }
}
