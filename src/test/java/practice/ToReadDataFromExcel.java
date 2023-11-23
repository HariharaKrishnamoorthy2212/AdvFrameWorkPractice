package practice;

import java.io.FileInputStream;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadDataFromExcel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		System.out.println("file path is created");
		Workbook wb=WorkbookFactory.create(fis);
		System.out.println("WorkBook is created");
		Sheet sh= wb.getSheet("Contacts");
		System.out.println("navigated to sheet ");
		Row rw=sh.getRow(3);
		System.out.println("navigated to row");
		Cell cw=rw.getCell(1);
		
		System.out.println("navigated to cell");
		String value=cw.getStringCellValue();
		
		System.out.println(value);
		
		
		
		
		
		
		
		
	}

}
