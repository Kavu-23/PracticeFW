package excelFile;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromMultipleRow {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Desktop\\ExcelData.xlsx");
		Workbook Wb = WorkbookFactory.create(fis);
		Sheet sh=Wb.getSheet("Sheet3");	
		
		int Count= sh.getLastRowNum();
		
		for(int i=0;i<Count;i++)
		{
			Row row = sh.getRow(i);
			
			String Coloumn1Data =row.getCell(0).toString();
			String Coloumn2Data = row.getCell(1).toString();
			
			System.out.println(Coloumn1Data +"\t"+ Coloumn2Data);
			
		}
		
          Wb.close();
	}

}
