package edu.practise.packagename;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelRead {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("./reports/EmployeedataFAFC.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet worksheet = workbook.getSheet("Sheet1");
	
		int rowcount = worksheet.getLastRowNum()+1;
		System.out.println("rowcount: " + rowcount);
		
		
		//XSSFRow row = worksheet.getRow(0);
		
		/*//reading all the data from excel 
		for (int i = 0; i <rowcount; i++) {
			
			XSSFRow row = worksheet.getRow(i);
			String cellval = row.getCell(0).getStringCellValue();
			System.out.println(cellval);

		}
*/		
		//String cellval = row.getCell(0).getStringCellValue();
		//System.out.println(cellval);
		
		worksheet.createRow(rowcount).createCell(0).setCellValue("oceanacademy");
		
		int updatedrowcount = worksheet.getLastRowNum()+1;
		System.out.println("new rowcount: " + updatedrowcount);
		
		FileOutputStream fos = new FileOutputStream("./reports/EmployeedataFAFC.xlsx");
		workbook.write(fos);
		workbook.close();

		System.out.println("Record saved successfully ");

		

	}

}
