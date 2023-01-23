/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Hitendra
 *
 */
public class AddressPage extends BaseClass {
	
	Action action= new Action();
	
	String fname,lname,pnumber,staddress,city,state,zipcode,country;
	
	@FindBy(id="firstname")
	private WebElement FirstName;
	
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public ShippingPage clickOnCheckOut() throws Throwable {
		action.click(getDriver(), proceedToCheckOut);
		return new ShippingPage();
	}
	
	public String getfirstname() throws Throwable {
		fname = action.getFirstName(getDriver());
		
		return fname;
	}
	
	public String getlastname() throws Throwable {
		lname = action.getLastName(getDriver());
		
		return lname;
	}
	
	public String getpnumber() throws Throwable {
		pnumber = action.getpnumber(getDriver());
		
		return pnumber;
	}
	
	public String getstaddress() throws Throwable {
		staddress = action.getstaddress(getDriver());
		
		return staddress;
	}
	
	public String getcity() throws Throwable {
	 city = action.getcity(getDriver());
		
		return city;
	}
	
	public String getstate() throws Throwable {
		 state = action.getstate(getDriver());
			
			return state;
		}
	public String getzipcode() throws Throwable {
		 zipcode = action.getzipcode(getDriver());
			
			return zipcode;
		}
	
	public String getcountry() throws Throwable {
		 country = action.getcountry(getDriver());
			
			return country;
		}

}
