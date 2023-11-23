package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class Consits of GEneric Methods to acess Excel File
 * @author Hari
 **/
  public class ExcelFileUtility {
 /**
  * This Method will Read Data from Excel File Based on 
 * @throws IOException 
 * @throws EncryptedDocumentException 
  * 
  */
	  public String ReadDataFromExcelFile(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		  FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		  Workbook wb=WorkbookFactory.create(fis);
		  String Value=wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		  return Value;
	  }
	  
	  public Object[][] readMultipleDataFromExcel(String sheetname,int row,int cell) throws Throwable, IOException {
		  FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		  Workbook wb=WorkbookFactory.create(fis);
		 Sheet sh=wb.getSheet(sheetname);
		 int lastRow=sh.getLastRowNum();
		 int lastCol=sh.getRow(0).getLastCellNum();
		 
		 Object [][]data=new Object[lastRow][lastCol];
				 for(int i=1;i<lastRow;i++) {
					 for(int j=0;j<lastCol;j++) {
						 data[i][j]=sh.getRow(i).getCell(j).getRichStringCellValue();
					 }
					 }
				 return data;
				 }

	public String readDataFromeExcel(String string, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	  }

