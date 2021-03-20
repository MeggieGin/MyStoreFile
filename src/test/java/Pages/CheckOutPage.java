package Pages;

import Base.PageSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends PageSetUp {

    public CheckOutPage(WebDriver driver) { super(driver);}

    @FindBy(xpath = "//*[@id=\"id-address-delivery-address-10409\"]/header/label/span[1]/span") WebElement AddressButton;
    @FindBy(xpath = "//*[@id=\"checkout-addresses-step\"]/div/div/form/p[3]/a") WebElement AddNewAddress;
    @FindBy(name="address1") WebElement AdressBox;
    @FindBy(name="postcode") WebElement ZipBox;
    @FindBy(name="city") WebElement CityBox;
    @FindBy(name="id_country") WebElement CountryBox;
    @FindBy(name="phone") WebElement PhoneBox;
    @FindBy(xpath = "//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button") WebElement ContinueToShButton;
    @FindBy(id="delivery_option_1") WebElement PickUpBox;
    @FindBy(id="delivery_option_2") WebElement DeliveryBox;
    @FindBy(xpath = "//*[@id=\"js-delivery\"]/button") WebElement ContinueToPyButton;
    @FindBy(id="payment-option-1") WebElement PayByCheckBox;
    @FindBy(id="payment-option-2") WebElement PayByBankWire;
    @FindBy(id="conditions_to_approve[terms-and-conditions]") WebElement TermsOfUseBox;
    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button") WebElement OrderButton;
    @FindBy() WebElement OrderReference;

    public void AddressChoice(String address){
        if (!AddressButton.isSelected()){ AddressButton.click();}

        ContinueToShButton.click();
        ContinueToShButton.submit();
    }
    public void PaymentChoice(String pChoice){
        if(pChoice.equals("Bank wire"))
        {
            if(!PayByBankWire.isSelected()){PayByBankWire.click();}

        }else if (pChoice.equals("Check")){
           if(!PayByCheckBox.isSelected()){PayByCheckBox.click();} }
    }

    public void ShippingChoice(String shippingChoice){
        if(shippingChoice.equals("Pick up")){
          if (!PickUpBox.isSelected()){ PickUpBox.click();}
        }else if (shippingChoice.equals("Delivery")) {
            if (!DeliveryBox.isSelected()){ DeliveryBox.click(); }
        }

        ContinueToPyButton.submit();
        ContinueToPyButton.click();
    }

    public void AcceptAndFin() {
        TermsOfUseBox.click();
        OrderButton.click();
    }




}
