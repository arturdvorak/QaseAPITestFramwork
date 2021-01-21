package api;

import io.restassured.response.Response;
import com.google.gson.reflect.TypeToken;
import models.ErrorFields;
import models.ErrorResult;
import models.Result;
import models.Suite;
import org.testng.Assert;

import java.util.ArrayList;

public class SuiteAdapter extends BaseAdapter {
    String uriAdd = "suite/";

    public Suite addSuite(Suite suite, String projectCode) {
        Response response = post(uriAdd + projectCode, gson.toJson(suite), 200);
        Result<Suite> result = gson.fromJson(response.asString(),
                new TypeToken<Result<Suite>>(){}.getType());
        Assert.assertTrue(result.isStatus());
        return result.getResult();
    }

    public ArrayList<ErrorFields> addSuite(Suite suite, String projectCode, boolean status, int expectedStatusCode) {
        Response response = post(uriAdd + projectCode, gson.toJson(suite), expectedStatusCode);
        ErrorResult result = gson.fromJson(response.asString(), ErrorResult.class);
        Assert.assertEquals(result.isStatus(), status);
        //System.out.println(result);
        return result.getErrorFields();
    }

    public Suite getSuite(String projectCode, int suiteId) {
        Response response = get(uriAdd + projectCode + "/" + suiteId,200);
        Result<Suite> result = gson.fromJson(response.asString(),
                new TypeToken<Result<Suite>>(){}.getType());
        return result.getResult();
    }
}
