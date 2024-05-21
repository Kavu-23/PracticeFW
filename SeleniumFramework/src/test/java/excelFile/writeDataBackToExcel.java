package excelFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class writeDataBackToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Desktop\\ExcelData.xlsx");
		Workbook Wb = WorkbookFactory.create(fis);
		Sheet sh=Wb.getSheet("Sheet3");
		Row row= sh.getRow(1);
		
		Cell cel=row.createCell(4);
		cel.setCellValue("Pass");
		
		FileOutputStream fos  = new FileOutputStream("C:\\Users\\DELL\\Desktop\\ExcelData.xlsx");
		Wb.write(fos);
		Wb.close();
		
		System.out.println("Expected");

	}

}
