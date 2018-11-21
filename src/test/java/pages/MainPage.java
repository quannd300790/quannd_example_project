package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumberTestNG.ThreadlocalDriver;

public class MainPage extends PageHelper {
	public MainPage() {
		PageFactory.initElements(ThreadlocalDriver.getTLDriver(), this);
	}

	@FindBy(xpath = "//input[@id='edit-search-location']")
	private WebElement inputLocation;
	@FindBy(xpath = "//input[@id='edit-search-location']//following-sibling::div//ul")
	private WebElement dropdownlistLocation;
	@FindBy(xpath = "//button[@data-id='edit-max-price']")
	private WebElement btnEditMaxPrice;
	@FindBy(xpath = "//button[@data-id='edit-max-price']//following-sibling::div/ul")
	private WebElement dropdownlistPrice;
	@FindBy(xpath = "//button[@data-id='edit-num-of-bedrooms']")
	private WebElement btnEditNumOfBedroom;
	@FindBy(xpath = "//button[@data-id='edit-num-of-bedrooms']//following-sibling::div/ul")
	private WebElement dropdownlistNumOfBed;
	@FindBy(xpath = "//button[@id='edit-submit']")
	private WebElement btnSearch;

	public void enterLocation(String info) {
		inputField(inputLocation, info);
	}

	public void chooseLocation(String info) {
		waitFor(dropdownlistLocation);
		clickOn(dropdownlistLocation.findElement(By.xpath(".//a[text()='" + info + "']")));
	}

	public void chooseMaxPrice(String info) {
		clickOnTheMaxPriceButton();
		waitFor(dropdownlistPrice);
		clickOn(dropdownlistPrice.findElement(By.xpath(".//li[.//span[text()='" + info + "']]")));
	}

	public void chooseNumOfBed(String info) {
		clickOnTheNumOfBedButton();
		waitFor(dropdownlistNumOfBed);
		clickOn(dropdownlistNumOfBed.findElement(By.xpath(".//li[.//span[text()='" + info + "']]")));
	}

	public void clickOnTheMaxPriceButton() {
		clickOn(btnEditMaxPrice);
	}

	public void clickOnTheNumOfBedButton() {
		clickOn(btnEditNumOfBedroom);
	}

	public void clickOnTheSearchButton() {
		clickOn(btnSearch);
	}

}
