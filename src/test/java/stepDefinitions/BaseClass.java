package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public LoginPage lp;
    public AddCustomerPage acp;
    public SearchCustomerPage scp;
    public static Logger logger;
    public Properties configProp;

    //generate random Email address
    public static String randomString()
    {
        String randomString1=RandomStringUtils.randomAlphabetic(5);
        return randomString1;
    }
}
