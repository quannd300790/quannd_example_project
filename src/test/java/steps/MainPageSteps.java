package steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberTestNG.ThreadlocalDriver;
import pages.MainPage;

public class MainPageSteps {
	WebDriver driver = ThreadlocalDriver.getTLDriver();
	String url = "https://production.romans.co.uk/";

	@When("^I open the main page url$")
	public void iOpenTheMainPage() throws Throwable {
		driver.get(url);
	}

	@And("^I input (.*) into location field$")
	public void iEnterInfoToLocationField(String info) throws Throwable {
		new MainPage().enterLocation(info);
	}
	
	@Then("^I choose (.*) as location$")
	public void iChooseLocation(String info) throws Throwable {
		new MainPage().chooseLocation(info);
	}

	@And("^I click on the Max Price button$")
	public void iClickOnTheMaxPriceButton() throws Throwable {
		new MainPage().clickOnTheMaxPriceButton();
	}
	
	@Then("^I choose (.*) as max price$")
	public void iChooseMaxPrice(String info) throws Throwable {
		new MainPage().chooseMaxPrice(info);
	}
	
	@And("^I click on the Num Of Bed button$")
	public void iClickOnTheNumOfBedButton() throws Throwable {
		new MainPage().clickOnTheNumOfBedButton();
	}

	@Then("^I choose (.*) as number of bedroom$")
	public void iChooseNumberOfBedroom(String info) throws Throwable {
		new MainPage().chooseNumOfBed(info);
	}

	@And("^I click on the Search button$")
	public void iClickOnTheSearchButton() throws Throwable {
		new MainPage().clickOnTheSearchButton();
		Thread.sleep(10000);
	}
}
