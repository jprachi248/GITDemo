import Files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexjsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath js=new JsonPath(Payload.Courseprice());
		int j=js.getInt("courses.size()");
		System.out.println(j);
		int purchaseamt=js.getInt("dashboard.purchaseAmount");
		System.out.println("purchase amt="+purchaseamt);
		String website=js.getString("dashboard.website");
		System.out.println("website="+website);
		
		//Print Title of the first course
		String tittle=js.getString("courses[0].title");
		System.out.println("website="+tittle);
		String tittle2=js.get("courses[1].title");
		System.out.println("website="+tittle2);
		String tittle3=js.getString("courses[2].title");
		System.out.println("website="+tittle3);
		
		//Print All course titles and their respective Prices
		int coursesSize=js.getInt("courses.size()");
		
		for (int i=0;i<coursesSize;i++)
		{
			String tittle4=js.getString("courses["+i+"].title");
			int price=js.getInt("courses["+i+"].price");
			System.out.println(tittle4);
			System.out.println(js.get("courses["+i+"].price").toString());
			
			//5. Print no of copies sold by RPA Course
			if (tittle4.equalsIgnoreCase("RPA"))
			{
				//copies sold
				System.out.println("Print no of copies sold by RPA Course");
				int copies1=js.getInt("courses["+i+"].copies");
				System.out.println("RPA="+copies1);
				break;
			}
			
			
		}
		

	}

}
