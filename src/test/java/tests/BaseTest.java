package tests;

import api.ProjectAdapter;
import api.SuiteAdapter;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected ProjectAdapter projectAdapter;
    protected SuiteAdapter suiteAdapter;

    @BeforeClass(description = "TBD")
    public void setUp() {
        projectAdapter = new ProjectAdapter();
        suiteAdapter = new SuiteAdapter();
    }
}
