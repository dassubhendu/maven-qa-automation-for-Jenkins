package com.utility;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ExcelUtility {

    public static String getTestDataFromExcel(int rowNumber, int cellNumber) throws IOException, InvalidFormatException {
        // Create file class object
        File file = new File("./src/testData/testData.xlsx");

        // Create workbook object
        XSSFWorkbook book = new XSSFWorkbook(file);

        // Create sheet object
        Sheet sheet = book.getSheet("LoginData");

        // Specify the row and cell number
        return sheet.getRow(rowNumber).getCell(cellNumber).getStringCellValue();

    }
}
