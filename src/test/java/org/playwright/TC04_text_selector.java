package org.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC04_text_selector {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://www.orangehrm.com/");
        
        //page.locator("'Privacy Policy'").click();
        //page.locator("a:has-text('Privacy Policy')").nth(0).click();
        page.locator("text=Privacy Policy").nth(0).click();
	}

}
