package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.*;

public class IndexPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath ="//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']") 
	private WebElement productgear;
	
	@FindBy(xpath ="//span[contains(text(),'Bags')]") 
	private WebElement productbag;
	
	@FindBy(xpath = "//a[contains(@href,'/magento.softwaretestingboard.com')]") 
	private WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	private WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnSignInLuma() throws Throwable {
		
		action.fluentWait(getDriver(), signInBtn, 10);
		Thread.sleep(5000);
		action.JSClick(getDriver(), signInBtn);	
		
	}
	
public LoginPage clickOnSignIn() throws Throwable {
		
		action.fluentWait(getDriver(), signInBtn, 10);
		Thread.sleep(5000);
		action.JSClick(getDriver(), signInBtn);	
		return new LoginPage();
	}
	
	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String getMyStoreTitle() {
		String myStoreTitel=getDriver().getTitle();
		return myStoreTitel;
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		//action.type(searchProductBox, productName);
		//action.scrollByVisibilityOfElement(getDriver(), searchButton);
		
		action.JSClick(getDriver(), productgear);
		//action.scrollByVisibilityOfElement(getDriver(), productbag);
		action.JSClick(getDriver(), productbag);
		Thread.sleep(3000);
		return new SearchResultPage();
	}
	
	

}
