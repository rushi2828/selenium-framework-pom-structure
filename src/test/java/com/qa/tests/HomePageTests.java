package com.qa.tests;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.util.TestUtil;

public class HomePageTests extends TestBase {
	HomePage homepage;
	static String productName = "productName";
	private static final String MYNTRA_URL = "https://www.myntra.com/";

	public HomePageTests() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialisation();
		homepage = new HomePage();
	}

	/**
	 * Verify page title.
	 */
	 @Test(priority=1)
	public void pageTitleTest() {
//		 System.out.println("Title of the page is------>" homepage.pageTitle());
	}

	@Test(priority = 2)
	public void urlTest() {
		System.out.println(homepage.url());
		assertEquals(homepage.url(), MYNTRA_URL);
	}

	/**
	 * Verify search option.
	 */
	@Test
	public void searchOptionTest() {

	}

	@DataProvider
	public static Object[][] soldOutCmeData() throws EncryptedDocumentException, IOException {
		Object[][] data = TestUtil.getTextData(productName);
		return data;
	}

	/**
	 * Verify the product availability
	 */
	public void verifyProduct() {

	}

	/**
	 * Add to the Wishlist. User need to login with valid credentials.
	 */
	@Test
	public void newTest() {

	}

	/**
	 * Verify the product is added to the wishlist.
	 */
	public void verifyProdycInWishlist() {

	}

	/**
	 * Close browser initiates.
	 */
	@AfterMethod
	public void tearsDown() {
		driver.quit();
	}

}
