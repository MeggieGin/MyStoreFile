package TestTask2;

import Pages.*;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LogAndBuy {
    WebDriver driver;
    String orderID;
    String Payment;
    @Given("^Registered user is on MyStore login website$")
    public void registeredUserIsOnMyStoreLoginWebsite() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/Drive/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");

    }

    @When("^User is logged in with (.*) and (.*) and gets to MyStore main profile$")
    public void userIsLoggedInWithEmailAndPassword(String mail, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LogInAs(mail,password);
        LoggedInUserPage loggedInUserPage = new LoggedInUserPage(driver);
        String PageMark = loggedInUserPage.CheckLogIn();
        Assert.assertEquals("User is not on profile page", "Your account", PageMark);
        loggedInUserPage.GoToMainPage();
    }

    @And("^Goes to MyStores main page and searches (.*)$")
    public void goesToMyStoresMainPage(String product) {
        HomePage homePage = new HomePage(driver);
        homePage.Product(product);
    }

    @And("^Chooses (.*) they want to buy$")
    public void choosesProduct(String product) {
        SearchOutcomePage searchOutcomePage = new SearchOutcomePage(driver);
        searchOutcomePage.PickProduct(product);
    }

    @And("^Checks if product is on a discount$")
    public void checksIfProductIsOnADiscount() {
        ProductPage productPage = new ProductPage(driver);
        boolean Dis = productPage.CheckDis();
        if(Dis){System.out.println("Product is on discount");}
    }
    @And ("Chooses right SIZE (.*)")
    public void choosesRightSize(String size)
    {
        ProductPage productPage = new ProductPage(driver);
        productPage.ChooseSize(size);
    }

    @And ("Chooses (.*) they want to order")
    public void choosesQuantityTheyWantToOrder(String quantity) {
       ProductPage productPage = new ProductPage(driver);
       productPage.ChooseQuantity(quantity);
    }

    @And("^Adds product to cart and goes to the cart$")
    public void addsProductToCart() {
        ProductPage productPage = new ProductPage(driver);
        productPage.AddToCart();
        productPage.GoToCheckout();
    }


    @And("^Fallows to checkout$")
    public void fallowsToCheckout() {
        CartPage cartPage = new CartPage(driver);
        cartPage.box();
    }

    @And("^Selects (.*) and continues to shipping method$")
    public void selectsAddressOption(String address) {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.AddressChoice(address);

    }


    @And("^User chooses (.*) and continues to payment method")
    public void userChoosesShippingMethod(String shipping) {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.ShippingChoice(shipping);

    }

    @And ("^User chooses payment (.*)$")
    public void UserChoosesPaymentMethod(String payment) {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.PaymentChoice(payment);
    }

    @And ("User accepts terms of service and submits order with obligation to pay")
    public void userAcceptsTermsOfService() {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.AcceptAndFin();

    }

//
//        @And("User goes to History and Detail of orders through profile page")
//        public void userGoesToHistoryAndDetailOfOrders() {
//            LoggedInUserPage loggedInUserPage = new LoggedInUserPage(driver);
//            loggedInUserPage.GoToHistorySection();
//        }
//
//        @Then("^Program checks if shown value of the order is correct$")
//        public void programChecksIfShownValueOfTheOrderIsCorrect() {
//        }
//
//        @Then("^Program checks if shown status of the order is correct$")
//        public void programChecksIfShownStatusOfTheOrderIsCorrect() {
//
//        }

    @Then("^User gets Order confirmation and Makes screenshot$")
    public void userGetsOrderConfirmation() throws IOException {
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.SaveDetails();
        driver.quit();
    }
}

