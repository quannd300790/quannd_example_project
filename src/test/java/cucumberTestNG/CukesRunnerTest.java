package cucumberTestNG;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = "src/test/java/features", plugin = { "pretty",
		"html:target/cucumber-html-report" }, glue = { "steps" })
public class CukesRunnerTest extends AbstractTestNGCucumberTests {

	@BeforeClass
	@Parameters({ "browserName" })
	public void setUP(String browserName) throws Exception {
		switch (browserName) {
		case "chrome":
//			ThreadlocalDriver.setTLDriver(Chrome());
			ThreadlocalDriver.setTLDriver(RemoteChrome());
			break;
		case "firefox":
//			ThreadlocalDriver.setTLDriver(Firefox());
			ThreadlocalDriver.setTLDriver(RemoteFirefox());
			break;
		}
	}

	private WebDriver Firefox() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions option = new FirefoxOptions();
		option.setCapability("marionette", false);
		option.addArguments("--disable-web-security");
		option.addArguments("--allow-running-insecure-content");

		return new FirefoxDriver();
	}

	private WebDriver Chrome() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-web-security");
		option.addArguments("--allow-running-insecure-content");

		return new ChromeDriver(option);
	}

	private RemoteWebDriver RemoteChrome() throws Exception {
		ChromeOptions option = new ChromeOptions();
//		option.addArguments(browser_size());
//		if (MODE.equals("headless")) {
//			option.addArguments("--headless");
//		}
		option.addArguments("--disable-web-security");
		option.addArguments("--allow-running-insecure-content");
		return new RemoteWebDriver(new URL("http://192.168.1.26:30007/wd/hub"), option);
	}

	private RemoteWebDriver RemoteFirefox() throws Exception {
		FirefoxOptions option = new FirefoxOptions();
//		option.addArguments(browser_size());
//		if (MODE.equals("headless")) {
//			option.addArguments("--headless");
//		}
		option.addArguments("--disable-web-security");
		option.addArguments("--allow-running-insecure-content");
		return new RemoteWebDriver(new URL("http://192.168.1.26:30007/wd/hub"), option);
	}

	@AfterClass
	public void tearDown() {
		ThreadlocalDriver.getTLDriver().quit();
	}

}
