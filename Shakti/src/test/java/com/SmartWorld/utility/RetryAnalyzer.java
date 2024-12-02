package com.SmartWorld.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	int count=0;
	int RetrLimit=0;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<RetrLimit) {
			count++;
			return true;
		}
		return false;
	}
	

}
