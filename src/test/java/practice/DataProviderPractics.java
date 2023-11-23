package practice;
import org.testng.annotations.*;
public class DataProviderPractics {
	@Test(dataProvider="getData")
	public void readData(String Name,int price,int qty) {
		System.out.println(Name+"-->"+price+"-->"+qty);
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[3][2];
		
		
		data[0][0]="Samsung";
		data[0][1]=400;
		data[0][2]=80;

		data[1][0]="Vivo";
		data[1][1]=800;
		data[1][2]=50;

		data[2][0]="Apple";
		data[2][1]=4200;
		data[2][2]=100;

		data[3][0]="Oppo";
		data[3][1]=200;
		data[3][2]=50;
		return data;
}
	
	
	}
	
	
