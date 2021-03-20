package Pages;

import Base.PageSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAddressPage extends PageSetUp {

    public NewAddressPage(WebDriver driver) { super(driver); }

    @FindBy(name = "alias") WebElement Alias;
    @FindBy(name = "address1") WebElement AdressBox;
    @FindBy(name="postcode") WebElement ZipBox;
    @FindBy(name="city") WebElement CityBox;
    @FindBy(name="id_country") WebElement CountryBox;
    @FindBy(name="phone") WebElement PhoneBox;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button") WebElement SaveButton;
    @FindBy(name="id_address") WebElement adressId;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select/option[2]")  WebElement UK;
    String IdAdress = adressId.getText();

    public void FillAddressForm(String alias, String address, String zip, String city, String phone)
    {
        Alias.sendKeys(alias);
        AdressBox.sendKeys(address);
        ZipBox.sendKeys(zip);
        CityBox.sendKeys(city);
        PhoneBox.sendKeys(phone);
        CountryBox.click();
        UK.click();
        SaveButton.click();
    }
    public String getID()
    {
        return IdAdress;
    }

}
