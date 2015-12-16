package readExcelData;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ReadExcel {
	public static void main(String[] args) throws Exception {
		
		File src = new File(System.getProperty("user.dir") + "\\src\\main\\java\\excelfiles\\TestData.xls");
		
		FileInputStream fis = new FileInputStream(src);
		
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		
		HSSFSheet sheet1 = wb.getSheetAt(0);
		
		String test = sheet1.getRow(0).getCell(0).getStringCellValue();
		
		System.out.println(test);
		
		wb.close();
		
	}
}
