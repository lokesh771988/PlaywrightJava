package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.ExtentManager;

public class TestBase {
	protected static ExtentReports extent;
	protected static ExtentTest test;
	protected Playwright playwright;
	protected Browser browser;
	protected BrowserContext context;
	protected Page page;
	
	@BeforeSuite
	public void setupReport() {
		extent = ExtentManager.getInstance();
	}
	
	@BeforeMethod
	public void setup() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		context = browser.newContext();
		page = context.newPage();
	}
	
	@AfterMethod
	public void tearDown() {
		if(page != null) page.close();
		if(context != null) context.close();
		if(browser != null) browser.close();
		if(playwright != null) playwright.close();
	}
	
	@AfterSuite
	public void flushReport() {
		extent.flush();
	}
}
