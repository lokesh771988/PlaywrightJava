package tests;

import org.testng.annotations.Test;

import base.TestBase;

public class GoogleTest extends TestBase {

	@Test
	public void verifyGoogleTitle() {
		test = extent.createTest("Google Title Verifyication");
		page.navigate("https://www.google.com/");
		test.info("Navigate to Google");
		String title = page.title();
		test.info("Google Title ::: "+title);
		if(title.contains("Google")) {
			test.pass("Title verified successfully");
		}else {
			test.fail("Title verification failed");
		}
	}
}
