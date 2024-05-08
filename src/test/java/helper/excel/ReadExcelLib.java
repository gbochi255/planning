package helper.excel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelLib {

    final static Logger log = LogManager.getLogger(ReadExcelLib.class);

    public Object[][] Get_Excel_Data(String filename, String sheetname, int numberOfCols) {

        File file = new File(filename);

        XSSFWorkbook wkbook;
        XSSFSheet sheet;
        Object[][] arr = new Object[0][0];

        try {
            FileInputStream excel = new FileInputStream(file);
            wkbook = new XSSFWorkbook(excel);
            sheet = wkbook.getSheet(sheetname);
            int start = sheet.getFirstRowNum();
            int end = sheet.getLastRowNum();
            arr = new Object[end - start + 1][numberOfCols];
            for (int i = start; i <= end; i++) {
                for (int j = 0; j <= numberOfCols - 1; j++) {
                    arr[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                }
            }

        } catch (IOException e) {
            log.info(e.getMessage());
        }

        return arr;
    }
}
