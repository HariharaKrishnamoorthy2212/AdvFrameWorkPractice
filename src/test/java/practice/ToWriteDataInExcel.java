package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class  ToWriteDataInExcel{

	public static void main(String[] args) throws Throwable{

		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\WriteData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Name");
		Row rw = sh.createRow(0);
		Cell cl = rw.createCell(0);
		cl.setCellValue("Hari");
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\WriteData.xlsx");
		wb.write(fos);
		
		
	}

}



