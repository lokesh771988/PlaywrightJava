package org.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC11_PaginationWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://testautomationpractice.blogspot.com/");
        
        boolean valueFound = false;
        
        Locator nextPage = page.locator("#pagination > li > a");
        int totalNextPage = nextPage.count();
        
        for(int i = 0; i < totalNextPage; i++) {
        	Locator row = page.locator("#productTable > tbody > tr");
        	
        	Locator targetRow = row.locator(":scope", new Locator.LocatorOptions().setHasText("Fitness Tracker"));
        	
        	if(targetRow.count() > 0) {
        		targetRow.locator("[type=\"checkbox\"]").click();
        		valueFound = true;
        		break;
        	}else if(1 < totalNextPage - 1) {
        		nextPage.nth(i+1).click();
        		page.waitForLoadState();
        	}
        }
        
        if(!valueFound) {
        	System.out.println("value is not found");
        }
	}	

}
