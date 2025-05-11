package org.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC03_Elements {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://demo.automationtesting.in/Register.html");
        
        Locator switchTo = page.locator("text = SwitchTo");
        switchTo.hover();
        
        Locator windows = page.locator("text = Windows").first();
        windows.hover();
        
        Locator dropdown = page.locator("#Skills option");
        System.out.println("Dropdown count ::::: "+dropdown.count());
        
        for(int i = 0; i < dropdown.count(); i++) {
        	String text = dropdown.nth(i).textContent();
        	System.out.println(text);
        }
	}

}
