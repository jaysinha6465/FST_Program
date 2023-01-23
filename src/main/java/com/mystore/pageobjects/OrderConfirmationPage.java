/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Hitendra
 *
 */
public class OrderConfirmationPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//span[contains(text(),'Thank you for your purchase!')]")
	private WebElement confirmMessag;
	
	@FindBy(xpath="//a[contains(@href,'order_id')]")
	private WebElement ordernumber;
	
	
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateConfirmMessage() {
		String confirmMsg=confirmMessag.getText();
		return confirmMsg;
	}

	public String printordernumber() {
		String ordernumbergenerated=ordernumber.getText();
		return ordernumbergenerated;
	}

}
