package Pages;

import Base.PageSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageSetUp {
    public ProductPage(WebDriver driver) { super(driver); }

    @FindBy(id="group_1") WebElement SizeChoice;
    @FindBy(id="quantity_wanted") WebElement QuantityChoice;
    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button") WebElement AddToCartButton;
    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div/span[2]") WebElement Discount;
    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/button") WebElement PopUpContinue;
    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a") WebElement PopUpCheckout;


    public boolean CheckDis(){return Discount.isDisplayed();}

    public void ChooseSize(String siz)
    {
        SizeChoice.click();
        switch(siz)
    {
        case "S": WebElement SizeS = driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[1]"));
            SizeS.click();
            break;
        case "M": WebElement SizeM = driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]"));
            SizeM.click();
            break;
        case "L": WebElement SizeL = driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[3]"));
            SizeL.click();
            break;
        case "XL": WebElement SizeXL = driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[4]"));
            SizeXL.click();
            break;

    }



    }
    public void ChooseQuantity(String q){
        QuantityChoice.click();
        QuantityChoice.clear();
        QuantityChoice.sendKeys(q);

    }


    public void AddToCart(){AddToCartButton.click();}
    public void GoToCheckout(){PopUpCheckout.click();}
}
