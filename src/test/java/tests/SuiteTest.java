package tests;

import models.SuiteFactory;
import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {
    SuiteFactory suiteFactory = new SuiteFactory();

    @Test(description = "Create new suite")
    public void createNewSuite() {
        suiteAdapter.addSuite(suiteFactory.getSuite(), newProjectCode);
    }
}
