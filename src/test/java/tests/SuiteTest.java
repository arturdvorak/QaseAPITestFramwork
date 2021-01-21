package tests;

import models.ErrorFields;
import models.Suite;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SuiteTest extends BaseTest {
    protected int suiteId;

    @Test(description = "Create new suite: title critical path", enabled = false)
    public void createNewSuite() {
        Suite suite = Suite.builder()
                .title(RandomStringUtils.randomAlphabetic(10))
                .position(1)
                .description(usFaker.company().catchPhrase())
                .preconditions(usFaker.lorem().word())
                .build();

        suiteId = suiteAdapter.addSuite(suite, projectCode).getId();
        Suite actualSuite = suiteAdapter.getSuite(projectCode, suiteId);
        Assert.assertEquals(actualSuite, suite);
    }

    @Test(description = "Create new suite: empty description" , enabled = false)
    public void createNewSuiteWithEmptyDescription() {
        Suite suite = Suite.builder()
                .title(RandomStringUtils.randomAlphabetic(10))
                .position(1)
                .preconditions(usFaker.lorem().word())
                .parentId(1)
                .build();

        suiteId = suiteAdapter.addSuite(suite, projectCode).getId();
        Suite actualSuite = suiteAdapter.getSuite(projectCode, suiteId);
        Assert.assertEquals(actualSuite, suite);
    }

    @Test(description = "Create new suite: empty title" , enabled = false)
    public void createNewSuiteWithEmptyTitle() {
        Suite suite = Suite.builder()
                .description(usFaker.company().catchPhrase())
                .preconditions(usFaker.lorem().word())
                .build();

        ErrorFields error = ErrorFields.builder()
                .errorField("title")
                .errorMessage("Title is required")
                .build();

        ErrorFields actualError = suiteAdapter.addSuite(suite, projectCode, false, 500).get(0);
        Assert.assertEquals(actualError, error);
    }

    @Test(description = "Create new suite: more than max length title", enabled = false)
    public void createNewSuiteWithMoreThanMaxLengthTitle() {
        Suite suite = Suite.builder()
                .title(RandomStringUtils.randomAlphabetic(256))
                .description(usFaker.company().catchPhrase())
                .preconditions(usFaker.lorem().word())
                .build();

        ErrorFields error = ErrorFields.builder()
                .errorField("title")
                .errorMessage("Title can't exceed 255 symbols")
                .build();

        ErrorFields actualError = suiteAdapter.addSuite(suite, projectCode, true, 200).get(0);
        Assert.assertEquals(actualError, error);
    }

    @Test(description = "Create new suite: invalid parent_id", enabled = false)
    public void createNewSuiteWithInvalidParentId() {
        Suite suite = Suite.builder()
                .title(RandomStringUtils.randomAlphabetic(10))
                .description(usFaker.company().catchPhrase())
                .preconditions(usFaker.lorem().word())
                .parentId(100)
                .build();

        ErrorFields error = ErrorFields.builder()
                .errorField("parent_id")
                .errorMessage("Parent suite not found")
                .build();

        ErrorFields actualError = suiteAdapter.addSuite(suite, projectCode, false, 200).get(0);
        Assert.assertEquals(actualError, error);
    }

    @Test(description = "Create new suite: empty title and invalid parent_id" , enabled = true)
    public void createNewSuiteWithEmptyTitleAndInvalidParentId() {
        Suite suite = Suite.builder()
                .description(usFaker.company().catchPhrase())
                .preconditions(usFaker.lorem().word())
                .parentId(100)
                .build();

        ArrayList<ErrorFields> errors = new ArrayList<>();
        errors.add(ErrorFields.builder()
                .errorField("title")
                .errorMessage("Title is required")
                .build());
        errors.add(ErrorFields.builder()
                .errorField("parent_id")
                .errorMessage("Parent suite not found")
                .build());

        ArrayList<ErrorFields> actualError = suiteAdapter.addSuite(suite, projectCode, false, 200);
        Assert.assertEquals(actualError, errors);
    }
}
