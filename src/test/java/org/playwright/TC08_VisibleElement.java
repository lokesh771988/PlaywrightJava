package org.playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC08_VisibleElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        
        //int count = page.locator("button:visible").count();
        int count = page.locator("button >> visible=true").count();
        System.out.println(count);
        
		/*
		 * List<String> text = page.locator("button >> visible=true").allInnerTexts();
		 * for(int i = 0; i < text.size(); i++) { System.out.println(text.get(i)); }
		 */
        List<String> text = page.locator("a >> visible=true").allInnerTexts();
        for(int i = 0; i < text.size(); i++) {
        	System.out.println(text.get(i));
        }
	}

}
