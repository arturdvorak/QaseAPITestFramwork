package api;

import com.google.gson.Gson;
import models.Project;
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

    public Response post(String uri, Project project) {
        return
                given()
                        .header("Token", System.getenv().getOrDefault("token", PropertyReader.getProperty("token")))
                        .header("Content-Type", "application/json")
                        .body(gson.toJson(project))
                        .when()
                        .post(urlAPI + uri)
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();
    }
}
