package com.polestar.pages;

import org.testng.Reporter;

import com.microsoft.playwright.Page;
import com.polestar.constants.AppConstants;

public class HomePage {

	private Page page;

//String Locators
	private String polestar3_Image = "//img[@alt='Sideview of a white Polestar 3 standing still infront of a terracotta red and pink building']";

	public HomePage(Page page) {
		this.page = page;
	}

	public String getHomePageTitle() {
		Reporter.log(AppConstants.HomePageTitle);
		return page.title();
	}

	public boolean isImagesAndVediosDisplayed() {
		page.waitForSelector(polestar3_Image);
		boolean isDisplayed = page.isVisible(polestar3_Image);
		Reporter.log("Polestar 3 Image is displayed");
		return isDisplayed;
	}

}