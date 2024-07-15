package ddt.packages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class DDT_File {

	public static String userNameCell;
	public static String passwordCell;

	@Test
	public void dataFetching() throws EncryptedDocumentException, IOException {

		String sheetName = "credentials";
		FileInputStream file = new FileInputStream("C:\\Users\\ishan\\git\\Selenium\\TestData\\Amazon login.xlsx");
		Workbook workbook = WorkbookFactory.create(file);

		userNameCell = workbook.getSheet(sheetName).getRow(1).getCell(0).getStringCellValue();
		passwordCell = workbook.getSheet(sheetName).getRow(1).getCell(1).getStringCellValue();
	}
}
