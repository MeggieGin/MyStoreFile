package Pages;

import Base.PageSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchOutcomePage extends PageSetUp {

    public SearchOutcomePage(WebDriver driver) { super(driver); }

    @FindBy(name = "s") WebElement SearchBox;
    @FindBy(xpath = "//*[@id=\"js-product-list\"]/div[1]/article[1]/div/div[1]/h2/a") WebElement Product;

    public void PickProduct(String searchedProduct)
    {
        Product.click();
    }
}
