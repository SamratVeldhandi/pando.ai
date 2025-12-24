package Utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name="data")
    public String[][] getData() {
        ExcelUtility el = new ExcelUtility(".//TestData/Book1.xlsx", "sheet2");
        int rows = el.getRowCount();
        int cols = el.getColumnCount();
        String[][] exceldata = new String[rows][cols];
        for(int i=1;i<=rows;i++){
            for(int j=0;j<cols;j++){
                exceldata[i-1][j] = el.getCellData(i,j);
            }
        }

    return exceldata;
    }
}
