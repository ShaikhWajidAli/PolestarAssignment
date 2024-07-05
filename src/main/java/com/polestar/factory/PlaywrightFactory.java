package com.polestar.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;

	Properties prop;

	public Page initBrowser(Properties prop) {

		playwright = Playwright.create();
		String browserName = prop.getProperty("browser").trim();

		switch (browserName.toLowerCase()) {
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setSlowMo(3000).setHeadless(false));
			break;
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setSlowMo(3000).setHeadless(false));
			break;
		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setSlowMo(3000).setHeadless(false));
			break;
		case "chrome":
			browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			break;

		default:
			System.out.println("Provide a valid browserName");
			break;
		}

		browserContext = browser.newContext();
		page = browserContext.newPage();
		page.navigate(prop.getProperty("url").trim());

		return page;
	}

	public Properties initProp() throws Exception {
		FileInputStream ip = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
		prop = new Properties();
		prop.load(ip);

		return prop;
	}

}
