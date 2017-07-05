package com.amazon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;

public class SaberLibraryTest {
 
    private static HSSFSheet ExcelWSheet;
    private static HSSFWorkbook ExcelWBook;
    private static HSSFCell Cell;
    private static HSSFRow Row;
    
    private static final String FILE_NAME = "C:\\TCS\\Personal\\QA\\flightTestData_testcase.xls";

    public static void main(String[] args) throws Exception{
    	
    	 System.out.println("testcase Data for: " + "bookRoundTripFlightTest");
    	 ArrayList<Map<String,String>> testCaseData = getTestCaseData( FILE_NAME, "roundTrip", "bookRoundTripFlightTest");
    	 System.out.println(testCaseData);
    	 /*
    	 System.out.println("\ntestcase Data for: " + "bookOneWayFlightTest");
    	 excelData = getTestCaseData( FILE_NAME, "roundTrip", "bookOneWayFlightTest");
    	 System.out.println(excelData);*/
    }
 
    // This method is to set the File path and to open the Excel file, Pass
    // Excel Path and Sheet name as Arguments to this method
    public static  ArrayList<Map<String,String>> getTestCaseData(String FilePath, String SheetName, String testCaseName) throws Exception {
    	ArrayList<Map<String,String>> listMap = new ArrayList<Map<String,String>>();
        
    	ArrayList<String> keysList = new ArrayList<String>();
        ArrayList<List> valuesList = new ArrayList<List>();
        ArrayList<String> tempList = new ArrayList<String>();
        try {
            // Access the required test data sheet
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            ExcelWBook = new HSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
 
            int totalNoOfRows = ExcelWSheet.getLastRowNum() + 1;
            int totalNoOfCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();;
            
            int k=0;

            for (int i = 0; i < totalNoOfRows; i++) {
            	if(null==ExcelWSheet.getRow(i)){
            		continue;
            	}
            	Cell = ExcelWSheet.getRow(i).getCell(0);
            	if(testCaseName.equalsIgnoreCase(Cell.getStringCellValue())){
            		
	            	tempList = new ArrayList();
	                for (int j = 0; j < totalNoOfCols; j++) {
	                    Cell = ExcelWSheet.getRow(i).getCell(j);
	                    if(null==Cell){
	                    	continue;
	                    }
	                    int cel_Type = Cell.getCellType();
	                    switch (cel_Type) {
	                    case HSSFCell.CELL_TYPE_NUMERIC: // 0
	                        if (DateUtil.isCellDateFormatted(Cell)) {
	                            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	                            tempList.add(df.format(Cell.getDateCellValue()));
	                        } else {
	                        	tempList.add(String.format("%d", (long) Cell.getNumericCellValue()));
	                        }
	                        break;
	                    case HSSFCell.CELL_TYPE_STRING: // 1
	                    	tempList.add(Cell.getStringCellValue());
	                        break;
	                    }
	                }
	                if(k==0){
	                	keysList = tempList;
	                	k++;
	                }
	                else{
	                	valuesList.add(tempList);
	                }
            	}
            }
            
            
			for (int i = 0; i < valuesList.size(); i++) {
				Map map = new HashMap();
				for (int j=0;j<keysList.size();j++){
	            	map.put(keysList.get(j), valuesList.get(i).get(j));
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
        return listMap;
    }
}


	