package automationpages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven {
//Identify Testcases column by scanning entire first row
//once column is identified scan entire Testcase column to get TC3datadrivensearch row 
	//once you grab TC3datadrivensearch you pull all the data and feed it into test
	public ArrayList<String>  getdata(String testcasename) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<String> a= new ArrayList<String>();
		FileInputStream fis=new FileInputStream("C://Users//PraveenReddy//Desktop//Selenium//Datadrivensearch.xlsx");
		  XSSFWorkbook workbook= new XSSFWorkbook(fis);
		  int sheets=workbook.getNumberOfSheets();
		  for(int i=0;i<sheets;i++) {
			  if(workbook.getSheetName(i).equalsIgnoreCase("Testdata")) {
			 
			  }
			
			  XSSFSheet sheet= workbook.getSheetAt(i);
				 Iterator<Row> rows=sheet.iterator();
				 Row firstrow=rows.next();
			Iterator<Cell> cl=firstrow.cellIterator();
			int k=0;
			int column = 0;
			while(cl.hasNext()) {
				Cell value=cl.next();
				if(value.getStringCellValue().equalsIgnoreCase("Testcase")) {
					column=k;
				}
				k++;
			}
			System.out.println(column);
			while(rows.hasNext()) 
			{
				Row r=rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) 
				{
					Iterator<Cell> cv=r.cellIterator();
					while(cv.hasNext()) 
					{
						a.add(cv.next().getStringCellValue());
					}
					
				}
			}
		  }
		return a;
		
	}

}
