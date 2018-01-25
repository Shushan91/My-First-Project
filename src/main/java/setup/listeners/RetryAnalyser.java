package setup.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.logging.Logger;

/**
 * Created by Shush&Gar on 18-Jan-18.
 */
public class RetryAnalyser implements IRetryAnalyzer {
    private static Logger Log = Logger.getLogger(RetryAnalyser.class.getName());
    private int retryCount = 0;
    private int maxRetryCount = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            Log.info("Retrying test" + result.getName() + "With status" +
                    getResultStatusName(result.getStatus()) + "for the" + (retryCount + 1) + "time(s)");

            retryCount++;
            return true;
        }
        return false;
    }

    private String getResultStatusName(int status) {
        String resultNAme = null;
        if (status == 1)
            resultNAme = "SUCCESS";
        if (status == 2)
            resultNAme = "FAILURE";
        if (status == 3)
            resultNAme = "SKIP";
        return resultNAme;
    }

}
