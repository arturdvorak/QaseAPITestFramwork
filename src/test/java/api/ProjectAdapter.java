package api;

import io.restassured.response.Response;
import models.Project;

import static org.hamcrest.CoreMatchers.equalTo;

public class ProjectAdapter extends BaseAdapter {
    String uriAdd = "project";

    public String addProject(Project project) {
        Response response =  post(uriAdd, gson.toJson(project), 200);
        response.body().path("status", String.valueOf(equalTo("true")));
        //System.out.println(response.body().path("result.code").toString());
        return response.body().path("result.code");
    }
}
