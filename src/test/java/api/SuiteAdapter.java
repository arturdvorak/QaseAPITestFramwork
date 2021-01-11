package api;

import models.Suite;

public class SuiteAdapter extends BaseAdapter {
    String uriAdd = "suite/";
    int suiteID;

    public int addSuite(Suite suite, String projectCode) {
        System.out.println(uriAdd + projectCode);
        suiteID = post(uriAdd + projectCode, gson.toJson(suite), 200)
                .body().path("result.id");
        System.out.println(suiteID);
        return suiteID;
    }
}
