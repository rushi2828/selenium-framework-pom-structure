package com.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class HomePage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Actions action = new Actions(driver);

	// Object Repository
	@FindBy(xpath = "//span[contains(text(),'Profile')]")
	WebElement profileButton;

	@FindBy(xpath = "//a[contains(text(),'log in')]")
	WebElement loginButton;

	@FindBy(xpath = "//input[@placeholder='Your Email Address']")
	WebElement email;

	@FindBy(xpath = "//input[@placeholder='Enter Password']")
	WebElement password;

	@FindBy(xpath = "//input[@placeholder='Search for products, brands and more']")
	WebElement searchBar;

	@FindBy(xpath = "//button[@class='login-login-button']")
	WebElement loginSubmitButton;

	@FindBy(xpath = " ")
	WebElement addToWishlistButton;

	@FindBy(xpath = "//span[contains(text(),'Wishlist')]")
	WebElement wishlistButton;

	// Initialize Pagefactory.
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Action Classes
	public String url() {
		return driver.getCurrentUrl();
	}

	public String pageTitle() {
		String titleTest = driver.getTitle();
		return titleTest;
	}

	public boolean isSearchButtonVisible() {
		return searchBar.isEnabled();
	}

	public void searchProduct(String product){
		searchBar.sendKeys(product);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			System.out.println(e);
			return;
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void selectProduct(String productNumber) {
		WebElement prodcut = driver.findElement(By.xpath("//li[" + productNumber + "]//a[1]//div[2]//h3[1]"));
		wait.until(ExpectedConditions.visibilityOf(prodcut)).click();
	}

	public void openProfile() {
		profileButton.click();
	}

	public void openLoginScreen() {
		action.moveToElement(profileButton).perform();
		loginButton.click();
	}

	public void enterEmail(String username) {
		email.sendKeys(username);
	}

	public void enetrPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickLogin() {
		loginSubmitButton.click();
	}

	public void selectSearchBar() {
		searchBar.click();
	}

	public void enterProduct(String name) {
		searchBar.sendKeys(name);
	}

	public void clickWishlist() {

	}

	public void openWishlist() {
		wishlistButton.click();
	}
}
