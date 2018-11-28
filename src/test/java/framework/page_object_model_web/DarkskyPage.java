package framework.page_object_model_web;

import framework.actions_web.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import stepdefinition.SharedSD;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.text.ParseException;

public class DarkskyPage extends BasePage {

	private By textField = By.xpath("//input[@type='text']");
	private By search = By.xpath("//a[@class='searchButton']//img[@width='16']");
	private By currentTemp = By.xpath("//span[@class='summary swap']");
	private By lowTemp = By.xpath("//span[@class='currently']//span[2]//span[2]//span[2]");
	private By highTemp = By.xpath("//span[@class='summary-high-low']//span[3]");
	private By timeline = By.xpath("//div[@id='timeline']//div[@class='hours']//span[3]");
	private By expandOnTimeLine = By.xpath("//span[contains(text(),'Today')]");
	private By minTemp1 = By.cssSelector("#week > a.day.revealed > span.tempRange > span.minTemp");
	private By minTemp2 = By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']");
	private By maxTemp1 = By.cssSelector("#week > a:nth-child(2) > span.tempRange > span.maxTemp");
	private By maxTemp2 = By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']");
	private By timeMachine = By.xpath("//a[@class='button']");
	private By todaysDate = By.xpath("//td[@class='is-today']");

	public void clearTextField (){ clear(textField);}
	public void sendText(String text){sendText(textField, text);}
	public void clickOnSearch() throws InterruptedException {
		Thread.sleep(1200);
		clickOn(search);}

	public int getCurrentTemp() { return subStringToInt(currentTemp, 0, 2); }
	public int getLowTemp() { return  subStringToInt(lowTemp, 5, 7); }
	public int getHighTemp() { return subStringToInt(highTemp, 6, 8); }
	public void verifyTempRange() throws ParseException {
		int    current = getCurrentTemp(),
				low = getLowTemp(),
				high = getHighTemp();
		Assert.assertTrue(low <= current && current <= high,
				"Current temp (" + current + "˚) is not in between low (" + low + "˚) and high (" + high + "˚)"
		);
	}

	public void verifyTimelineIsDisplayed (){
		int count = 0, range = 0, match = 0;

		for (int i = 3; i <= 24; i+=2) {
			String name = SharedSD.getDriver().findElement
					(By.xpath("//div[@id='timeline']//div[@class='hours']//span["+ i +"]")).getText();
			if (getHour(range).contains(name));
			match +=1;
		}

	}

	public void expandTimeLine ()throws InterruptedException{ clickOn(expandOnTimeLine);}

	public void verifyLowAndHighTemp(){
		int min1 = getMin1();
		int min2 = getMin2();
		int max1 = getMax1();
		int max2 = getMax2();
		Assert.assertTrue(min1 ==min2);
		Assert.assertTrue(max1 ==max2);
	}
	public int getMin1(){return subStringToInt(minTemp1,0,2);}
	public int getMin2(){return subStringToInt(minTemp2,0,2);}
	public int getMax1(){return subStringToInt(maxTemp1,0,2);}
	public int getMax2(){return subStringToInt(maxTemp2,0,2);}

	public void clickOnTimeMachine()throws InterruptedException{ clickOn(timeMachine);}

	public int getTodaysDate(){return subStringToInt(todaysDate,0,31);}









}

