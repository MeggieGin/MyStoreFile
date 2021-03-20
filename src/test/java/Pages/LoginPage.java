package Pages;

import Base.PageSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageSetUp {
    public LoginPage(WebDriver driver) { super(driver); }


    @FindBy(name = "email")
    WebElement login;
    @FindBy(name = "password")
    WebElement loginPassword;
    @FindBy(id = "submit-login")
    WebElement submittButton;
    @FindBy(partialLinkText = "Invalid format.")
    WebElement WrongEmailData;
    @FindBy(partialLinkText = "Authentication failed.")
    WebElement WrongPasswordData;
    @FindBy(partialLinkText = "No account? Create one here")
    WebElement newAccount;
    @FindBy(partialLinkText = "Forgot your password?")
    WebElement forgottenPassword;
    @FindBy(partialLinkText = "Please fill out this field") WebElement MissingElement;



    public void LogInAs(String email, String password) {
        login.sendKeys(email);
        loginPassword.sendKeys(password);
        submittButton.click();
    }

    public String CheckError() {
        if (WrongEmailData != null ||WrongPasswordData != null||MissingElement!=null) {
            return "Incorrect Data";
        }else{
            return "User logged in";
        }
    }
}
