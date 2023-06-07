package common;

import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners {
    
    public void onTestStart(ITestResult result){
        Reporter.log("Method name is - "+result.getName());
        System.out.println("Testing starting");
    }

    public void onTestSuccess(ITestResult result){
        Reporter.log("Status of excution is - "+result.getStatus());
        System.out.println("Testing starting");
    }
}
