package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.util.List;

public class SearchCustomerPage {
    public WebDriver ldriver;
    WaitHelper waiyhelper;
    public SearchCustomerPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(ldriver,this);
        waiyhelper=new WaitHelper(ldriver);
    }


    @FindBy(how = How.ID,using = "SearchEmail")
    WebElement txtEmail;

    @FindBy(how = How.ID,using = "SearchFirstName")
    WebElement txtFirstname;

    @FindBy(how = How.ID,using = "SearchLastName")
    WebElement txtLastName;

    @FindBy(how = How.ID,using = "SearchMonthOfBirth")
    WebElement drpDobMonth;

    @FindBy(how = How.ID,using = "SearchDayOfBirth")
    WebElement drpDobDay;

    @FindBy(how = How.ID,using = "SearchRegistrationDateFrom")
    WebElement txtRegFromDt;

    @FindBy(how = How.ID,using = "SearchRegistrationDateTo")
    WebElement txtRegToDt;

    @FindBy(how = How.ID,using = "SearchLastActivityFrom")
    WebElement txtLastActFrm;

    @FindBy(how = How.ID,using = "SearchLastActivityTo")
    WebElement txtLastActTo;

    @FindBy(how = How.ID,using = "SearchCompany")
    WebElement txtCompany;

    @FindBy(how = How.ID,using = "SearchIpAddress")
    WebElement txtIPAddress;

    @FindBy(how = How.XPATH,using = "//div[@role='listbox']")
    WebElement txtCustomerRoles;

    @FindBy(how = How.XPATH,using = "//li[contains(text(),'Administrators')]")
    WebElement lstitemAdministrators;


    @FindBy(how = How.XPATH,using = "//li[contains(text(),'Forum Moderators')]")
    WebElement lstitemForumModerators;

    @FindBy(how = How.XPATH,using = "//li[contains(text(),'Guests')]")
    WebElement lstitemGuests;

    @FindBy(how = How.XPATH,using = "//li[contains(text(),'Registered')]")
    WebElement lstitemRegistered;


    @FindBy(how = How.XPATH,using = "//li[contains(text(),'Vendors')]")
    WebElement lstitemVendors;


    @FindBy(how = How.ID,using = "search-customers")
    WebElement btnSearch;

    @FindBy(how = How.XPATH,using = "//table[@id='customers-grid']")
    WebElement table;

    @FindBy(how = How.XPATH,using = "//table[@id='customers-grid']/tbody/tr")
    List<WebElement> tableRows;

    @FindBy(how = How.XPATH,using = "//table[@id='customers-grid']/tbody/tr/td")
    List<WebElement> tableColumns;

    @FindBy(how = How.XPATH,using = "//table[@Role='grid']")
    WebElement tableSearchResult;


    //Actions Method
    public void setEmail(String email)
    {
        waiyhelper.waitForElement(txtEmail,30);
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setSearchByFirstName(String fname)
    {
        waiyhelper.waitForElement(txtFirstname,30);
        txtFirstname.clear();
        txtFirstname.sendKeys(fname);
    }

    public void setSearchByLastName(String lname)
    {
        waiyhelper.waitForElement(txtLastName,30);
        txtLastName.clear();
        txtLastName.sendKeys(lname);
    }

    public void clickOnSearch()
    {
        btnSearch.click();
    }

    public int getnoofRows()
    {
        return (tableRows.size());
    }

    public int getnoofColumns()
    {
        return (tableColumns.size());
    }

    public boolean searchCustomerByEmail(String email)
    {
        boolean flag=false;
        for(int i=1;i<=getnoofRows();i++)
        {
            String emaiId = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
            if(emaiId.equals(email))
            {
                flag=true;
                break;
            }
        }
        return flag;
    }

    public boolean searchCustomerByName(String Name)
    {
        boolean flag=false;
        for(int i=1;i<=getnoofRows();i++)
        {
            String name = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
            String names[]=name.split(" ");
            if(names[0].equals("Victoria") && names[1].equals("Terces"))
            {
                flag=true;
                break;
            }
        }
        return flag;
    }
}
