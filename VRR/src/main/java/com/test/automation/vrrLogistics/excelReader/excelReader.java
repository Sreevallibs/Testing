package com.test.automation.vrrLogistics.excelReader;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class excelReader 
{
	
	@DataProvider(name="Test")
	public String[][] readExcel() throws IOException
	{
		System.out.println("Test");
		FileInputStream path=new FileInputStream("D:\\Test.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(path);
		XSSFSheet sheet=book.getSheet("Sheet1");
		int row=sheet.getLastRowNum()+1;
		int cell=sheet.getRow(0).getLastCellNum();
		//System.out.println(row);
		//System.out.println(cell);
		String data[][]=new String[row][cell];
		for (int i=0;i<row;i++)
		{
			XSSFRow row1=sheet.getRow(i);
			for(int j=0;j<cell;j++)
			{
				XSSFCell cell1=row1.getCell(j);
				data[i][j]=cell1.getStringCellValue();
				//System.out.println(data[i][j]);
			}
					
		}
		return data;

}
}
