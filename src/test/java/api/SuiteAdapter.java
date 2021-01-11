package api;

import models.Suite;

public class SuiteAdapter extends BaseAdapter {
    String uriAdd = "suite/";
    int suiteId;

    public int addSuite(Suite suite, String projectCode) {
        suiteId = post(uriAdd + projectCode, gson.toJson(suite), 200)
                .body().path("result.id");
        System.out.println(suiteId);
        return suiteId;
    }
}
