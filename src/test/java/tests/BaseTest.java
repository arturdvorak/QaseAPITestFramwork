package tests;

import api.ProjectAdapter;
import api.SuiteAdapter;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import models.ProjectFactory;
import org.testng.annotations.BeforeClass;
import utils.PropertyReader;

import java.util.Locale;

public class BaseTest {
    protected ProjectAdapter projectAdapter;
    protected SuiteAdapter suiteAdapter;
    protected String projectCode;
    protected ProjectFactory projectFactory;
    protected static Faker usFaker;

    @BeforeClass(description = "TBD")
    public void setUp() {
        RestAssured.baseURI =  System.getenv().getOrDefault("url", PropertyReader.getProperty("url"));
        projectAdapter = new ProjectAdapter();
        suiteAdapter = new SuiteAdapter();
        projectFactory = new ProjectFactory();
        projectCode = projectAdapter.addProject(projectFactory.getProject());
        usFaker = new Faker(new Locale("en-US"));
    }
}
