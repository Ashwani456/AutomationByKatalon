package commonmethods

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.openqa.selenium.Keys as Keys
//import com.twilio.Twilio as Twilio
//import com.twilio.base.ResourceSet as ResourceSet
//import com.twilio.type.PhoneNumber as PhoneNumber
//import com.twilio.rest.api.v2010.account.Message as Message
import java.util.concurrent.TimeUnit as TimeUnit

import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.webservice.verification.WSResponseManager as WSResponseManager

import java.util.ArrayList
import java.util.List

import java.lang.String
//import com.twilio.Twilio
//import com.twilio.rest.api.v2010.account.Message
//import com.twilio.type.PhoneNumber







public class LoginThroughOtp {
	KeywordLogger log = new KeywordLogger()
	//@Keyword
	def Login(){
		WebUI.openBrowser('')

		WebUI.maximizeWindow()

		WebUI.waitForElementVisible(findTestObject('Object Repository/button_Log in'), 30)

		WebUI.deleteAllCookies()

		WebUI.waitForPageLoad(60)

		WebUI.click(findTestObject('objects of login/Log in_email'))

		WebUI.setText(findTestObject('objects of login/Log in_email'), '')

		WebUI.click(findTestObject('objects of login/Log in_password'))

		WebUI.setText(findTestObject('objects of login/Log in_password'), 'Tester@123')

		WebUI.click(findTestObject('Object Repository/button_Log in'))

		WebUI.delay(2)


		response = WS.sendRequest(findTestObject('TwilioApi(jk)')).getResponseText()
		log.logPassed(response)

		NewBody = response.split("Body>")
		Code = NewBody[1].replace("is your CardioCare verification code</"," ").trim()
		log.logPassed(Code)


		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/OtpTwilioCode'), Code)

		WebUI.click(findTestObject('Object Repository/button_Confirm'))
	}
}
