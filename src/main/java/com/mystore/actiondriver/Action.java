/**
 * 
 */
package com.mystore.actiondriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actioninterface.ActionInterface;
import com.mystore.base.BaseClass;


public class Action extends BaseClass implements ActionInterface {

	@Override
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}

	@Override
	public void click(WebDriver driver, WebElement ele) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();

	}

	@Override
	public boolean findElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			// System.out.println("Location not found: "+locatorName);
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully Found element at");

			} else {
				System.out.println("Unable to locate element at");
			}
		}
		return flag;
	}

	@Override
	public boolean isDisplayed(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("The element is Displayed");
			} else {
				System.out.println("The element is not Displayed");
			}
		} else {
			System.out.println("Not displayed ");
		}
		return flag;
	}

	@Override
	public boolean isSelected(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isSelected();
			if (flag) {
				System.out.println("The element is Selected");
			} else {
				System.out.println("The element is not Selected");
			}
		} else {
			System.out.println("Not selected ");
		}
		return flag;
	}

	@Override
	public boolean isEnabled(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isEnabled();
			if (flag) {
				System.out.println("The element is Enabled");
			} else {
				System.out.println("The element is not Enabled");
			}
		} else {
			System.out.println("Not Enabled ");
		}
		return flag;
	}

	/**
	 * Type text at location
	 * 
	 * @param locatorName
	 * @param text
	 * @return - true/false
	 */
	@Override
	public boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			// logger.info("Entered text :"+text);
			flag = true;
		} catch (Exception e) {
			System.out.println("Location Not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter value");
			}

		}
		return flag;
	}

	@Override
	public boolean selectBySendkeys(String value,WebElement ele) {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Select value from the DropDown");		
			} else {
				System.out.println("Not Selected value from the DropDown");
				// throw new ElementNotFoundException("", "", "")
			}
		}
	}

	/**
	 * select value from DropDown by using selectByIndex
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param index       : Index of value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 * 
	 */
	@Override
	public boolean selectByIndex(WebElement element, int index) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Index");
			} else {
				System.out.println("Option not selected by Index");
			}
		}
	}

	/**
	 * select value from DD by using value
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param value       : Value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */

	@Override
	public boolean selectByValue(WebElement element,String value) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Value");
			} else {
				System.out.println("Option not selected by Value");
			}
		}
	}

	/**
	 * select value from DropDown by using selectByVisibleText
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param visibletext : VisibleText wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */

	@Override
	public boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by VisibleText");
			} else {
				System.out.println("Option not selected by VisibleText");
			}
		}
	}

	@Override
	public boolean mouseHoverByJavaScript(WebElement ele) {
		boolean flag = false;
		try {
			WebElement mo = ele;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, mo);
			flag = true;
			return true;
		}

		catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("MouseOver Action is performed");
			} else {
				System.out.println("MouseOver Action is not performed");
			}
		}
	}

	@Override
	public boolean JSClick(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			// driver.executeAsyncScript("arguments[0].click();", element);

			flag = true;

		}

		catch (Exception e) {
			throw e;

		} finally {
			if (flag) {
				System.out.println("Click Action is performed");
			} else if (!flag) {
				System.out.println("Click Action is not performed");
			}
		}
		return flag;
	}

	@Override
	public boolean switchToFrameByIndex(WebDriver driver,int index) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(index);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with index \"" + index + "\" is selected");
			} else {
				System.out.println("Frame with index \"" + index + "\" is not selected");
			}
		}
	}

	/**
	 * This method switch the to frame using frame ID.
	 * 
	 * @param idValue : Frame ID wish to switch
	 * 
	 */
	@Override
	public boolean switchToFrameById(WebDriver driver,String idValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(idValue);
			flag = true;
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with Id \"" + idValue + "\" is selected");
			} else {
				System.out.println("Frame with Id \"" + idValue + "\" is not selected");
			}
		}
	}

	/**
	 * This method switch the to frame using frame Name.
	 * 
	 * @param nameValue : Frame Name wish to switch
	 * 
	 */
	@Override
	public boolean switchToFrameByName(WebDriver driver,String nameValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(nameValue);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is selected");
			} else if (!flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
			}
		}
	}

	@Override
	public boolean switchToDefaultFrame(WebDriver driver) {
		boolean flag = false;
		try {
			driver.switchTo().defaultContent();
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				// SuccessReport("SelectFrame ","Frame with Name is selected");
			} else if (!flag) {
				// failureReport("SelectFrame ","The Frame is not selected");
			}
		}
	}

	@Override
	public void mouseOverElement(WebDriver driver,WebElement element) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				System.out.println(" MouserOver Action is performed on ");
			} else {
				System.out.println("MouseOver action is not performed on");
			}
		}
	}

	@Override
	public boolean moveToElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);
			// actions.moveToElement(driver.findElement(locator)).build().perform();
			actions.moveToElement(ele).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean mouseover(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(ele).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			/*
			 * if (flag) {
			 * SuccessReport("MouseOver ","MouserOver Action is performed on \""+locatorName
			 * +"\""); } else {
			 * failureReport("MouseOver","MouseOver action is not performed on \""
			 * +locatorName+"\""); }
			 */
		}
	}
	@Override
	public boolean draggable(WebDriver driver,WebElement source, int x, int y) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDropBy(source, x, y).build().perform();
			Thread.sleep(5000);
			flag = true;
			return true;

		} catch (Exception e) {
		
			return false;
			
		} finally {
			if (flag) {
				System.out.println("Draggable Action is performed on \""+source+"\"");			
			} else if(!flag) {
				System.out.println("Draggable action is not performed on \""+source+"\"");
			}
		}
	}
	@Override
	public boolean draganddrop(WebDriver driver,WebElement source, WebElement target) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDrop(source, target).perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("DragAndDrop Action is performed");
			} else if(!flag) {
				System.out.println("DragAndDrop Action is not performed");
			}
		}
	}
	
	@Override
	public boolean slider(WebDriver driver,WebElement ele, int x, int y) {
		boolean flag = false;
		try {
			// new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
			// .perform();
			new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
			Thread.sleep(5000);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Slider Action is performed");
			} else {
				System.out.println("Slider Action is not performed");
			}
		}
	}
	
	@Override
	public boolean rightclick(WebDriver driver,WebElement ele) {
		boolean flag = false;
		try {
			Actions clicker = new Actions(driver);
			clicker.contextClick(ele).perform();
			flag = true;
			return true;
			// driver.findElement(by1).sendKeys(Keys.DOWN);
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("RightClick Action is performed");
			} else {
				System.out.println("RightClick Action is not performed");
			}
		}
	}
	
	@Override
	public boolean switchWindowByTitle(WebDriver driver,String windowTitle, int count) {
		boolean flag = false;
		try {
			Set<String> windowList = driver.getWindowHandles();

			String[] array = windowList.toArray(new String[0]);

			driver.switchTo().window(array[count-1]);

			if (driver.getTitle().contains(windowTitle)){
				flag = true;
			}else{
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			//flag = true;
			return false;
		} finally {
			if (flag) {
				System.out.println("Navigated to the window with title");
			} else {
				System.out.println("The Window with title is not Selected");
			}
		}
	}
	@Override
	public boolean switchToNewWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[1].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				System.out.println("Window is Navigated with title");				
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}
	@Override
	public boolean switchToOldWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[0].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				System.out.println("Focus navigated to the window with title");			
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}
	@Override
	public int getColumncount(WebElement row) {
		List<WebElement> columns = row.findElements(By.tagName("td"));
		int a = columns.size();
		System.out.println(columns.size());
		for (WebElement column : columns) {
			System.out.print(column.getText());
			System.out.print("|");
		}
		return a;
	}
	
	@Override
	public int getRowCount(WebElement table) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int a = rows.size() - 1;
		return a;
	}
	
	
	/**
	 * Verify alert present or not
	 * 
	 * @return: Boolean (True: If alert preset, False: If no alert)
	 * 
	 */
	@Override
	public boolean Alert(WebDriver driver) {
		boolean presentFlag = false;
		Alert alert = null;

		try {
			// Check the presence of alert
			alert = driver.switchTo().alert();
			// if present consume the alert
			alert.accept();
			presentFlag = true;
		} catch (NoAlertPresentException ex) {
			// Alert present; set the flag

			// Alert not present
			ex.printStackTrace();
		} finally {
			if (!presentFlag) {
				System.out.println("The Alert is handled successfully");		
			} else{
				System.out.println("There was no alert to handle");
			}
		}

		return presentFlag;
	}
	@Override
	public boolean launchUrl(WebDriver driver,String url) {
		boolean flag = false;
		try {
			driver.navigate().to(url);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Successfully launched \""+url+"\"");				
			} else {
				System.out.println("Failed to launch \""+url+"\"");
			}
		}
	}
	
	@Override
	public boolean isAlertPresent(WebDriver driver) 
	{ 
		try 
		{ 
			driver.switchTo().alert(); 
			return true; 
		}   // try 
		catch (NoAlertPresentException Ex) 
		{ 
			return false; 
		}   // catch 
	}
	
	@Override
	public String getTitle(WebDriver driver) {
		boolean flag = false;

		String text = driver.getTitle();
		if (flag) {
			System.out.println("Title of the page is: \""+text+"\"");
		}
		return text;
	}
	
	@Override
	public String getCurrentURL(WebDriver driver)  {
		boolean flag = false;

		String text = driver.getCurrentUrl();
		if (flag) {
			System.out.println("Current URL is: \""+text+"\"");
		}
		return text;
	}
	
	public String getPageheader(WebDriver driver) {
		
		String text = driver.findElement(By.xpath("//a[contains(@href,'computers')]")).getText();
		
		return text;		
		
	}
	
	public boolean isdisplayedAddNewComputerButton(WebDriver driver) {
		
		boolean elementdisplayed;
		
		elementdisplayed = driver.findElement(By.xpath("//*[@id='add']")).isDisplayed();
		
		return elementdisplayed;				
	}
	
public String gettextAddNewComputerButton(WebDriver driver) {
		
		String elementtext;
		
		elementtext = driver.findElement(By.xpath("//*[@id='add']")).getText();
		
		return elementtext;				
	}
	
public boolean isdisplayedTextboxTitlename(WebDriver driver) {
	
		boolean elementdisplayed;
		
		elementdisplayed = driver.findElement(By.xpath("//*[@id='searchbox']")).isDisplayed();
		
		return elementdisplayed;				
	}
	
public String getButtonFiltername(WebDriver driver) {
	
	String text = driver.findElement(By.xpath("//*[@id='searchsubmit']")).getAttribute("value");
	
	return text;				
}

public boolean isdisplayedbuttonFilterByName(WebDriver driver) {
	
	boolean text = driver.findElement(By.xpath("//*[@id='searchsubmit']")).isDisplayed();
	
	return text;				
}

public List<String> getheaderstable(WebDriver driver) {
	
	  List<String> allHeadersOfTable=new ArrayList<String>();
	 //allHeadersOfTable = driver.findElements(By.xpath("//table[@class='computers zebra-striped']/thead/tr[1]/th"));
	
	 //for(WebElement header:allHeadersOfTable )
	//for(int i = 1;i<=allHeadersOfTable.size();i++)
    //{
    	String headername1 = driver.findElement(By.xpath("//table[@class='computers zebra-striped']/thead/tr[1]/th[1]")).getText();
    	//System.out.println(header.getText());
    	System.out.println(headername1);
    	
    	String headername2 = driver.findElement(By.xpath("//table[@class='computers zebra-striped']/thead/tr[1]/th[2]")).getText();
    	//System.out.println(header.getText());
    	System.out.println(headername2);
    	
    	String headername3 = driver.findElement(By.xpath("//table[@class='computers zebra-striped']/thead/tr[1]/th[3]")).getText();
    	//System.out.println(header.getText());
    	System.out.println(headername3);
    	
    	String headername4 = driver.findElement(By.xpath("//table[@class='computers zebra-striped']/thead/tr[1]/th[4]")).getText();
    	//System.out.println(header.getText());
    	System.out.println(headername4);
    //}
    	allHeadersOfTable.add(headername1);
    	allHeadersOfTable.add(headername2);
    	allHeadersOfTable.add(headername3);
    	allHeadersOfTable.add(headername4);

return allHeadersOfTable;
}

public boolean computernamefiltered(WebDriver driver) {
	String celltext=null;
	boolean cpname = false;
//To locate table.
WebElement mytable = driver.findElement(By.xpath("//table[@class='computers zebra-striped']"));
//To locate rows of table. 
List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
//To calculate no of rows In table.
int rows_count = rows_table.size();
//Loop will execute till the last row of table.
for (int row = 0; row < rows_count; row++) {
    //To locate columns(cells) of that specific row.
    List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
    //To calculate no of columns (cells). In that specific row.
    int columns_count = Columns_row.size();
    //System.out.println("Number of cells In Row " + row + " are " + columns_count);
    //Loop will execute till the last cell of that specific row.
    for (int column = 0; column < columns_count; column++) {
        // To retrieve text from that specific cell.
         celltext = Columns_row.get(column).getText();
         if(celltext.equalsIgnoreCase("ACE")) {
        	 cpname = true;
        	 break;
         }
       // System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celltext);
    }
}
return cpname;
}
public WebElement wefilterByNameComputerbutton(WebDriver driver) {
	
	WebElement wefilterByNamebutton = driver.findElement(By.xpath("//*[@id='searchsubmit']"));
	
	return wefilterByNamebutton;
	
}

public WebElement webFilterBycomputername(WebDriver driver) {
	
	WebElement webFilterBy = driver.findElement(By.xpath("//*[@id='searchbox']"));
	
	return webFilterBy;
	
}



public String successfulmessage(WebDriver driver) {
	
	String msg = driver.findElement(By.xpath("//*[@class='alert-message warning']")).getText();
	System.out.println("Successfulmessagge"+msg);
	return msg ;
	
}
public WebElement wecreatecomputerbutton(WebDriver driver) {
	
	WebElement reatecomputerbutton = driver.findElement(By.xpath("//*[@class='btn primary']"));
	
	return reatecomputerbutton;
	
}

public WebElement wechoosecompanydropdownlist(WebDriver driver) {
	
	WebElement choosecompany = driver.findElement(By.id("company"));
	
	return choosecompany;	
}

public WebElement webelementcomputername(WebDriver driver) {
	
	WebElement computername = driver.findElement(By.id("name"));
	
	return computername;	
}

public String isredbackgroundcolor(WebDriver driver) throws InterruptedException {
	
	
	driver.findElement(By.xpath("//*[@id='add']")).click();
	driver.findElement(By.xpath("//*[@class='btn primary']")).click();
	
	List<WebElement> name = driver.findElements(By.tagName("label"));
	
	System.out.println(name.get(0).getCssValue("color"));
	
	Color loginButtonBackgroundColour = Color.fromString(name.get(0).getCssValue("color"));
	//System.out.println("loginButtonBackgroundColour"+loginButtonBackgroundColour.asHex());
	
	return loginButtonBackgroundColour.asHex();	
}

public boolean isdisplayedPagination(WebDriver driver) {
	
	boolean blndisplayed = driver.findElement(By.xpath("//*[@id='pagination']")).isDisplayed();
	
	return blndisplayed;				
}

public String gettextPagination(WebDriver driver) {
	
	String text = driver.findElement(By.xpath("//*[@id='pagination']")).getText();
	
	return text;				
}

	public String getFirstName(WebDriver driver)  {
		
		int fnamesize = driver.findElements(By.xpath("//*[@id='firstname' and @name='firstname']")).size();
		
		System.out.println("Current First Name size \""+fnamesize+"\"");

		String text = driver.findElement(By.xpath("//*[@id='firstname' and @name='firstname']")).getAttribute("value");
		
			System.out.println("Current First Name is: \""+text+"\"");
		
		return text;
	}
	
public String getLastName(WebDriver driver)  {
		

		String text = driver.findElement(By.xpath("//*[@id='lastname' and @name='lastname']")).getAttribute("value");
		
			System.out.println("Current Last Name is: \""+text+"\"");
		
		return text;
	}
	
public String getpnumber(WebDriver driver)  {
	

	String text = driver.findElement(By.xpath("//*[@id='telephone' and @name='telephone']")).getAttribute("value");
	
		System.out.println("Current phone number is: \""+text+"\"");
	
	return text;
}

public String getstaddress(WebDriver driver)  {
	

	String text = driver.findElement(By.xpath("//*[@id='street_1']")).getAttribute("value");
	
		System.out.println("Current street address is: \""+text+"\"");
	
	return text;
}

public String getcity(WebDriver driver)  {
	

	String text = driver.findElement(By.xpath("//*[@id='city']")).getAttribute("value");
	
		System.out.println("Current city is: \""+text+"\"");
	
	return text;
}

public String getstate(WebDriver driver)  {
	

	String text = driver.findElement(By.xpath("//*[@id='region']")).getAttribute("value");
	
		System.out.println("Current state is: \""+text+"\"");
	
	return text;
}

public String getzipcode(WebDriver driver)  {
	

	String text = driver.findElement(By.xpath("//*[@id='zip']")).getAttribute("value");
	
		System.out.println("Current zipcode is: \""+text+"\"");
	
	return text;
}

public String getcountry(WebDriver driver)  {
	

	String text = driver.findElement(By.xpath("//*[@id='country']")).getAttribute("value");
	
		System.out.println("Current country is: \""+text+"\"");
	
	return text;
}



	
	@Override
	public boolean click1(WebElement locator, String locatorName) {
		boolean flag = false;
		try {
			locator.click();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Able to click on \""+locatorName+"\"");
			} else {
				System.out.println("Click Unable to click on \""+locatorName+"\"");
			}
		}

	}
	
	@Override
	public void fluentWait(WebDriver driver,WebElement element, int timeOut) {
	    Wait<WebDriver> wait = null;
	    try {
	        wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(20))
	        	    .pollingEvery(Duration.ofSeconds(2))
	        	    .ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        element.click();
	    }catch(Exception e) {
	    }
	}
	@Override
	public void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Override
	public void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	@Override
	public void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}
	@Override
	public String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		String newImageString = "http://localhost:9191/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				+ dateName + ".png";
		
		return newImageString;
	}
	@Override
	public String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}

}
