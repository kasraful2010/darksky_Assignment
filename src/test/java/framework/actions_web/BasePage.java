package framework.actions_web;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.lang.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import stepdefinition.SharedSD;


public class BasePage {

	public void clickOn(By locator) throws InterruptedException {

		Thread.sleep(400);

			SharedSD.getDriver().findElement(locator).click();

		Thread.sleep(400);



	}

	public void clear(By locator) {
		try {
			SharedSD.getDriver().findElement(locator).clear();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public void sendText(By locator, String text) {
		try {
			SharedSD.getDriver().findElement(locator).sendKeys(text);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public String getText(By locator) {
		String text = null;
		try {
			text = SharedSD.getDriver().findElement(locator).getText();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}

		return text;
	}

	public String getHour(int range) {
		Date day = new Date(); //Getting current date
		SimpleDateFormat sdf = new SimpleDateFormat("ha"); //Formating day variable into a particular pattern
		String currentHour = sdf.format(day);
		return currentHour;
	}

	public void testArray(By locator) {
		List<WebElement> timeList = (List<WebElement>) SharedSD.getDriver().findElement(locator);

	}


	public void clickOnBrowserBackArrow() {
		SharedSD.getDriver().navigate().back();
	}

	public void clickOnBrowserForwardArrow() {
		SharedSD.getDriver().navigate().forward();
	}

	public void refreshBrowser() {
		SharedSD.getDriver().navigate().refresh();
	}

	public int subStringToInt(By locator, int start, int end) {
		String result = getText(locator).substring(start,end);
		return Integer.parseInt(result);
	}

}
