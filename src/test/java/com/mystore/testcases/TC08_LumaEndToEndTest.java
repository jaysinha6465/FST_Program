/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;
import com.mystore.utility.Log;


public class TC08_LumaEndToEndTest extends BaseClass {
	
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	private LoginPage loginPage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private OrderSummary orderSummary;
	private OrderConfirmationPage orderConfirmationPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Smoke","Sanity","Regression"}, dataProvider = "credentials", dataProviderClass = DataProviders.class) 
	
	public void endToEndTest(String uname, String pswd,String fname,String lname,String pnumber,
			String staddress,String city,String state,String zipcode,String country,String productName,String size,
			String qty) throws Throwable {
		
		Log.startTestCase("endToEndTest");
		index= new IndexPage();
		LumaAddressPageTest lumaAddressPageTest = new LumaAddressPageTest();
		
		TC08_LumaAccountCreationPageTest LumaAccountCreationPageTest = new TC08_LumaAccountCreationPageTest();
		
		LumaAccountCreationPageTest.verifyCreateAccountPageTest(uname, pswd);
		
		lumaAddressPageTest.addressTest(uname,pswd,fname,lname,pnumber,staddress,city,state,zipcode,country);
		
		searchResultPage=index.searchProduct(productName);
		
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		//addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		
		orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMsg="Thank you for your purchase!";
		Assert.assertEquals(actualMessage, expectedMsg);
		
		
		String actualOrderNumber=orderConfirmationPage.printordernumber();
		
		Log.endTestCase("actualOrderNumberCreated" +actualOrderNumber);
		Log.endTestCase("endToEndTest");
	}

}
