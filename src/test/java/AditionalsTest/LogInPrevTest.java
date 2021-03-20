package AditionalsTest;

import Pages.LoggedInUserPage;
import Pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LogInPrevTest {
    WebDriver driver;
    @Given("^user is on MyStore login website$")
    public void userIsOnMyStoreLoginWebsite() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/Drive/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().setScriptTimeout(4, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");

    }

    @When("^User tries to log in without giving any data$")
    public void userTriesToLogInWithoutGivingAnyData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LogInAs("","");
    }

    @Then("^User gets notification about luck of proper data$")
    public void userGetsNotificationAboutLuckOfProperData() {
        LoginPage loginPage = new LoginPage(driver);
        String note = loginPage.CheckError();
        Assert.assertEquals("Incorrect Data", note);
    }

    @When("^User loges in wrong log in data (.*) and (.*)$")
    public void userLogesInWrongLogInDataEmailAndPassword(String mail,String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LogInAs(mail, password);
    }

    @Then("^User gets notification about filling wrong data$")
    public void userGetsNotificationAboutFillingWrongData() {
        LoginPage loginPage = new LoginPage(driver);
        String message = loginPage.CheckError();
        Assert.assertEquals("Incorrect Data",message);
    }

    @When("^User loges in with correct (.*) and correct (.*)$")
    public void userLogesInWithCorrectEmailAndCorrectPassword(String mail, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LogInAs(mail,password);
    }

    @Then("^User gets to user profile page$")
    public void userGetsToUserProfilePage() {
        LoggedInUserPage loggedInUserPage = new LoggedInUserPage(driver);
        String PageMark = loggedInUserPage.CheckLogIn();
        Assert.assertEquals("User is not on profile page", "Your account", PageMark);
        driver.quit();
    }
}
