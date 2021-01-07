package tests;

import api.ProjectAdapter;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected ProjectAdapter projectAdapter;

    @BeforeClass(description = "TBD")
    public void setUp() {
        projectAdapter = new ProjectAdapter();
    }
}
