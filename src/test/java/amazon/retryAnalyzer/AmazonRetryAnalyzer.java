package amazon.retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class AmazonRetryAnalyzer implements IRetryAnalyzer{

	
	int initialCount = 0;
	int retryCount = 3;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(initialCount < retryCount) {
			initialCount++;
			return true;
		}
		
		return false;
	}

}
