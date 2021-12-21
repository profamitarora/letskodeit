package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"\\reports\\Index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Test Cases Report");
		reporter.config().setDocumentTitle("Lets Kode It");
		
		extent  = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Amit Arora");
		
		return extent;
	}

}
