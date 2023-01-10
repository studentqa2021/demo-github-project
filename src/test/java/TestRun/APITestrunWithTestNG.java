package TestRun;

import org.testng.annotations.Test;

import com.generic.CreateReview;
import com.generic.Delete;
import com.generic.Read;
import com.generic.Update;

public class APITestrunWithTestNG {
	
	@Test
	public void getPostTest() {//3
		CreateReview.post();
	}
	@Test(dependsOnMethods = {"getPostTest"})
	public void getUpdateTest() {//4
		Update.put();
	}
	@Test(dependsOnMethods = {"getUpdateTest"})
	public void getGetTest() {//2
		Read.get();
	}
	@Test(dependsOnMethods = {"getGetTest"})
	public void getDeleteTest() {//1
		Delete.delete();
	}

}
