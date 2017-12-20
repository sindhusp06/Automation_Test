package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AUL {
	//Generic getProperty
	public static String getProperty(String path,String key) throws FileNotFoundException, IOException
	{
		String v=" ";
		try
	{
		Properties p=new Properties();
		p.load(new FileInputStream(path));
		v=p.getProperty(key);
	}
	catch(Exception e)
		{
	
		}
return v;
}

//Generic getRowcount
public static int getRowCount(String path,String sheet)
{
	int rc=0;
	try
	{
		Workbook wb=WorkbookFactory.create(new FileInputStream(path));
		rc=wb.getSheet(sheet).getLastRowNum();
	}
	catch(Exception e)
	{
		
	}
	return rc;
}


//Generic getExceldata

public static String getCellValue(String path,String sheet,int r,int c)
{
	String s="";
	try
	{
		Workbook wb=WorkbookFactory.create(new FileInputStream(path));
		wb.getSheet(sheet).getRow(r).getCell(c).toString();
	}
		catch(Exception e)
	{
			
	}
	return s;
}
//Generic getPhoto
public static void getPhoto(WebDriver driver,String path,String testName)
{
	String datetime=new Date().toString().replaceAll(":", "_");
	TakesScreenshot t=(TakesScreenshot) driver;
	File srcFile=t.getScreenshotAs(OutputType.FILE);
	String destFile=path+testName+datetime+".png";
	System.out.println("Photo is :"+destFile);
	try
	{
		FileUtils.copyFile(srcFile, new File(destFile));
	}
	catch(Exception e)
	{
		
	}
}
}

