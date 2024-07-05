package com.polestar.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.polestar.factory.PlaywrightFactory;
import com.polestar.pages.DevPage;
import com.polestar.pages.HomePage;

public class BaseTest {

	protected PlaywrightFactory pf;
	protected DevPage devPage;
	protected HomePage homePage;
	protected Properties prop;
	Page page;

	@BeforeTest
	public void setup() throws Exception {
		pf = new PlaywrightFactory();
		prop = pf.initProp();
		page = pf.initBrowser(prop);
		devPage = new DevPage(page);
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}