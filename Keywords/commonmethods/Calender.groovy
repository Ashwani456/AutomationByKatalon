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
import com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword as SetDateCalendarKeyword

public class Calender {
	WebDriver driver = DriverFactory.getWebDriver()
	KeywordLogger log = new KeywordLogger()
	@Keyword
	def doSomething(){
		SetDateCalendarKeyword Keyword = new SetDateCalendarKeyword()
		DriverFactory.changeWebDriver(Keyword)

		Keyword.Set(findTestObject('YOUR_OBJECT'), 10, 5, 2019, 2000, FailureHandling.STOP_ON_FAILURE);
	}
}
