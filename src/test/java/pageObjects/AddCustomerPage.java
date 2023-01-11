package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
    public WebDriver ldriver;
    public AddCustomerPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(ldriver,this);
    }

    //Find all elements in the apge
    By lnkCustomers_menu= By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
    By lnkCustomer_item=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");

    By btnAddnew=By.xpath("//a[normalize-space()='Add new']"); //Add new button

    By txtEmail=By.xpath("//input[@id='Email']");
    By txtPassword=By.xpath("//input[@id='Password']");
    By txtFirstName=By.xpath("//input[@id='FirstName']");
    By txtLastName=By.xpath("//input[@id='LastName']");

    By rdMaleGender=By.xpath("//input[@id='Gender_Male']");
    By rdFemaleGender=By.xpath("//input[@id='Gender_Female']");

    By txtDob=By.xpath("//input[@id='DateOfBirth']");

    By txtCompanyNmae=By.xpath("//input[@id='Company']");

    By chkTxpExempt=By.xpath("//input[@id='IsTaxExempt']");

    By drpNewsLetter=By.xpath("//div[@class='input-group-append']//div[@role='listbox']");

    By txtCustomerRoles = By.xpath("//div[@class='input-group-append input-group-required']//div[@role='listbox']");
    By lstItemAdministrator=By.xpath("//li[contains(text(),'Administrators')]");
    By lstForummoderator=By.xpath("//li[contains(text(),'Forum Moderators')]");
    By lstGuests=By.xpath("//li[contains(text(),'Guests')]");
    By lstRegistered=By.xpath("//li[contains(text(),'Registered')]");
    By lstVendors=By.xpath("//li[contains(text(),'Registered')]");

    By drpMgrOfvendor=By.xpath("//*[@id='VendorId']");

    By btnSave=By.xpath("//button[@name='save']");

    By actmsg=By.xpath("//div[@class='alert alert-success alert-dismissable']");

//Actions Methods

    public String getPageTitle()
    {
        return ldriver.getTitle();
    }

    public void clickOnCustomersMenu() throws InterruptedException {
        Thread.sleep(3000);
        ldriver.findElement(lnkCustomers_menu).click();
    }

    public void clickOnCustomersMenuItem() throws InterruptedException {
        Thread.sleep(3000);
        ldriver.findElement(lnkCustomer_item).click();
    }

    public void clickOnAddNew()
    {
        ldriver.findElement(btnAddnew).click();
    }

    public void setEmail(String email)
    {
        ldriver.findElement(txtEmail).sendKeys(email);
    }

    public void setPassword(String password)
    {
        ldriver.findElement(txtPassword).sendKeys(password);
    }

    public void setFirstName(String Fname)
    {
        ldriver.findElement(txtFirstName).sendKeys(Fname);
    }

    public void setLastName(String Lname)
    {
        ldriver.findElement(txtLastName).sendKeys(Lname);
    }

    public void setGender(String gender)
    {
        if(gender.equalsIgnoreCase("Male"))
        {
            ldriver.findElement(rdMaleGender).click();
        }
        else if(gender.equalsIgnoreCase("Female"))
        {
            ldriver.findElement(rdFemaleGender).click();
        }
        else
        {
            ldriver.findElement(rdMaleGender).click();
        }
    }

    public void setDob(String dob)
    {
        ldriver.findElement(txtDob).sendKeys(dob);
    }

    public void setCompanyName(String cname)
    {
        ldriver.findElement(txtCompanyNmae).sendKeys(cname);
    }

    public void setCustomerRoles(String role) throws InterruptedException {

        Thread.sleep(3000);
        ldriver.findElement(txtCustomerRoles).click();
        WebElement lstrole = null;
        if(role.equals("Administrators"))
        {
            lstrole=ldriver.findElement(lstItemAdministrator);
        }
        else if(role.equals("Forum Moderators"))
        {
            lstrole=ldriver.findElement(lstForummoderator);
        }
        else if(role.equals("Guests"))
        {
            lstrole= ldriver.findElement(lstGuests);
        }
        else if (role.equals("Registered"))
        {
            lstrole=ldriver.findElement(lstRegistered);
        }
        else if(role.equals("Vendors"))
        {
            lstrole=ldriver.findElement(lstVendors);
        }
        Thread.sleep(3000);
        lstrole.click();
    }

    public void manageOfVendors(String value) throws InterruptedException {
        Thread.sleep(3000);
        Select drp=new Select(ldriver.findElement(drpMgrOfvendor));
        drp.selectByVisibleText(value);
    }

    public void clickSave()
    {
        ldriver.findElement(btnSave).click();
    }











}
