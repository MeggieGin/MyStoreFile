package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageSetUp {
    public static WebDriver driver;

    public PageSetUp(WebDriver driver) {
        PageSetUp.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
