import org.testng.Assert;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	@Test
	public void sumvalidation()
	{
		int sum=0;
		JsonPath js=new JsonPath(Payload.Courseprice());
		int j=js.getInt("courses.size()");
		System.out.println("course Size="+j);
		for (int i=0;i<j;i++)
		{
		int cprice=js.get("courses["+i+"].price");
		
		int coursecopies=js.get("courses["+i+"].copies");
		
		int total=cprice*coursecopies;
		System.out.println("Total="+total);
		sum=sum+total;

		}
		System.out.println("sum="+sum);
		int purchaseamt=js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseamt);
		Assert.assertEquals(purchaseamt, sum);
	}

}
