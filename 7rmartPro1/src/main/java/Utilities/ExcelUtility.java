package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileInputStream f;

public static String getStringData(int a, int b, String sheet) throws IOException {
		
		String filepath = GeneralUtility.TESTDATAFILE;
		f= new FileInputStream(filepath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(a);
		Cell c = r.getCell(b);
		return c.getStringCellValue();
	}

public static String getStringData(int a, int b, String sheet, String filepath) throws IOException {
	
	f= new FileInputStream(filepath);
	wb = new XSSFWorkbook(f);
	sh = wb.getSheet(sheet);
	Row r = sh.getRow(a);
	Cell c = r.getCell(b);
	return c.getStringCellValue();
}
	
public static String getIntegerData(int a, int b, String sheet) throws IOException {
		
		String filepath = GeneralUtility.TESTDATAFILE;
		f= new FileInputStream(filepath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(a);
		Cell c = r.getCell(b);
		int x = (int) c.getNumericCellValue();
		return String.valueOf(x);
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
