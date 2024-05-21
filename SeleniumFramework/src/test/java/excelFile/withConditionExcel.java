package excelFile;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class withConditionExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		String ExpectedId= "Wipro";
		String data1="";
		String data2="";
		
		boolean flag=false;
		
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Desktop\\ExcelData.xlsx");
		Workbook Wb = WorkbookFactory.create(fis);
		Sheet sh=Wb.getSheet("Sheet3");	
		
		int Count= sh.getLastRowNum();
		
		for(int i=1;i<=Count;i++)
		{
			String data ="";
			
			try {
				data=sh.getRow(i).getCell(0).toString();
				if(data.equals(ExpectedId))
				{
					flag=true;
					
					data1=sh.getRow(i).getCell(1).toString();
					data2=sh.getRow(i).getCell(2).toString();
				}
			}catch(Exception e) {}
		}

      if(flag==true) {
    	  System.out.println(data1);
    	  System.out.println(data2);
      }
      else {
    	  System.out.println(ExpectedId+"data is not available");
      }
      
      Wb.close();
	}
	      

}
