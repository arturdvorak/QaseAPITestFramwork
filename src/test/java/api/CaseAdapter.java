package api;

import com.google.gson.reflect.TypeToken;
import io.restassured.response.Response;
import models.Result;
import models.Case;
import org.testng.Assert;

public class CaseAdapter extends BaseAdapter {
    String uriAdd = "case/";

    public void addCase(Case testCase, String projectCode) {
        Response response = post(uriAdd + projectCode, gson.toJson(testCase), 200);
        Result<Case> result = gson.fromJson(response.asString(),
                new TypeToken<Result<Case>>(){}.getType());
        Assert.assertTrue(result.isStatus());
    }

    public Case getCase(String projectCode, int caseId) {
        Response response = get(uriAdd + projectCode + "/" + caseId,200);
        Result<Case> result = gson.fromJson(response.asString(),
                new TypeToken<Result<Case>>(){}.getType());
        return result.getResult();
    }

    public void deleteCase(String projectCode, int caseId) {
        Response response = delete(uriAdd + projectCode + "/" + caseId, 200);
        Result<Case> result = gson.fromJson(response.asString(),
                new TypeToken<Result<Case>>(){}.getType());
        Assert.assertTrue(result.isStatus());
    }
}
