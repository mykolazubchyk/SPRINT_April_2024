package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import static common.CommonActions.captureScreen;
import static tests.BaseTest.logger;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        logger.fatal("---------------------------------------------------------------");
        logger.fatal("Failed because of - " + result.getThrowable());
        logger.fatal("---------------------------------------------------------------");
        var driver = ((BaseTest) result.getInstance()).getDriver();
        if (driver!= null){
            captureScreen(driver);
        }
    }
}

