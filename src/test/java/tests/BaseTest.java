package tests;

import api.ProjectAdapter;
import api.SuiteAdapter;
import io.restassured.RestAssured;
import models.ProjectFactory;
import org.testng.annotations.BeforeClass;
import utils.PropertyReader;

public class BaseTest {
    protected ProjectAdapter projectAdapter;
    protected SuiteAdapter suiteAdapter;
    protected String newProjectCode;
    protected ProjectFactory projectFactory;

    @BeforeClass(description = "TBD")
    public void setUp() {
        RestAssured.baseURI =  System.getenv().getOrDefault("url", PropertyReader.getProperty("url"));
        projectAdapter = new ProjectAdapter();
        suiteAdapter = new SuiteAdapter();
        projectFactory = new ProjectFactory();
        newProjectCode = projectAdapter.addProject(projectFactory.getProject());
    }
}
