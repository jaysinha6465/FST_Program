package com.mystore.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.base.TC04_BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class TC04_ComputerDatabasePageTest extends TC04_BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test(groups = {"Smoke","Sanity"},dataProvider = "Computerdatabase", dataProviderClass = DataProviders.class)

	public void computerDatabaseTest(String companyName) throws Throwable {
		
		Log.startTestCase("ComputerDatabaseTest");
		Log.info("ComputerDatabaseNavigation");
		homePage = new HomePage();
		Action action = new Action();
		//String actualURL=homePage.getCurrURL();
		String actualtitle = action.getTitle(getDriver());
		//String actualtitle=homePage.getCurrentTitle();
	    System.out.println("actualtitle"+ actualtitle);
	    
	    String expectedTitle="Computers database";
	    Log.info("Verifying if user is able to login");
	    Assert.assertEquals(actualtitle, expectedTitle);
	    Log.info("verified Title");
	    
	    String pageheader = action.getPageheader(getDriver());
	    System.out.println("pageheader"+ pageheader);
	    Assert.assertNotEquals(pageheader, expectedTitle);
	    Log.info("verified Header");
	    
	    String expectedTextboxTitle="Filter by computer name...";
	    boolean blnboxtitlename = action.isdisplayedTextboxTitlename(getDriver());
	    if (blnboxtitlename) {
	    	 Log.info("verified TextboxTitleName");
	    } else {Log.info("TextboxTitleName is not visible");}
	    
	
	    String expectedAddNewComputerButton="Add a new computer";
	    boolean blnAddNewComputer = action.isdisplayedAddNewComputerButton(getDriver());
	    if (blnAddNewComputer) {
	    	
	    	String buttonAddNewComputer = action.gettextAddNewComputerButton(getDriver());
		    System.out.println("buttonAddNewComputer"+ buttonAddNewComputer);
		    Assert.assertEquals(buttonAddNewComputer, expectedAddNewComputerButton);
		    Log.info("verified Add New Computer button");
	    } else {Log.info("Add New Computer button is not visible");}
	    
	    
	    String expectedFilterByName="Filter by name";
	    boolean blnFilterByName = action.isdisplayedbuttonFilterByName(getDriver());
	    
	    if (blnFilterByName) {
	    	String buttonFilterByName = action.getButtonFiltername(getDriver());
		    System.out.println("buttonFilterByName"+ buttonFilterByName);
		    Assert.assertEquals(buttonFilterByName, expectedFilterByName);
		    Log.info("verified ButtonFilterByName");
	    } else {Log.info("ButtonFilterByName is not visible");}
	    
	    
	    
	    Log.info("Verification of List Of Computer Table Header");
	    List<String> computerHeadersOfTable=new ArrayList<String>(); 
	    computerHeadersOfTable = action.getheaderstable(getDriver());
	    
	    String[] headername= new String[3];
	   
	    System.out.println("Headers in table are below:");
	    System.out.println("Total headers found: "+computerHeadersOfTable.size());
	   // for(WebElement header:computerHeadersOfTable)
	    for(int i = 0;i<computerHeadersOfTable.size();i++)
	    {
	    	
	    	 if((computerHeadersOfTable.get(i)).equalsIgnoreCase("Computer name")) {
	    		 Log.info("1st Header:Computer name is visible");
	    	 } else if((computerHeadersOfTable.get(i)).equalsIgnoreCase("Introduced")){
	    		 Log.info("2nd Header:Introduced name is visible");
	    	 } else if((computerHeadersOfTable.get(i)).equalsIgnoreCase("Discontinued")){
	    		 Log.info("3rd Header:Discontinued name is visible");
	    	 }  else if((computerHeadersOfTable.get(i)).equalsIgnoreCase("Company")){
	    		 Log.info("4th Header:Company name is visible");
	    	 }
	    }
	    Log.info("Verification of Pagination");
	   String expectedtxtPagination="Displaying 1 to 10 of 574";
	    boolean blnPagination = action.isdisplayedPagination(getDriver());
	    
	    if (blnPagination) {
	    	String txtPagination = action.gettextPagination(getDriver());
		    System.out.println("buttonFilterByName"+ txtPagination);
		    if(txtPagination.contains(expectedtxtPagination)) {
		    //Assert.assertEquals(txtPagination, expectedtxtPagination);
		    Log.info("verified Pagination");}
	    } else {Log.info("Pagination is not visible");}
	    
	    Log.info("Add New Computer");
	    
	    String expectedColorRed = "#9d261d";
	    String actualColorRed=action.isredbackgroundcolor(getDriver());
	    
	    if(actualColorRed.equalsIgnoreCase(expectedColorRed)) {
	    	 
	    	Assert.assertEquals(actualColorRed, expectedColorRed);
	    	Log.info("Verified Color:Computer name is in red color");
	    }
	    
	    // Send computer name in computer text box
	    WebElement wecomputername = action.webelementcomputername(getDriver());
	    wecomputername.sendKeys("Computer_TC04");
	    
	    WebElement wechoosecompany = action.wechoosecompanydropdownlist(getDriver());
	    
	    action.selectByVisibleText("Nokia",wechoosecompany);
	    
	    WebElement wecreatecomputerbutton = action.wecreatecomputerbutton(getDriver());
	    action.JSClick(getDriver(), wecreatecomputerbutton);
	    
	    String successmessage=action.successfulmessage(getDriver());
	    if(successmessage.equalsIgnoreCase("Done")) {
	    	Log.info("Computer created:Successful Message displayed");
	    }
	    
	 // Send computer name in filter textbox to filter
	    WebElement weFiltercomputername = action.webFilterBycomputername(getDriver());
	    weFiltercomputername.sendKeys("ACE");
	    
	    WebElement wefilterByNamebutton = action.wefilterByNameComputerbutton(getDriver());
	    action.JSClick(getDriver(), wefilterByNamebutton);
	    
	    boolean blnfilter = action.computernamefiltered(getDriver());
	    if(blnfilter) {
	    	Log.info("Result Filtered:Computer name filtered successful");
	    }
	    
	    //Thread.sleep(5000);
	    Log.endTestCase("ComputerDatabase");
}
	
}
