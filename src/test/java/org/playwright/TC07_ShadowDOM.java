package org.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.JSHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC07_ShadowDOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://books-pwakit.appspot.com/");
        //page.locator("#input").fill("Testing");
        page.waitForSelector("book-app");
        
        JSHandle search = page.evaluateHandle("document.querySelector('book-app').shadowRoot?.querySelector('input')");
        
        ElementHandle box = search.asElement();
        
        if(box != null) {
        	box.fill("Playwright Testing");
        	System.out.println("Text entered");
        }else {
        	System.out.println("text is not entered");
        }
	}

}
