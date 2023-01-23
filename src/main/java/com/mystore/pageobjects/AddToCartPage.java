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
public class AddToCartPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(id="qty")
	private WebElement quantity;
	
	@FindBy(name="group_1")
	private WebElement size;
	
	@FindBy(xpath="//span[text()='Add to Cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	private WebElement addToCartMessag;
	
	@FindBy(xpath="//*[contains(text(),'Proceed to Checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	@FindBy(xpath="//span[contains(text(),'My Cart')]")
	private WebElement buttonCart;
	
	
	//@FindBy(xpath="//button[@data-role='opc-continue' and @type='submit']")
	//@FindBy(xpath="//*[text()='Next']")
	//@FindBy(xpath="//*[@class='cf-tweet-this cf-tt-target cf-tt-out-of-bounds cf-tt-out-of-bounds-bottom cf-tt-element-attached-bottom cf-tt-element-attached-center cf-tt-target-attached-top cf-tt-target-attached-center']")
	@FindBy(xpath="//span[@data-bind='i18n: 'Next'']")
	private WebElement searchNextButton;
	
	
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterQuantity(String quantity1) throws Throwable {
		action.type(quantity, quantity1);
	}
	
	public void selectSize(String size1) throws Throwable {
		action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() throws Throwable {
		action.JSClick(getDriver(), addToCartBtn);
	}
	
	public boolean validateAddtoCart() throws Throwable {
		action.fluentWait(getDriver(), addToCartMessag, 10);
		return action.isDisplayed(getDriver(), addToCartMessag);
	}
	
	public OrderPage clickOnCheckOut() throws Throwable {
		action.JSClick(getDriver(), buttonCart);
		action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
		action.JSClick(getDriver(), proceedToCheckOutBtn);
		
		Thread.sleep(3000);
		action.scrollByVisibilityOfElement(getDriver(),searchNextButton);
		
		action.JSClick(getDriver(),searchNextButton);
		return new OrderPage();
	}
	
}
