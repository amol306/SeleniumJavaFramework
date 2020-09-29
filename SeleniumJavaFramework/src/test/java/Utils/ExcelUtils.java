package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelUtils {

	public static void main(String[] args) throws Exception {
		getRowCount();
	}

	@Test(dataProvider="Test1Data")
	public static void ExcelDataTest(Object[] a) {
		System.out.println(a[0]);
	}
	
	@DataProvider(name="Test1Data")
	public static Object[] getData() {
		//getRowCount();
		Object[] obj = new Object[1];
		obj[0] = "DataProvider";
		return obj;
	}
	
	public static void getRowCount() {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\Excel\\data.xlsx");
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			System.out.println("Row Count : " + sheet.getPhysicalNumberOfRows());
			System.out.println("Cell Data : " + sheet.getRow(0).getCell(0));
			workbook.close();
		} catch (Exception ex) {
			System.out.println("Catch Exception!");
			System.out.println("ex.getMessage() : " + ex.getMessage());
			System.out.println("ex.getCause() : " + ex.getCause());
			ex.printStackTrace();
		}

	}

}
