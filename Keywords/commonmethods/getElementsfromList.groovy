package commonmethods

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import org.stringtemplate.v4.compiler.STParser.element_return
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import internal.GlobalVariable
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date

public class getElementsfromList {

	/**
	 * Keyword to select the menu options by passing the option name as parameter.
	 * @param optionName - pass menuOption name on which user wants to click
	 * @ExpectedResult - User should redirect to the specific page as per selected menu.
	 */
	@Keyword
	def selectMenuOption(String optionName) {
		try {
			WebDriver driver = DriverFactory.getWebDriver()
			DriverFactory.changeWebDriver(driver)
			List<WebElement> webElements = driver.findElements(By.xpath("(//div[contains(@class,'navbar-collapse')]//ul//li/a/span)"))
			for(int i=0;i<webElements.size();i++){
				String value = webElements.get(i).getText()
				if(value.equals(optionName)){
					webElements.get(i).click();
				}
			}
		}catch (Exception e) {
			println(e.detailMessage)
		}
	}
	/**
	 * Keyword to select the options from the setting drop down list
	 * @param optionName - pass settingOption on which user wants to click
	 * @ExpectedResult - User should redirect to the specific page as per selected settingOptions.
	 */
	@Keyword
	def selectSettingOption(String settingOption) {
		try {
			WebDriver driver = DriverFactory.getWebDriver()
			DriverFactory.changeWebDriver(driver)
			driver.findElement(By.xpath("//div[contains(@class,'dropdown')]//a[contains(@class,'navbar-text')]")).click()
			WebUI.delay(3)
			List<WebElement> webElements = driver.findElements(By.xpath("(//div[contains(@class,'dropdown-menu')]//a)"))
			System.out.print(webElements.size())
			for(int i=0;i<webElements.size();i++){
				String value = webElements.get(i).getText()
				if(value.equals(settingOption)){
					System.out.print(webElements.get(i).getText())
					webElements.get(i).click();
				}
			}
		}catch (Exception e) {
			println(e.detailMessage)
		}
	}
	/**
	 * Keyword to return the webElement from the list by comparing text of the element.
	 * @param elementList - xpath of the list of element
	 * @param option - value for which user wants the webelement.
	 * @return  WebElement
	 */
	@Keyword
	def WebElement getElementFromlist(List elementList , String option) {
		try {
			WebDriver driver = DriverFactory.getWebDriver()
			DriverFactory.changeWebDriver(driver)
			List<WebElement> webElements = elementList
			for(int i=0;i<webElements.size();i++){
				String value = webElements.get(i).getText()
				if(value.equals(option)){
					System.out.print(webElements.get(i).getText().toString())
					return webElements.get(i)
				}
			}
		}catch (Exception e) {
			println(e.detailMessage)
		}
	}
	@Keyword
	def String getActualColor(String color) {
		String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");
		int hexValue1=Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2=Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3=Integer.parseInt(hexValue[2]);
		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		return actualColor;
	}
	//	@Keyword
	//	def today() {
	//		DateFormat dateFormat = new SimpleDateFormat(“dd”);
	//		Date date = new Date();
	//		String today = dateFormat.format(date);
	//		//find the calendar
	//		WebDriver driver = DriverFactory.getWebDriver()
	//		WebElement dateWidget = driver.findElement(By.className("datepicker-days"));
	//		List columns=dateWidget.findElements(By.tagName(“td”));
	//		//comparing the text of cell with today’s date and clicking it.
	//		for (WebElement cell : columns)
	//		{
	//			if (cell.getText().equals(today))
	//			{
	//				cell.click();
	//				break;
	//			}
	//		}

	@Keyword
	def Boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		for (int i = 0; i < dirContents.length; i++)
		{
			if (dirContents[i].getName().equals(fileName))
			{
				// File has been found, it can now be deleted:
				dirContents[i].delete();
				return true;
			}
		}
		return false;
	}


}








