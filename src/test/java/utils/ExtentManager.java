package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		if(extent == null) {
			String reportPath = System.getProperty("user.dir")+"/reports/extent-report.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
			reporter.config().setReportName("Playwright Java UI Report");
			reporter.config().setDocumentTitle("Test Result");
			
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Lokesh");
		}
		return extent;
	}
}
