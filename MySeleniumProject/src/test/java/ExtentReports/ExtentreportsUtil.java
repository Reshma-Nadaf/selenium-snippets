package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentreportsUtil {

	private static ExtentReports extent;
	public static ExtentReports getInstance()
	{
		
		if (extent == null)
		{
			String reportPath = System.getProperty("user.dir")+"/reports/AutomationReport.html";
			ExtentSparkReporter sparkReporter  = new ExtentSparkReporter(reportPath);
			
			sparkReporter.config().setDocumentTitle("test reports");
			sparkReporter .config().setReportName("Testcase_reports");
			sparkReporter.config().setReportName("Reshma");
			
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
		}
		return extent;

	}

}
