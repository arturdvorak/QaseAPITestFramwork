package api;

import models.Suite;

public class SuiteAdapter extends BaseAdapter {
    String uriAdd = "suite/" + newProjectCode;
    int suiteID;

    public int addSuite(Suite suite) {
        suiteID = post(uriAdd, gson.toJson(suite), 200)
                .body().path("id");
        System.out.println(suiteID);
        return suiteID;
    }
}
