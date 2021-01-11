package tests;

import models.ProjectFactory;
import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {
    ProjectFactory projectFactory = new ProjectFactory();

    @Test(description = "Create, update and remove test suite")
    public void createNewTestSuite() {
        projectAdapter.addProject(projectFactory.getProject());
    }
}
