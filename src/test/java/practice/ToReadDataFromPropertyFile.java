package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ToReadDataFromPropertyFile {

	public static void main(String[] args) throws Throwable  {
		// TODO Auto-generated method stub
		//step1 open the file in java executable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.property");
		System.out.println("Path loaded");
		//step 2 create instance
		Properties prop=new Properties();
		System.out.println("Properties loaded");
		//step3 load the input stream
		prop.load(fis);	
	}

}
