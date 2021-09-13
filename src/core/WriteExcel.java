package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WriteExcel {

	public static void modifyExistingWorkbook(ArrayList<Object[]> allobj,String excelFilePath) throws InvalidFormatException, IOException {
		// Obtain a workbook from the excel file
		//Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
		
		FileInputStream file = new FileInputStream(new File(excelFilePath));

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get Sheet at index 0
		Sheet sheet = workbook.getSheetAt(0);
		int rowid = 2;
		XSSFRow rows;

		for (int x = 0; x < allobj.size(); x++) {//Looping thru the array list to pick the objects...
            rows = (XSSFRow) sheet.createRow(rowid++);
            Object[] objectArr = allobj.get(x);
            int cellid = 0;
            for (Object obj : objectArr) {//Looping inside the object...
                Cell cells = rows.createCell(cellid++);
                if (obj instanceof String) {
                    String val = (String) obj;
                    if (val.length() > 30000) {
                        val = val.substring(0, 30000);
                    }
                    cells.setCellValue(val);
                } else if (obj instanceof Integer) {
                    cells.setCellValue((int) obj);
                } else if (obj instanceof Double) {
                    cells.setCellValue((double) obj);
                }
            } // End of for loop for object
        }
		// Write the output to the file
		FileOutputStream fileOut = new FileOutputStream(excelFilePath);
		workbook.write(fileOut);
		fileOut.close();

		// Closing the workbook
		workbook.close();
	}
	
	public static void modifyExistingWorkbook2(ArrayList<Object[]> allobj,String excelFilePath) throws InvalidFormatException, IOException {
		// Obtain a workbook from the excel file
		Workbook workbook = WorkbookFactory.create(new File(excelFilePath));

		// Get Sheet at index 0
		Sheet sheet = workbook.getSheetAt(0);
		int rowid = 0;
		XSSFRow rows;

		int rowid2 = sheet.getLastRowNum();
        int x;
        for (x = 0; x < allobj.size(); x++) {//Looping thru the array list to pick the objects...
            rows = (XSSFRow) sheet.createRow(++rowid2);
            Object[] objectArr = allobj.get(x);
            int cellid = 0;
            for (Object obj : objectArr) {//Looping inside the object...
                Cell cells = rows.createCell(cellid++);
                if (obj instanceof String) {
                    String val = (String) obj;
                    if (val.length() > 30000) {
                        val = val.substring(0, 30000);
                    }
                    cells.setCellValue(val);
                } else if (obj instanceof Integer) {
                    cells.setCellValue((int) obj);
                } else if (obj instanceof Double) {
                    cells.setCellValue((double) obj);
                }
            } // End of for loop for object
        }//End of for loop for arraylist of object....
		// Write the output to the file
		FileOutputStream fileOut = new FileOutputStream(excelFilePath);
		workbook.write(fileOut);
		fileOut.close();

		// Closing the workbook
		workbook.close();
	}
	

}
