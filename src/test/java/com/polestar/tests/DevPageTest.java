package com.polestar.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.polestar.base.BaseTest;
import com.polestar.constants.AppConstants;

public class DevPageTest extends BaseTest {

	@Test
	public void devPageURLTest() {
		String actualURL = devPage.getDevPageURL();
		assertEquals(actualURL, prop.getProperty("url"));
	}

	@Test
	public void devPageTitleTest() {
		String actualTitle = devPage.getDevPageTitle();
		assertEquals(actualTitle, AppConstants.devPageTitle);
	}

	@Test
	public void clickRejectAllBtn() {
		devPage.rejectAllCookies();
	}

	@Test
	public void imageDisplayedTest() {
		assertEquals(devPage.image_404_Displayed(), true);
	}

	@Test
	public void navigateToHomePage() {
		devPage.clickReturnHome();
	}

}