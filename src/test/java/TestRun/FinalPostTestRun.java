package TestRun;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.generic.CreateReviewFinal;
import com.report.ExtentReportAutomation;

import io.restassured.response.Response;

public class FinalPostTestRun extends ExtentReportAutomation{
	
	
	@Test
	public void postTestCases() {
		CreateReviewFinal.post();
		CreateReviewFinal.postTestcases();
	}
	

}
