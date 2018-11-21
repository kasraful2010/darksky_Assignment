package framework.page_object_model_web;

import framework.actions_web.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DarkskyPage extends BasePage {

	private By textField = By.xpath("//input[@type='text']");
	private By search = By.xpath("//a[@class='searchButton']//img[@width='16']");
	private By currentTemp = By.xpath("//span[@class='summary swap']");
	private By lowTemp = By.xpath("//span[@class='currently']//span[2]//span[2]//span[2]");
	private By highTemp = By.xpath("//span[@class='summary-high-low']//span[3]");

	public void clearTextField (){ clear(textField);}
	public void sendText(String text){sendText(textField, text);}
	public void clickOnSearch() throws InterruptedException {
		Thread.sleep(1200);
		clickOn(search);}

	public int getCurrentTemp() { return subStringToInt(currentTemp, 0, 2); }
	public int getLowTemp() { return  subStringToInt(lowTemp, 5, 7); }
	public int getHighTemp() { return subStringToInt(highTemp, 6, 8); }
	public void verifyTempRange() {
		int    current = getCurrentTemp(),
				low = getLowTemp(),
				high = getHighTemp();
		Assert.assertTrue(low <= current && current <= high,
				"Current temp (" + current + "˚) is not in between low (" + low + "˚) and high (" + high + "˚)"
		);
	}


}

