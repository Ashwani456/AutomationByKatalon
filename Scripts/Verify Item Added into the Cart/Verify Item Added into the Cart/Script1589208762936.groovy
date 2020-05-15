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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.openqa.selenium.Keys as Keys


WebUI.openBrowser(environment)
KeywordLogger log = new KeywordLogger()



WebUI.waitForPageLoad(10)
WebUI.maximizeWindow()
WebUI.deleteAllCookies()
WebUI.delay(2)

WebUI.click(findTestObject('ApplicationObjects/buttonNotiAllow'))
WebUI.delay(2)
WebUI.focus(findTestObject('Object Repository/ApplicationObjects/HOME And KITCHEN'))
WebUI.mouseOver(findTestObject('Object Repository/ApplicationObjects/HOME And KITCHEN'))
WebUI.delay(2)

WebUI.click( findTestObject('Object Repository/ApplicationObjects/Wall Decor'))
WebUI.switchToWindowIndex(1)
WebUI.delay(4)

WebUI.click(findTestObject('Object Repository/ApplicationObjects/Discount Filter(40-60)'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/ApplicationObjects/Price Filter(2501-5000)'))
WebUI.click(findTestObject('ApplicationObjects/remove ItemCart'))
WebUI.click(findTestObject('Object Repository/ApplicationObjects/Third row Item'))
WebUI.click(findTestObject('Object Repository/ApplicationObjects/Add to cart button'))

ProductToastMSG=WebUI.getText(findTestObject('Object Repository/ApplicationObjects/Product Added Toast'))
log.logPassed(ProductToastMSG)
	
WebUI.mouseOver(findTestObject('Object Repository/ApplicationObjects/Add to cart Icon'))

WebUI.click(findTestObject('Object Repository/ApplicationObjects/View cart button'))

MyCartHeading= WebUI.getText(findTestObject('Object Repository/ApplicationObjects/My Cart Header'))
log.logPassed(MyCartHeading)

WebUI.click(findTestObject('Object Repository/ApplicationObjects/remove ItemCart'))
WebUI.click(findTestObject('Object Repository/ApplicationObjects/RemoveConfirm'))

EmptyCart= WebUI.getText(findTestObject('Object Repository/ApplicationObjects/EmptyCartMsg'))
log.logPassed(EmptyCart)

WebUI.click(findTestObject('Object Repository/ApplicationObjects/SHOPCLUES logo'))

WebUI.click(findTestObject('Object Repository/ApplicationObjects/Search field'))
WebUI.setText(findTestObject('Object Repository/ApplicationObjects/Search field'), 'carneliantech123')
WebUI.click(findTestObject('Object Repository/ApplicationObjects/Search button'))

WebUI.click(findTestObject('Object Repository/ApplicationObjects/Third row Item'))
WebUI.click(findTestObject('Object Repository/ApplicationObjects/Add to cart button'))
ProductToastMSG=WebUI.getText(findTestObject('Object Repository/ApplicationObjects/Product Added Toast'))
log.logPassed(ProductToastMSG)


ProductCount=WebUI.getText(findTestObject('Object Repository/ApplicationObjects/Notification Count'))
log.logPassed(ProductCount)

WebUI.mouseOver(findTestObject('Object Repository/ApplicationObjects/Add to cart Icon'))

WebUI.click(findTestObject('Object Repository/ApplicationObjects/View cart button'))


WebUI.click(findTestObject('Object Repository/ApplicationObjects/Plus icon'))

WebUI.click(findTestObject('Object Repository/ApplicationObjects/Place Order button'))

WebUI.switchToWindowIndex(2)
WebUI.delay(4)

CustomKeywords.'logInPack.LogIn.doLogin'(username, password)




