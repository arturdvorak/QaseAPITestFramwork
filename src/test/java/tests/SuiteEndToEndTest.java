package tests;

import models.Case;
import models.Suite;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuiteEndToEndTest extends BaseTest{
    private int suiteId;
    private String projectCode;
    private int caseId;

    @Test(description = "Create new project, new suite and new test case", groups = "creation", enabled = true)
    public void createNewTestSuiteAndTestCase() {
        projectCode = projectAdapter.addProject(projectFactory.getProject());

        Suite suite = suiteFactory.getSuite();
        suiteId = suiteAdapter.addSuite(suite, projectCode).getId();
        Suite actualSuite = suiteAdapter.getSuite(projectCode, suiteId);
        Assert.assertEquals(actualSuite, suite);

        Case testCase = caseFactory.getCase(suiteId);
        caseId = testCase.getId();
        caseAdapter.addCase(testCase, projectCode);
        Case actualTestCase = caseAdapter.getCase(projectCode, caseId);
        Assert.assertEquals(actualTestCase, testCase);
    }

    @Test(description = "Update created test suite", groups = "updating", dependsOnGroups = "creation", enabled = true) //Test case can't be update through API
    public void updateCreatedSuite() {
        Suite suiteToPut = Suite.builder()
                .id(suiteId)
                .title(RandomStringUtils.randomAlphabetic(10))
                .description(usFaker.company().catchPhrase())
                .preconditions(usFaker.lorem().word())
                .build();

        suiteAdapter.updateSuite(projectCode, suiteId, suiteToPut);
        Suite updatedSuite = suiteAdapter.getSuite(projectCode, suiteId);
        Assert.assertEquals(updatedSuite, suiteToPut);
    }

    @Test(description = "Delete created project", dependsOnGroups = "updating", enabled = true)
    public void deleteCreatedProject() {
        caseAdapter.deleteCase(projectCode, caseId);
        suiteAdapter.deleteSuite(projectCode, suiteId);
        //can't find API for project deleting
    }
}
