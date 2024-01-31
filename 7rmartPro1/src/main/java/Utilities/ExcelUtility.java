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
	
//	public static String getString(int i, int j, String sheet) {
//		
//		String file_path = GeneralUtility.TESTDATAFILE;
//		try {
//			f = new FileInputStream(file_path);
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//		}
//		try {
//			wb = new XSSFWorkbook(f);
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//		sh = wb.getSheet(sheet);
//		Row r = sh.getRow(i);
//		Cell c = r.getCell(j);
//		return c.getStringCellValue();
//	}
//
//}

public static String getStringData(int a, int b, String sheet) throws IOException {
		
		String filepath = GeneralUtility.TESTDATAFILE;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
