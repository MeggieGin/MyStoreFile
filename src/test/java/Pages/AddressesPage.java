package Pages;

import Base.PageSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressesPage extends PageSetUp {

    public AddressesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[1]") WebElement SignOut;
    @FindBy(partialLinkText = "Create new address")  WebElement AddNewAddressButton;
    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li/a")  WebElement AddFirstAddress;
    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")  WebElement AddedSuccesfuly;
    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")  WebElement DeleteSuccesfuly;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]/span") WebElement ExistingAddresses;


    public void AddAddress() { AddNewAddressButton.click();}

    public String Confirmation() { return AddedSuccesfuly.getText(); }

    public void DeleteLastAddress() { ExistingAddresses.click(); }

    public String DeleteConfirmation() { return DeleteSuccesfuly.getText(); }


}
