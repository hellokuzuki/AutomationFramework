package readExcelData;

import lib.ExcelDataConfig;

public class ReadExcelData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExcelDataConfig excel = new ExcelDataConfig(System.getProperty("user.dir") + "\\src\\main\\java\\excelfiles\\TestData.xls");
		
		System.out.println(excel.getData(1, 0, 0));
		
	}

}
