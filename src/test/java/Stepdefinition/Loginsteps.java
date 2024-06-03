package Stepdefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.Login;

public class Loginsteps{
	private WebDriver driver;
	private Login loginPage;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\java\\Library\\chromedriver.exe");
		driver= new ChromeDriver();
		loginPage= new Login (driver);
		driver.manage().window().maximize();
	}
	@Given ("I am on the login page")
	public void iAmOnTheLoginPage() {
		driver.get("https://practicetestautomation.com/practice-test-login/");		
}
	@When ("I enter username {string} and password {string}")
	public void iEnterUsernameAndPassword(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}
	@And ("I click on the login button")
	public void iClickOnLoginButton() {
		loginPage.submitbutton();
	}
	@Then ("I should see the welcome message")
	public void welcomeMessage() {
		WebDriverWait wait= new WebDriverWait (driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loginPage.getSuccessMessageLocator()));
		
	String successMessage = loginPage.getSuccessMessage();
	
	Assert.assertEquals ("Logged In Successfully", successMessage);
	
	System.out.println ("Login Successfull");
	}	
	@After 
	public void closeBrowser() {
		driver.quit();
	}
}