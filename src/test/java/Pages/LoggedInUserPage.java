package Pages;

import Base.PageSetUp;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedInUserPage extends PageSetUp {

    public LoggedInUserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"main\"]/header/h1")
    WebElement ProfilePageMark;
    @FindBy(xpath = "//*[@id=\"identity-link\"]/span/text()")
    WebElement Information;
    @FindBy(xpath = "//*[@id=\"history-link\"]/span/text()")
    WebElement HistoryAndDetails;
    @FindBy(xpath = "//*[@id=\"order-slips-link\"]/span/text()")
    WebElement CreditSlips;
    @FindBy(partialLinkText = "Addresses")
    WebElement Addresses;
    @FindBy(xpath = "//*[@id=\"address-link\"]/span")
    WebElement NewAddresses;
    @FindBy(xpath = "//*[@id=\"_desktop_logo\"]/a")
    WebElement MainPage;


    public void GoToAddressSection() {
        Addresses.click();
    }

    public void GoToHistorySection() {
        HistoryAndDetails.click();
    }

    public void GoToMainPage(){MainPage.click();}

    public String CheckLogIn() {
        return ProfilePageMark.getText();
    }

}

