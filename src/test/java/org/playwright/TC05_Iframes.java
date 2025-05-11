package org.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC05_Iframes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
        Page page = context.newPage();
        //page.navigate("https://ui.vision/demo/webtest/frames/");
        
        //page.frameLocator("[src='frame_1.html']").locator("[name='mytext1']").fill("Lokesh");
        page.navigate("https://selectorshub.com/iframe-in-shadow-dom/");
        
        page.frameLocator("#pact1").locator("#close").click();
	}

}
