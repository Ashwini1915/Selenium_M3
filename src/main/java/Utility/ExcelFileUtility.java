package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

    private Workbook wb;

    private final String path = "./src/test/resources/VCRM testdata.xlsx";

    public String fetchDataFromExcelFile(String sheetname, int rowindex, int cellindex)
            throws EncryptedDocumentException, IOException {

        FileInputStream fis = new FileInputStream(path);
        wb = WorkbookFactory.create(fis);

        Sheet sheet = wb.getSheet(sheetname);
        if (sheet == null) {
            throw new RuntimeException("Sheet NOT found: " + sheetname);
        }

        Row row = sheet.getRow(rowindex);
        if (row == null) {
            throw new RuntimeException("Row " + rowindex + " is EMPTY in sheet " + sheetname);
        }

        Cell cell = row.getCell(cellindex);
        if (cell == null) {
            throw new RuntimeException("Cell " + cellindex + " is EMPTY in row " + rowindex);
        }

        return cell.toString();
    }
    public void closeExcelFile() throws IOException {
        if (wb != null) {
            wb.close();
        }
    }
}