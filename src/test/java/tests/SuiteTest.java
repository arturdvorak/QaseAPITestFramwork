package tests;

import models.Suite;
import models.SuiteFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {
    SuiteFactory suiteFactory = new SuiteFactory();
    protected int suiteId;

    @Test(description = "Create new suite")
    public void createNewSuite() {
        Suite suite = suiteFactory.getSuite();
        suiteId = suiteAdapter.addSuite(suite, projectCode);
        Suite actualSuite = suiteAdapter.getSuite(projectCode, suiteId, suite);
        Assert.assertEquals(actualSuite, suite);
    }
}
