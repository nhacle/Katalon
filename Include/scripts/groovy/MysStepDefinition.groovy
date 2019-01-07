import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


class MysStepDefinition {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I launch PA site")
	def I_launch_PA_site() {
		'Open browser'
		WebUI.openBrowser(null)

		'Navigate to login page'
		WebUI.navigateToUrl("http://192.168.74.25/patest", FailureHandling.STOP_ON_FAILURE)
	}

	@When("I provide a valid account")
	def I_provide_a_valid_account() {
		'Enter username'
		WebUI.sendKeys(findTestObject('Object Repository/Page_Login/txt_Username'), "patest01", FailureHandling.STOP_ON_FAILURE)

		'Enter password'
		WebUI.sendKeys(findTestObject('Object Repository/Page_Login/txt_Password'), "kms", FailureHandling.STOP_ON_FAILURE)

		'Click on login button'
		WebUI.click(findTestObject('Object Repository/Page_Login/btn_Login'), FailureHandling.STOP_ON_FAILURE)
	}

	@Then("I am able to login the System")
	def I_am_able_to_login_the_System() {
	}

	@And("Home page is displayed")
	def Home_page_is_displayed(){
		'Get user welcome text'
		actual = WebUI.getText(findTestObject('Object Repository/Page_Home/txt_UserPanel'), FailureHandling.STOP_ON_FAILURE)

		expected = "Welcome, patest01 [Logout]"

		'Verify the welcome text'
		WebUI.verifyMatch(actual, expected, false, FailureHandling.STOP_ON_FAILURE)
	}
}