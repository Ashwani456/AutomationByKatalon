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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject


WebUI.openBrowser(enviroment)
WebDriver driver = DriverFactory.getWebDriver()
KeywordLogger log = new KeywordLogger()
DriverFactory.changeWebDriver(driver)

     //CustomKeywords.'commonmethods.CommonMethods.doLogin'(username, password)

WebUI.click(findTestObject('Object Repository/Object Repository/OverviewFrontUI/LogoImage'))
WebUI.setText(findTestObject(''),'abc@gmail.com ')
WebUI.setText(findTestObject(''),'Tester@123')


/**
 * Below is the test steps when user enter the wrong credentials 6 time for login then that user get locked out for 30 min.
 * @ExpectedConditions - For first 4 incorrect logged in message should 'You have 2 more attempts before being locked out'
 * For 5th wrong attempt message should be 'You have 1 more attempts before being locked out'  
 * For 6th wrong attempt message should be 'Account locked out'
 */
 int i = 1

while (i<= 6) 
{
   WebUI.click(findTestObject(''))
    if (i.equals(4)) 
	{
         message = WebUI.getText(findTestObject('Object Repository/Object Repository/Test Objects/Pages/Login Page/ErrorMessage'))
        if(message.toString().compareTo('You have 2 more attempts before being locked out')) 
		{
            log.logPassed('Validation message matched  "You have 2 more attempts before being locked out"')
     
		}
		else
		{
			log.logFailed('validation message not matched for 2 more attempt')
		}

    }
  if (i.equals(5)) 
  {
	  message = WebUI.getText(findTestObject('Object Repository/Object Repository/Test Objects/Pages/Login Page/ErrorMessage'))
     if (message.toString().compareTo('You have 1 more attempts before being locked out')) 
       {
	    log.logPassed('Validation message matched  "You have 1 more attempts before being locked out"')
       }
     else
	 {
		 log.logFailed('validation message not matched for 1 more attempt')
	 }
   }
	
  if (i.equals(6))
  { 
	   message = WebUI.getText(findTestObject('Object Repository/Object Repository/Test Objects/Pages/Login Page/ErrorMessage'))
     if (message.toString().compareTo('Account locked out')) 
      {
	   log.logPassed('Validation message matched for Account locked out')
      } 
	  else
	  {
		  log.logFailed('validation message not matched for account locked out')
	  }

  }
 i++
}
WebUI.delay(3)
WebUI.closeBrowser()
driver.quit()

