package tests;

import models.ProjectFactory;
import models.SuiteFactory;
import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {
    ProjectFactory projectFactory = new ProjectFactory();
    SuiteFactory suiteFactory = new SuiteFactory();

    @Test(description = "Create, update and remove test suite")
    public void createNewTestSuite() {
        projectAdapter.addProject(projectFactory.getProject());
        suiteAdapter.addSuite(suiteFactory.getSuite());
    }
}
