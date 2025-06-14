package ListenersTests;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomeListner extends BaseClass implements ITestListener
{
	@Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        failedTest(result.getMethod().getMethodName());
    }
    

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }

    

	
	
}
