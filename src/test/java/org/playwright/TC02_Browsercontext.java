package org.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC02_Browsercontext {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("http://playwright.dev");
        System.out.println(page.title());
        
        BrowserContext context1 = browser.newContext();
        Page page1 = context1.newPage();
        page1.navigate("https://www.google.com/");
        System.out.println(page1.title());
        
        page.close();
        context.close();
        
        page1.close();
        context1.close();
	}

}
