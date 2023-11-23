package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenersImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();//name of the @Test method
		System.out.println(methodName+" ---- Test Execution started ----");
		
		//@Test execution started
		test = report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ---- Test PASS ----");
		
		test.log(Status.PASS, methodName+" ---- Test PASS ----");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ---- Test FAIL ----");
		System.out.println(result.getThrowable());
		
		test.log(Status.FAIL, methodName+" ---- Test FAIL ----");
		test.log(Status.INFO, result.getThrowable());
		
		WebDriverUtlitiy wutil = new WebDriverUtlitiy();
		JavaUtliites jutil = new JavaUtliites();
		
		String screenshotName = methodName+jutil.GetSystemDateFormat();
		
		try {
			
			String path = wutil.captureScreenshot(BaseClass.sdriver, screenshotName);
			
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ---- Test SKIP ----");
		System.out.println(result.getThrowable());
		
		test.log(Status.SKIP, methodName+" ---- Test SKIP ----");
		test.log(Status.INFO, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("---- Suite Execution Started ----");
		
		//Extent Report configuration
		
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtliites().GetSystemDateFormat()+".html");
		htmlreport.config().setDocumentTitle("Execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("QCO-SOEAJD-M5-Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "Edge");
		report.setSystemInfo("Base PlatForm", "Windows Family");
		report.setSystemInfo("Base Env", "Testing");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Chaitra");
		

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("---- Suite Execution Finished ----");
		
		//generate the report
		report.flush();
		
	}
	
	

}
