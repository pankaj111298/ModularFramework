package commonLibs.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentAventReporter;

public class ReportUtils {

    ExtentReports extentReports;
    ExtentAventReporter extentAventReporter;
    ExtentTest extentTest;

    public ReportUtils(String filename) {
        extentAventReporter = new ExtentAventReporter(filename);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentAventReporter);
    }

    public void createTestCase(String testCaseName) {
        extentTest = extentReports.createTest(testCaseName);
    }

    public void addTestLog(Status status, String comment) {
        extentTest.log(status, comment);
    }

    public void flushReport() {
        extentReports.flush();
    }
}
