package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver ldriver;
    public LoginPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(id="Email")
    WebElement txtEmail;

    @FindBy(id="Password")
    WebElement txtPassword;

    @FindBy(xpath="//button[contains(text(),'Log in')]")
    WebElement btnLogin;

    @FindBy(linkText = "Logout")
    WebElement btnLogout;

    public void setUsername(String email)
    {
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setPassword(String password)
    {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLogin()
    {
        btnLogin.click();
    }

    public void clickLogout()
    {
        btnLogout.click();
    }

}
