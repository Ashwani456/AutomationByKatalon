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
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.openqa.selenium.Keys as Keys


KeywordLogger log = new KeywordLogger()
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.deleteAllCookies()
WebUI.waitForPageLoad(10)
WebUI.click(findTestObject('Object Repository/Object Repository/OverviewFrontUI//LogoImage'))
WebUI.click(findTestObject('objects of login/Log in_email'))
WebUI.setText(findTestObject('objects of login/Log in_email'), 'abc123@gmail.com')
WebUI.click(findTestObject('objects of login/Log in_password'))
WebUI.setText(findTestObject('objects of login/Log in_password'),'Tester@123')
WebUI.click(findTestObject('Object Repository/button_Log in'))
WebUI.delay(4)
WebUI.verifyElementText(findTestObject('Object Repository/LogIN/SmsCodeMsg'),'Sign in security is active: Please enter the code that you received via SMS.')
WebUI.verifyElementPresent(findTestObject('Object Repository/LogIN/SmsCodeField'),4)
WebUI.verifyElementPresent(findTestObject('Object Repository/LogIN/ConfirmDisableButton'),4)
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

















