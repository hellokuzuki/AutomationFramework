package readExcelData;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ReadExcel1 {
	public static void main(String[] args) throws Exception {
		
		File src = new File(System.getProperty("user.dir") + "\\src\\main\\java\\excelfiles\\TestData.xls");
		
		FileInputStream fis = new FileInputStream(src);
		
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		
		HSSFSheet sheet1 = wb.getSheetAt(0);
		
		int rowcount = sheet1.getLastRowNum();
		
		System.out.println("Row is =" + (rowcount+1));
		
		for (int i = 0; i< rowcount; i++) {
			String data0 = sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println(data0);
		}
		wb.close();
		
	}
}
