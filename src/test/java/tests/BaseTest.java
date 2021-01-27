package tests;

import api.CaseAdapter;
import api.ProjectAdapter;
import api.SuiteAdapter;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import models.CaseFactory;
import models.ProjectFactory;
import models.SuiteFactory;
import org.testng.annotations.BeforeTest;
import utils.PropertyReader;

import java.util.Locale;

public class BaseTest {
    protected ProjectAdapter projectAdapter;
    protected SuiteAdapter suiteAdapter;
    protected CaseAdapter caseAdapter;
    protected ProjectFactory projectFactory;
    protected SuiteFactory suiteFactory;
    protected CaseFactory caseFactory;
    protected static Faker usFaker;

    @BeforeTest(description = "TBD")
    public void setUp() {
        RestAssured.baseURI =  System.getenv().getOrDefault("url", PropertyReader.getProperty("url"));
        projectAdapter = new ProjectAdapter();
        suiteAdapter = new SuiteAdapter();
        caseAdapter = new CaseAdapter();
        projectFactory = new ProjectFactory();
        suiteFactory = new SuiteFactory();
        caseFactory = new CaseFactory();
        usFaker = new Faker(new Locale("en-US"));
    }
}
