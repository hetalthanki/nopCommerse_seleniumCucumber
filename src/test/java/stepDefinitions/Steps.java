package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Steps extends BaseClass {

    @Before
    public void setup() throws IOException {
        //logger to add logs to project to view details output and status of output
        logger= Logger.getLogger("nopCommerse");
        PropertyConfigurator.configure("log4j.properties");

        //config.properties file reading and accesing to read data from it - data in key value pair
        configProp=new Properties();
        FileInputStream configpropfile=new FileInputStream("config.properties");
        configProp.load(configpropfile);

        //WebDriver object creation for different browser
        String br=configProp.getProperty("browser");
        if(br.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(br.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(br.equals("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

    }

    @Given("user launch chrome browser")
    public void user_launch_chrome_browser() {
        logger.info("******** launching browser **********");
        lp=new LoginPage(driver);
        driver.manage().window().maximize();
    }
    @When("user opens url {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        logger.info("launching URL");
    }
    @When("user enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        logger.info("providing login details");
        lp.setUsername(email);
        lp.setPassword(password);
    }
    @When("click on login")
    public void click_on_login() {
        logger.info("started login");
        lp.clickLogin();
    }
    @Then("page title should be {string}")
    public void page_title_should_be(String title) {
        String expTitle=title;
        String actTitle=driver.getTitle();
        Assert.assertEquals(expTitle,actTitle);
    }
    @When("user click on logout link")
    public void user_click_on_logout_link() throws InterruptedException {
        lp.clickLogout();
        Thread.sleep(3000);
    }
    @Then("close chrome browser")
    public void close_chrome_browser() {
            driver.quit();
    }


    //Add new customer stepDefinitions.....................................................
    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        acp=new AddCustomerPage(driver);
        String actTitle="Dashboard / nopCommerce administration";
        String expTitle=acp.getPageTitle();
        Assert.assertEquals(actTitle,expTitle);
    }
    @When("User clicks on customers menu")
    public void user_clicks_on_customers_menu() throws InterruptedException {
        acp.clickOnCustomersMenu();
    }
    @When("click on customers menu item")
    public void click_on_customers_menu_item() throws InterruptedException {
        acp.clickOnCustomersMenuItem();
    }
    @When("click on Add new button")
    public void click_on_add_new_button() {
        acp.clickOnAddNew();
    }
    @Then("User can view add new customer page")
    public void user_can_view_add_new_customer_page() {
        String actTitleaddnewcust=acp.getPageTitle();
        String expTitleaddnewcust="Add a new customer / nopCommerce administration";
        Assert.assertEquals(actTitleaddnewcust,expTitleaddnewcust);
    }
    @When("user enters customer info")
    public void user_enters_customer_info() throws InterruptedException {
        String email=randomString()+"@gmail.com";
        acp.setEmail(email);
        acp.setPassword("test123");
        acp.setFirstName("hetal");
        acp.setLastName("thanki");
        acp.setGender("Female");
        acp.setDob("6/10/88");
        acp.setCompanyName("Ambika");
        acp.setCustomerRoles("Forum Moderators");
        acp.manageOfVendors("Vendor 2");
    }
    @When("click on save button")
    public void click_on_save_button() {
        acp.clickSave();
    }
    @Then("user can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
    }


    //Search customer by entering email as search item
    @When("enter email as search item")
    public void enter_email_as_search_item() {
        scp=new SearchCustomerPage(driver);
        scp.setEmail("victoria_victoria@nopCommerce.com");
    }
    @When("click search button")
    public void click_search_button() throws InterruptedException {
        scp.clickOnSearch();
        Thread.sleep(3000);

    }
    @Then("User should found email in the search table")
    public void user_should_found_email_in_the_search_table() {
        boolean status=scp.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
        Assert.assertEquals(true,status);
    }

    //Search customer by entering name in search item
    @When("enter customer first name")
    public void enter_customer_first_name() {
        scp=new SearchCustomerPage(driver);
        scp.setSearchByFirstName("Victoria");
    }
    @When("enter customer last name")
    public void enter_customer_last_name() {
        scp.setSearchByLastName("Terces");
    }
    @Then("User should found name in the search table")
    public void user_should_found_name_in_the_search_table() {
        boolean status=scp.searchCustomerByName("Victoria Terces");
        Assert.assertEquals(true,status);
    }
}
