package com.mystore.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.testcases.*;
import com.mystore.utility.Log;


public class LumaAddressPageTest extends BaseClass{
	
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	private AddressPage addressPage;
	private LoginLumaPageTest loginLumaPageTest;
	
	 
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)

	public void addressTest(String uname, String pswd,String fname,String lname,String pnumber,
			String staddress,String city,String state,String zipcode,String country) throws Throwable {
	
	//,String fname,String lname,String pnumber,
	//String staddress,String city,String state,String zipcode,String country) throws Throwable {
		
		loginLumaPageTest= new LoginLumaPageTest();
		loginPage = new LoginPage();
		
		Log.info("user is going to click on SignIn");
		
		loginLumaPageTest.loginTest(uname, pswd);
		
		Log.startTestCase("AddressTest");
		indexPage= new IndexPage();
		Log.info("user is going to click on User Profile");
		
		Thread.sleep(2000);
		//getDriver().findElement(By.xpath("//*[@class='customer-welcome']")).click();
		
		addressPage=loginPage.clickOnActionSwitch(uname,pswd,addressPage,fname,lname,pnumber,
		staddress,city,state,zipcode,country);
		
		Log.info("Validate Saved Address");
	    
	    String actualfirstname=addressPage.getfirstname();
	    String actuallastname=addressPage.getlastname();
	    String actualpnumber=addressPage.getpnumber();
	    String actualstaddress=addressPage.getstaddress();
	    String actualcity=addressPage.getcity();
	    String actualstate=addressPage.getstate();
	    String actualzipcode=addressPage.getzipcode();
	    String actualcountry=addressPage.getcountry();
	    
	    
	    System.out.println("ActualURL"+ actualfirstname);
	    System.out.println("ActualURL"+ actuallastname);
	    //String expectedURL="https://magento.softwaretestingboard.com/";
	    Log.info("Verifying All the fields of Address");
	   if(actualfirstname.equalsIgnoreCase(fname) && actuallastname.equalsIgnoreCase(lname) &&
			   actualpnumber.equalsIgnoreCase(pnumber) && actualstaddress.equalsIgnoreCase(staddress)
			   && actualcity.equalsIgnoreCase(city) && actualstate.equalsIgnoreCase(state) &&
			   actualzipcode.equalsIgnoreCase(zipcode) && actualcountry.equalsIgnoreCase("IN")) {
	    Log.info("New Address is Validated");
	    }
	    Log.endTestCase("Validate Address Test");
	}

}

	


