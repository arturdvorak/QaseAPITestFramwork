package tests;

import models.ErrorFields;
import models.Suite;
import models.SuiteFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {
    SuiteFactory suiteFactory = new SuiteFactory();
    protected int suiteId;

    @Test(description = "Create new suite: critical path", enabled = false)
    public void createNewSuite() {
        Suite suite = suiteFactory.getSuite();
        suiteId = suiteAdapter.addSuite(suite, projectCode).getId();
        Suite actualSuite = suiteAdapter.getSuite(projectCode, suiteId);
        Assert.assertEquals(actualSuite, suite);
    }

    @Test(description = "Create new suite: empty title")
    public void createNewSuiteWithEmptyTitle() {
        Suite suite = Suite.builder()
                .description(usFaker.company().catchPhrase())
                .preconditions(usFaker.lorem().word())
                .build();

        ErrorFields error = ErrorFields.builder()
                .errorField("title")
                .errorMessage("Title is required")
                .build();

        ErrorFields actualError = suiteAdapter.addSuite(suite, projectCode, 500).get(0);
        Assert.assertEquals(actualError, error);
    }
}
