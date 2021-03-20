package Pages;

import Base.PageSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageSetUp {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name="s") WebElement SearchBox;
    @FindBy(partialLinkText = "Hummingbird printed sweater") WebElement SearchedProduct;

    public void Product(String product){
        SearchBox.sendKeys(product);
        SearchBox.submit();
    }

}
