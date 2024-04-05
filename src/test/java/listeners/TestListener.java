package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import java.io.IOException;

import static common.CommonActions.captureScreen;
import static tests.BaseTest.logger;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("---------------------------------------------------------------");
        logger.info("Failed because of - " + result.getThrowable());
        logger.info("---------------------------------------------------------------");
        var driver = ((BaseTest) result.getInstance()).getriver();
        if (driver != null) {
            try {
                captureScreen((WebDriver) driver);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

