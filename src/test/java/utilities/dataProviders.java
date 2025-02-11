package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataProviders {

	
	@DataProvider(name = "LoginData")
	public String [][] getData() throws IOException{
		String path = "C:\\Users\\shaik\\eclipse-workspace\\opencartv1\\test-data\\loginData.xlsx";
		excelUtilitis xlutil = new excelUtilitis(path);
		int totalRow=xlutil.getRowCount("sheet1");
		int totalCol=xlutil.getCellCount("sheet1",1);
		
		String logindata [][]=new String[totalRow][totalCol];
		for(int i=1;i<=totalRow; i++) 
		{
		for(int j=0;j<totalCol; j++) 
		{
		logindata[i-1][j] = xlutil.getCellData("Sheet1",i, j);
		}
		}
		return logindata;//returning two dimension array
		
		
		
		
		
	}
	
	
}
