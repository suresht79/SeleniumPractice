package com.expedia.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SaberLibrary {
 
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;
    
    private static final String FILE_NAME = "C:\\TCS\\Personal\\QA\\flightTestData.xlsx";

    public static void main(String[] args) throws Exception{
    	 //ArrayList<Map<String,String>> excelData = getExcelData( FILE_NAME, "roundTrip");
    	 //System.out.println(excelData);
    }
 
    // This method is to set the File path and to open the Excel file, Pass
    // Excel Path and Sheet name as Arguments to this method
    public static  Map<String,String> getExcelData(String FilePath, String SheetName) throws Exception {
    	ArrayList<Map<String,String>> listMap = new ArrayList<Map<String,String>>();
        ArrayList<String> keys = new ArrayList<String>();
        List<List> values = new ArrayList<List>();
        ArrayList<String> tempList = new ArrayList<String>();
        try {
            // Access the required test data sheet
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
 
            int totalNoOfCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();;
            int totalNoOfRows = ExcelWSheet.getLastRowNum() + 1;
 
 
            for (int i = 0; i < totalNoOfRows; i++) {
            	tempList = new ArrayList();
                for (int j = 0; j < totalNoOfCols; j++) {
                    Cell = ExcelWSheet.getRow(i).getCell(j);
                    int cel_Type = Cell.getCellType();
                    switch (cel_Type) {
                    case XSSFCell.CELL_TYPE_NUMERIC: // 0
                        if (DateUtil.isCellDateFormatted(Cell)) {
                            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                            tempList.add(df.format(Cell.getDateCellValue()));
                        } else {
                        	tempList.add(String.format("%d", (long) Cell.getNumericCellValue()));
                        }
                        break;
                    case XSSFCell.CELL_TYPE_STRING: // 1
                    	tempList.add(Cell.getStringCellValue());
                        break;
                    }
                }
                if(i==0){
                	keys = tempList;
                }
                else{
                	values.add(tempList);
                }
            }
            
            
			for (int i = 0; i < values.size(); i++) {
				Map map = new HashMap();
				for (int j=0;j<keys.size();j++){
	            	map.put(keys.get(j), values.get(i).get(j));
				}
				listMap.add(map);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return listMap.get(0);
    }
}


	