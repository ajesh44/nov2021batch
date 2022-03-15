package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	
	public static void screenshot(WebDriver driver ,String testID) throws IOException
	{
		
	  
	  String DateTime = new SimpleDateFormat(" dd-MM-yyyy-hh-mm-ss").format(new Date());
	  
	  File Source =	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  
	  File dest = new File("G:\\Screenshot\\" + testID + DateTime + ".jpg");
	  
	  FileHandler.copy(Source, dest);
	  
	}
	
	public static String getDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		
		String location = "G:\\testingdata.xlsx";
		
		FileInputStream file = new FileInputStream(location);
		String data = "";
		
		          Workbook w  = WorkbookFactory.create(file);
		try {
		    data =  w.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		}
		catch(IllegalStateException e)
		{
			double value = w.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
			data = String.valueOf(value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return data;
	}

}
