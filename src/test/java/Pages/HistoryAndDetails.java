package Pages;

import Base.PageSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HistoryAndDetails extends PageSetUp {

    public HistoryAndDetails(WebDriver driver) { super(driver); }

    @FindBy() WebElement OrderReference;
    @FindBy() WebElement TotalPrice;
    @FindBy() WebElement Status;

}
