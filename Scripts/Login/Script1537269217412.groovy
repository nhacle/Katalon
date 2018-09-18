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

WebUI.openBrowser(null)

'Navigate to login page'
WebUI.navigateToUrl("http://192.168.74.25/patest", FailureHandling.STOP_ON_FAILURE)

'Enter username'
WebUI.sendKeys(findTestObject('Object Repository/Page_Login/txt_Username'), "patest01", FailureHandling.STOP_ON_FAILURE)

'Enter password'
WebUI.sendKeys(findTestObject('Object Repository/Page_Login/txt_Password'), "kms", FailureHandling.STOP_ON_FAILURE)

'Click on login button'
WebUI.click(findTestObject('Object Repository/Page_Login/btn_Login'), FailureHandling.STOP_ON_FAILURE)

'Get user welcome text'
actual = WebUI.getText(findTestObject('Object Repository/Page_Home/txt_UserPanel'), FailureHandling.STOP_ON_FAILURE)

expected = "Welcome, patest01 [Logout]"

'Verify the welcome text'
WebUI.verifyMatch(actual, expected, false, FailureHandling.STOP_ON_FAILURE)
