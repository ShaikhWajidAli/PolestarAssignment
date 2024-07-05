package com.polestar.pages;

import org.testng.Reporter;

import com.microsoft.playwright.Page;
import com.polestar.constants.AppConstants;

public class DevPage {

	private Page page;

//String locators
	private String image_404 = "//img[@alt='404 image']";
	private String rejectAllBtn = "#onetrust-reject-all-handler";
	private String returnHome = "//span[text()='Return Home']";

//Page constructor
	public DevPage(Page page) {
		this.page = page;
	}

//Page actions
	public String getDevPageURL() {
		String devURL = page.url();
		Reporter.log("DevPage URL: " + devURL);
		return devURL;
	}

	public String getDevPageTitle() {
		String title = page.title();
		Reporter.log("DevPage Title: " + title);
		return title;
	}

	public void rejectAllCookies() {
		page.click(rejectAllBtn);
		Reporter.log("Reject All cookies button clicked");
	}

	public boolean image_404_Displayed() {
		page.waitForSelector(image_404);
		if (page.isVisible(image_404)) {
			Reporter.log("404_Image is displayed");
		}
		return page.isVisible(image_404);
	}

	public HomePage clickReturnHome() {
		page.click(returnHome);
		Reporter.log("Return Home button clicked");
		return new HomePage(page);
	}
}