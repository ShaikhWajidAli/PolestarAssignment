package com.polestar.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.polestar.base.BaseTest;
import com.polestar.constants.AppConstants;

public class HomePageTest extends BaseTest {

	@Test(priority = 1)
	public void navigateToHomePage() {
		devPage.rejectAllCookies();
		homePage = devPage.clickReturnHome();

	}

	@Test(priority = 2)
	public void getHomePageTitleTest() {
		String actualTitle = homePage.getHomePageTitle();
		assertEquals(actualTitle, AppConstants.HomePageTitle);
	}

	@Test(priority = 3)
	public void imagesAndVediosDisplayedTest() {
		assertTrue(homePage.isImagesAndVediosDisplayed());

	}

}