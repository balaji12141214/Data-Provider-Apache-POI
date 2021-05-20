package excelutils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelUtils {
	static XSSFWorkbook workbook;

	static XSSFSheet sheet;

	public static void getRowCount() throws IOException {

		workbook = new XSSFWorkbook("D:\\ToosQa\\formfilling\\excel\\url.xlsx");
//		
		// (or)
		// String currentFrameworkPath = System.getProperty("user.dir");
		// = new XSSFWorkbook(currentFrameworkPath\\excel\\url)

		sheet = workbook.getSheet("Sheet1");// Sheet1 is sheet name
		// sheet.getLastRowNum();
		// or
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);

	}

	public static String cellData() throws IOException {

		ExcelUtils.getRowCount();
		System.out.println(sheet.getRow(0).getCell(1).getStringCellValue());
		return sheet.getRow(0).getCell(1).getStringCellValue();
	}

}
