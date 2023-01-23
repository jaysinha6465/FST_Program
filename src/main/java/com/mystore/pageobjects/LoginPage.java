/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;



public class LoginPage extends BaseClass {
	
	Action action= new Action();
	
	
	@FindBy(xpath="//*[@data-action='customer-menu-toggle']")
	private WebElement switchtoggle;
	
	@FindBy(xpath="//a[text()='My Account']")
	private WebElement myaccount;
	
	@FindBy(xpath="//a[contains(text(),'Sign Out')]")
	private WebElement signOut;
	
	@FindBy(xpath="//a[text()='Address Book']")
	private WebElement addressBook;
	
	@FindBy(xpath="//span[text()='Add New Address']")
	private WebElement addNewAddress;
	
	
	@FindBy(xpath="//input[@id='email_address']")
	private WebElement emailaddress;
	
	@FindBy(xpath="//input[@id='firstname']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@id='lastname']")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@id='telephone']")
	private WebElement telephone;
	
	@FindBy(xpath="//input[@id='street_1']")
	private WebElement street1;
	
	@FindBy(xpath="//input[@id='city']")
	private WebElement cty;
	
	
	@FindBy(xpath="//input[@id='zip']")
	private WebElement postcode;
	
	@FindBy(xpath="//input[@id='primary_billing']")
	private WebElement defaultbilling;
	
	@FindBy(xpath="//*[@class='action save primary']")
	private WebElement saveaddress;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='pass']")
	private WebElement password;

	
	@FindBy(xpath="//input[@id='password']")
	private WebElement newaccountpassword;
	
	@FindBy(xpath="//input[@id='password-confirmation']")
	private WebElement 	accountconfirmationpassword;
	

	@FindBy(xpath="//span[contains(text(),'Sign In')]")
	private WebElement signInBtn;
	
	@FindBy(xpath="//a[@data-ui-id='default-billing-edit-link']")
	private WebElement editbillingaddress;
	
	
	@FindBy(name="email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	@FindBy(xpath="//a[contains(@href,'create')]")
	private WebElement createAccountBtn;
	
	@FindBy(xpath="//*[contains(@title,'Create')]")
	private WebElement createLumaNewAccountBtn;
	
	
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uname, String pswd, HomePage homePage) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.JSClick(getDriver(), signInBtn);
		Thread.sleep(2000);
		homePage=new HomePage();
		return homePage;
	}
	
	public void loginluma(String uname, String pswd) {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.JSClick(getDriver(), signInBtn);
		//Thread.sleep(2000);
		
	}
	
	public void signout() {
		action.JSClick(getDriver(), switchtoggle);
		action.JSClick(getDriver(), signOut);
	
	}
	
	
	public AddressPage clickOnActionSwitch(String uname,String pswd,AddressPage addressPage,String fname,String lname,String pnumber,
			String staddress,String city,String state,String zipcode,String country) throws Throwable {
		
		action.JSClick(getDriver(), switchtoggle);
		
		action.JSClick(getDriver(), myaccount);
		
		action.JSClick(getDriver(), addressBook);
		
		action.scrollByVisibilityOfElement(getDriver(), addNewAddress);
		
		action.JSClick(getDriver(), addNewAddress);
		
		action.type(firstname, fname);
		
		action.type(lastname, lname);
		
		action.type(telephone, pnumber);
		
		action.type(street1, staddress);
		
		action.type(cty, city);
		
		Select drpCountry = new Select(driver.findElement(By.name("country_id")));
		drpCountry.selectByVisibleText(country);
		
		Select drpState= new Select(driver.findElement(By.name("region_id")));
		drpState.selectByVisibleText(state);
		
		action.type(postcode, zipcode);
		
		Thread.sleep(5000);
		
		//action.JSClick(getDriver(), defaultbilling);
		//Thread.sleep(2000);
		
		action.JSClick(getDriver(), saveaddress);
		
		action.JSClick(getDriver(), myaccount);
		
		action.scrollByVisibilityOfElement(getDriver(), editbillingaddress);
		
		action.JSClick(getDriver(), editbillingaddress);
		
		
		addressPage=new AddressPage();
		return addressPage;
		
		
	}
	
	public AddressPage login(String uname, String pswd, AddressPage addressPage) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(getDriver(), signInBtn);
		Thread.sleep(2000);
		addressPage=new AddressPage();
		return addressPage;
	}
	
	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		action.type(emailForNewAccount, newEmail);
		action.click(getDriver(), createNewAccountBtn);
		return new AccountCreationPage();
	}
	public AccountCreationPage createNewLumaAccount(String newEmail,String password) throws Throwable {
		
		action.click(getDriver(), createAccountBtn);
		
		action.type(firstname, "TC08_Luma");
		action.type(lastname, "TC08_LumaLast");
		
		action.type(emailaddress, newEmail);
		
		action.type(newaccountpassword, password);
		
		action.type(accountconfirmationpassword, password);
		
		action.click(getDriver(), createLumaNewAccountBtn);
		return new AccountCreationPage();
	}
	
	
}






