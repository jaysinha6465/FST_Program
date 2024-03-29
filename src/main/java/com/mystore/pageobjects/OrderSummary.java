/**
 * 
 */
package com.mystore.pageobjects;

import java.security.PublicKey;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Hitendra
 *
 */
public class OrderSummary extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//span[contains(text(),'Place Order')]")
	private WebElement confirmOrderBtn;
	
	public OrderSummary() {
		PageFactory.initElements(getDriver(), this);
	}

	public OrderConfirmationPage clickOnconfirmOrderBtn() throws Throwable {
		action.JSClick(getDriver(), confirmOrderBtn);
		return new OrderConfirmationPage();
	}
	
}
