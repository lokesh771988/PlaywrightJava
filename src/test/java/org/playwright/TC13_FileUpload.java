package org.playwright;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC13_FileUpload {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
        
        //page.setInputFiles("#filesToUpload", Paths.get("C:\\Users\\lokesh_gorantla\\Downloads\\Return_Train4528745374.pdf"));
        //Thread.sleep(1000);
        //page.setInputFiles("#filesToUpload", new Path[0]);
        page.setInputFiles("#filesToUpload", new Path[] {
        		Paths.get("C:\\Users\\lokesh_gorantla\\Downloads\\Return_Train4528745374.pdf"),
        		Paths.get("C:\\Users\\lokesh_gorantla\\Downloads\\2_04_2025.pdf")
        });
	}

}
