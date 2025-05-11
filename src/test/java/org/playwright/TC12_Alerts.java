package org.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC12_Alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        
        page.onDialog(dialg ->{
        	String text = dialg.message();
        	System.out.println(text);
        	dialg.accept("lokesh");
        	//dialg.dismiss();
        });
        
        //confirm pop
        //page.locator("//*[text()='Click for JS Alert']").click();
        //page.locator("//*[text()='Click for JS Confirm']").click();
        page.locator("//*[text()='Click for JS Prompt']").click();
        String text = page.locator("#result").textContent();
        System.out.println(text);
        
	}

}
