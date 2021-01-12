package tests;

import models.Suite;
import models.SuiteFactory;
import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {
    SuiteFactory suiteFactory = new SuiteFactory();
    protected int suiteId;

    @Test(description = "Create new suite")
    public void createNewSuite() {
        Suite suite = suiteFactory.getSuite();
        suiteId = suiteAdapter.addSuite(suite, projectCode);
        suiteAdapter.getSuiteByIdAndVerify(projectCode, suiteId, suite);
    }
}
