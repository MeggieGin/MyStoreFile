package TestTask1;

import Pages.*;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class LoginAndAddAdressTest {
    WebDriver driver;

    @Given("^User is on MyStore login website$")
    public void userIsOnMyStoreLoginWebsite() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/Drive/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().setScriptTimeout(4, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");

    }

    @When("^User loges in with (.*) and (.*) and gets to user profile page$")
    public void userLoggsInWithEmailAndPasswordAndGetsToUserProfilePage(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LogInAs(email, password);
        loginPage.CheckError();
    }


    @And("^Goes to website with addresses through the tile$")
    public void goesToWebsiteWithAddressysThroughTheTile() {
        LoggedInUserPage loggedInUserPage = new LoggedInUserPage(driver);
        loggedInUserPage.GoToAddressSection();
    }

    @And("^Goes to website adding new address through button$")
    public void goesToWebsiteAddingNewAddressThroughButton() {
        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.AddAddress();
    }

    @And("^Fills (.*), (.*), (.*), (.*), (.*)$")
    public void fillsAliasCityZipCountryPhone(String Alias, String City, String Zip, String Adress, String Phone) {
        NewAddressPage newAddressPage = new NewAddressPage(driver);
        newAddressPage.FillAddressForm(Alias, Adress, Zip, City, Phone);
    }

    @Then("^Program gets confirmation that form was filled the right way$")
    public void programGetsConfirmationThatFormWasFilledTheRightWay() {
        AddressesPage addressesPage = new AddressesPage(driver);
        String confirmation = addressesPage.Confirmation();
        Assert.assertEquals("Address successfully added!", confirmation);
    }

    @And("^Added Address is deleted$")
    public void addedAdressIsDeleted() {
        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.DeleteLastAddress();
    }

    @Then("^Program gets confirmation of deleting the address$")
    public void programGetsConfirmationOfDeletingTheAdress() {
        AddressesPage addressesPage = new AddressesPage(driver);
        String confirmation = addressesPage.DeleteConfirmation();
        Assert.assertEquals("Address successfully deleted!", confirmation);
        driver.quit();
    }
}
