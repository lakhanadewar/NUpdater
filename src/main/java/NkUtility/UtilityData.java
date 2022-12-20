package NkUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UtilityData {

	public static String getExceldata(int rowNum, int cellNum) throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream(
				"C:\\Users\\lakha\\eclipse\\Fresh-eclipse-workspace\\Naukari\\TestData\\NaukariLoginDetails.xlsx");

		Sheet sh = WorkbookFactory.create(file).getSheet("naukaridata");

		String value = sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;

	}

}
