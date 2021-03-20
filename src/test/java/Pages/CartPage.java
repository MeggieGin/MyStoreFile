package Pages;

import Base.PageSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageSetUp {
    public CartPage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a") WebElement Checkout;

    public void box(){ Checkout.click();}
}
