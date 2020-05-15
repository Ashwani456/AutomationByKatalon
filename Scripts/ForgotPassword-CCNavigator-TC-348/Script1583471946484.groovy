import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.junit.After as After
import org.openqa.selenium.WebElement
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
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
KeywordLogger log = new KeywordLogger()

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.delay(5)


/**
 * Below is the step to click on the forgot password link present on the login page
 */
WebUI.click(findTestObject('Object Repository/Object Repository/OverviewFrontUI/LogoImage'))
WebUI.delay(3)
WebUI.doubleClick(findTestObject('Object Repository/Object Repository/objects of login/ForgotPassword'))



/**
 * Below steps validate the default contents of the forgot password screen.
 * @ExpectedResult = All the below fields should display on forgot password page.
 * @Title
 * @Label
 * @EmailTextBox,ResetButton
 */

String title = WebUI.getText(findTestObject('Object Repository/LogIN/ForgotPassword_Title'))
if (title.toString().equals(titleName)) {
    log.logPassed('Title matched')
} else {
    log.logFailed((('Failed actual title is different from the expected title. The expected title is =' + title) + ' and expected title is =') + 
        titleName)
}
String label = WebUI.getText(findTestObject('Object Repository/LogIN/Email_Label'))
if (label.toString().equals(emailLabel)) {
    log.logPassed('Label matched')
} else {
    log.logFailed((('Failed actual label is different from the expected label. The expected label is =' + label) + ' and expected title is =') + 
        emailLabel)
}
WebUI.verifyElementPresent(findTestObject('Object Repository/LogIN/Email_TextBox'), 5)
WebUI.verifyElementPresent(findTestObject('Object Repository/LogIN/ResetPassword_Button'),5)




/**
 * Below steps validate message for required field when user 
 * click on reset button without enter the email.
 * @ExpectedResult = Validation message should display.
 */

WebUI.click(findTestObject('Object Repository/LogIN/ResetPassword_Button'))
String required = WebUI.getText(findTestObject('Object Repository/LogIN/ValidationMsg'))
WebUI.delay(2)
if (required.toString().equals(validationForRequiredField)) {
	log.logPassed('Validation message verified for successfully for required field.')
} else{ 
	log.logFailed('Failed validation message is different from the expected message. The expected message is =' + validationForRequiredField + ' and expected title is =' +
		required)
	}


/**
 * Below steps validate message for invalid email when user
 * enter the invalid email.
 * @ExpectedResult = Validation message should display.
 */

WebUI.setText(findTestObject('Object Repository/LogIN/Email_TextBox'),'text')
WebUI.click(findTestObject('Object Repository/LogIN/ResetPassword_Button'))
WebUI.delay(3)
String invalidemail = WebUI.getText(findTestObject('Object Repository/LogIN/ValidationMsg'))
WebUI.delay(2)
if (invalidemail.toString().equals(validationMesageForInvalidEmail)) {
	log.logPassed('Validation message verified for successfully for invalid email.')
} else{
	log.logFailed('Failed validation message for invalid email, the expected message. The expected message is =' + validationMesageForInvalidEmail + ' and expected title is =' +
		invalidemail)
}
WebUI.clearText(findTestObject('Object Repository/LogIN/Email_TextBox'))

/**
 * Below steps validate confirmation message when user enter registred 
 * email id and click on the reset password button.
 * @ExpectedResult = Confirmation message should display with registered email id.
 */
WebUI.setText(findTestObject('Object Repository/LogIN/Email_TextBox'), registredEmail)
WebUI.click(findTestObject('Object Repository/LogIN/ResetPassword_Button'))
WebUI.delay(5)
 resetpasswordlinkSentconfirmatioMessage = confirmationMessage.toString().replace("{replacewithemail}",registredEmail)
 text = WebUI.getText(findTestObject('Object Repository/LogIN/EmailConfirmationMessage'))
WebUI.delay(5)
if (text.toString().equals(resetpasswordlinkSentconfirmatioMessage)) {
    log.logPassed('Reset password link sent confirmation message verified successfully')
} else {
    log.logFailed((('Failed :Reset password link sent confirmation message verification failed. Expected message was =' + 
        resetpasswordlinkSentconfirmatioMessage) + ' Actual message is = ') + text)
}

/**
 * Below steps to click on the close button and redirect back to forgot password 
 * screen and validate the textbox of emailId.
 * @ExpectedResult = When user click on the close link then user should redirect to the forgot password page.
 */
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/LogIN/closebutton'))
WebUI.delay(20)
  //WebUI.verifyElementPresent(findTestObject('Object Repository/LogIN/Email_TextBox'), 5)

WebUI.closeBrowser()