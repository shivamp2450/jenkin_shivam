package listners;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentSetup {
	
	static ExtentReports extent;

	public static ExtentReports setupExtentReport() {

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");

		Date date= new Date();

		String actualDate= format.format(date);

		String reportPath= System.getProperty("user.dir")+ "/Report/"+actualDate+".html";

		ExtentSparkReporter report = new ExtentSparkReporter (reportPath);

		extent = new ExtentReports();

		extent.attachReporter (report);

		report.config().setDocumentTitle("Practise"); 
		report.config().setTheme (Theme.DARK); 
		report.config().setReportName("Website Testing");

		return extent;
}
}