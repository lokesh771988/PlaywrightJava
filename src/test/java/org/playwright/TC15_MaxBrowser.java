package org.playwright;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC15_MaxBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screensize.getWidth();
		int hight = (int)screensize.getHeight();
		System.out.println(width);
		System.out.println(hight);
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(hight, width));
        Page page = context.newPage();
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
	}

}
