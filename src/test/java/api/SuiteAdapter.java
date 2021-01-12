package api;

import io.restassured.response.Response;
import models.Suite;

import static org.hamcrest.CoreMatchers.equalTo;

public class SuiteAdapter extends BaseAdapter {
    String uriAdd = "suite/";
    int suiteId;

    public int addSuite(Suite suite, String projectCode) {
        Response response = post(uriAdd + projectCode, gson.toJson(suite), 200);
        response.body().path("status", String.valueOf(equalTo("true")));
        return response.body().path("result.id");
    }

    public void getSuiteByIdAndVerify(String projectCode, int suiteId, Suite suite) {
        Response response = get(uriAdd + projectCode + "/" + suiteId,200);
        response.body().path("id.title", String.valueOf(equalTo(suite.getTitle())));
        response.body().path("id.parent_id", String.valueOf(equalTo(null)));
        response.body().path("id.description", String.valueOf(equalTo(suite.getDescription())));
        response.body().path("id.preconditions", String.valueOf(equalTo(suite.getPreconditions())));
        //should we check other fields?
    }
}