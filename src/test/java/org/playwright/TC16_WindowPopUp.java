package org.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC16_WindowPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://the-internet.herokuapp.com/windows");
        
		/*
		 * Page popup = page.waitForPopup(()->{ page.click("//*[text()='Click Here']");
		 * });
		 */
        
        Page popup = page.waitForPopup(()->{
        	page.click("a[target='_blank']");
        });
        
        //System.out.println("child popup :::: "+popup.title());
        //popup.close();
        //System.out.println("parent popup title ::::"+page.title());
        //page.close();
        
        popup.waitForLoadState();
        popup.navigate("https://www.google.com/");
        System.out.println("child popup :::: "+popup.title());
	}

}
