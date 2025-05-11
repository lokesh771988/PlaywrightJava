package org.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC10_StaticWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://testautomationpractice.blogspot.com/");
        
        //table rows
        Locator rowCount = page.locator("[name=\"BookTable\"] > tbody > tr");
        int count = rowCount.count();
        System.out.println("Row Count::::: "+count);
        // columns
        int columCount = page.locator("[name=\"BookTable\"] > tbody > tr > th").count();
        System.out.println("cloumns count:::; "+ columCount);
        
        //cells
        int cellCount = page.locator("[name=\"BookTable\"] > tbody > tr > td").count();
        System.out.println("cell count:::; "+ cellCount);
        //verify
        String text = page.locator("[name=\"BookTable\"] > tbody > tr:nth-child(2) > td:nth-child(1)").textContent();
        System.out.println(text);
        //print complete table with single line code
        rowCount.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));
	}

}
