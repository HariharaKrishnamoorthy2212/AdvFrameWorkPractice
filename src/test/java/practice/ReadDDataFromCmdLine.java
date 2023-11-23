package practice;
import org.testng.annotations.*;
	
public class ReadDDataFromCmdLine {

		@Test
		public void run() {
			String UN = System.getProperty("username");
			String PWD = System.getProperty("password");
			
			System.out.println(UN);
			System.out.println(PWD);
		}
		
}
