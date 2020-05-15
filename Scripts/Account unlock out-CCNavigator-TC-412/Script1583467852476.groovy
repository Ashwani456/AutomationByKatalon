import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.junit.After
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(enviroment)
WebDriver driver = DriverFactory.getWebDriver()
KeywordLogger log = new KeywordLogger()
DriverFactory.changeWebDriver(driver)
WebUI.deleteAllCookies()
WebUI.waitForPageLoad(10)
WebUI.maximizeWindow()
WebUI.click(findTestObject('Object Repository/Object Repository/OverviewFrontUI/LogoImage'))
WebUI.click(findTestObject('objects of login/Log in_email'))
WebUI.setText(findTestObject('objects of login/Log in_email'), '')


int i = 1
while (i<=6)
{
	//loging with 6 time  incorrect password
	WebUI.click(findTestObject('objects of login/Log in_password'))
	WebUI.setText(findTestObject('objects of login/Log in_password'),'Tes@12345')
	WebUI.click(findTestObject('Object Repository/button_Log in'))
	WebUI.delay(4)
	i++
	//loging with correct password 
	if(i==7)
	{
		WebUI.click(findTestObject('objects of login/Log in_password'))
		WebUI.setText(findTestObject('objects of login/Log in_password'),'Tester@1234')
		WebUI.click(findTestObject('Object Repository/button_Log in'))
		WebUI.delay(2)
		Msg =WebUI.getText(findTestObject('Object Repository/LogIN/LockedMsg'))
		WebUI.verifyElementText(findTestObject('Object Repository/LogIN/LockedMsg'),Msg)
		
		//loging with diff email and password for unlock user
		WebUI.click(findTestObject('objects of login/Log in_email'))
		WebUI.setText(findTestObject('objects of login/Log in_email'), 'abc@gmail.com')
		WebUI.click(findTestObject('objects of login/Log in_password'))
		WebUI.setText(findTestObject('objects of login/Log in_password'),'Tester@123')
		WebUI.click(findTestObject('Object Repository/button_Log in'))
		WebUI.delay(4)
		response = WS.sendRequest(findTestObject('Object Repository/TwilioApi(PhoneNumber)')).getResponseText()
		log.logPassed(response)
		Body = response.split("/Message>")
		NewBody = Body[1].split("Body>")
		Code = NewBody[1].replace("is your  verification code.</"," ").trim()
		log.logPassed(Code)
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/OtpTwilioCode'), Code)
		WebUI.click(findTestObject('Object Repository/button_Confirm'))
		WebUI.delay(4)
	
		//loging with correct username and password
		WebUI.click(findTestObject('Object Repository/Object Repository/LogoImage'))
		WebUI.click(findTestObject('objects of login/Log in_email'))
		WebUI.setText(findTestObject('objects of login/Log in_email'), 'abc@gmail.com')
		WebUI.click(findTestObject('objects of login/Log in_password'))
		WebUI.setText(findTestObject('objects of login/Log in_password'),'Tester@1234')
		WebUI.click(findTestObject('Object Repository/button_Log in'))
		WebUI.delay(4)
		response = WS.sendRequest(findTestObject('Object Repository/TwilioApi(PhoneNumber)')).getResponseText()
		log.logPassed(response)
		Body = response.split("/Message>")
		NewBody = Body[1].split("Body>")
		Code = NewBody[1].replace("is your  verification code.</"," ").trim()
		log.logPassed(Code)
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/OtpTwilioCode'), Code)
		WebUI.click(findTestObject('Object Repository/button_Confirm'))
		WebUI.delay(4)
		WebUI.maximizeWindow()
		Username = WebUI.getText(findTestObject('Object Repository/Object Repository/Test Objects/Pages/Login Page/Username'))
		if(Username.equals('ashwani'))
		{
			log.logPassed('Successfully Login')
		}
		else
		{
			log.logFailed('User name are  not same')
		}
		
		WebUI.closeBrowser()
		driver.quit()
		
	}
}	














