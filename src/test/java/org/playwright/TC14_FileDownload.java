package org.playwright;


import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC14_FileDownload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions()
				.setRecordVideoDir(Paths.get("videos/")).setRecordVideoSize(640, 500));
        Page page = context.newPage();
        page.navigate("https://the-internet.herokuapp.com/download");
        
        Download download = page.waitForDownload(() -> {
        	page.click("//*[text()='Get_Started_With_Smallpdf.pdf']");
        });
        
        String path = download.path().toString();
        System.out.println(path);
        
        Path projectDir = Paths.get(System.getProperty("user.dir"));
        
        Path savePath = projectDir.resolve("downloads/savePdf.pdf");
        
        download.saveAs(savePath);
        
        System.out.println(savePath.toString());
        
        //context.close();
        //page.close();
	}

}
