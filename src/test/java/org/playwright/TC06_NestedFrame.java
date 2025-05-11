package org.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC06_NestedFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://ui.vision/demo/webtest/frames/");
        
        FrameLocator outerFrame =  page.frameLocator("[src='frame_3.html']");
        outerFrame.locator("[name=\"mytext3\"]").fill("Testing 3 fRame");
        FrameLocator inside = outerFrame.frameLocator("[src=\"https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true\"]");
        inside.locator("text=Form Autofilling").click();
	}

}
