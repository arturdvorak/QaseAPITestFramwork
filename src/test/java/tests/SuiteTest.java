package tests;

import api.ProjectAdapter;
import models.ProjectFactory;
import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {
    ProjectFactory projectFactory = new ProjectFactory();

    @Test(description = "Create new test suite")
    public void createNewTestSuite() {
        projectAdapter.addProject(projectFactory.getProject());
    }
}
