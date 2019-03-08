package Login_TestCase;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.vrrLogistics.baseClass.testBase;
import com.test.automation.vrrLogistics.uiActions.Login_Page;


public class TC_001_verifyLoginsScreen extends testBase{
	
	Login_Page obj;
	int i=0;
	
	@BeforeTest
	public void launch() throws IOException
	{
		init();
		obj=new Login_Page(driver);
	}
	
	@Test(dataProvider="Test")
	public void validUserName(String str,String str1, String str2)
	{
		
	obj.loginToApplication(str,str1);
	obj.errMessage(str2);
	
	}
	
	
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
				System.out.println(data[i][j]);
			}
					
		}
		return data;


}
}


