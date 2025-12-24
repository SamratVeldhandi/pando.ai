package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    private Workbook workbook;
    private Sheet sheet;

    // Constructor
    public ExcelUtility(String filePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get cell data as String
    public String getCellData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);

        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    // Get row count
    public int getRowCount() {
        return sheet.getLastRowNum();
    }

    // Get column count
    public int getColumnCount() {
        return sheet.getRow(0).getLastCellNum();
    }

    // Close workbook
    public void closeExcel() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
