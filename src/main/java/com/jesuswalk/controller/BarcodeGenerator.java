package com.jesuswalk.controller;

import com.barcodelib.barcode.Linear;

import io.swagger.annotations.Api;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("service")
@RequestMapping(value = "service")
public class BarcodeGenerator {
    
    @RequestMapping(value = "/barcodes", method = RequestMethod.GET)
    public void getFile(
    		@RequestParam("source") String source,
    		@RequestParam("output") String output) {
       try {
    	   Linear linear = new Linear();
    	   linear.setType(Linear.CODE128);
    	   for (String name : fromSpreadsheet(source)) {
    		   linear.setData(name);
    		   linear.renderBarcode(output + "/" + name+ "-barcode.png");
    	   }
    	   
       } catch (Exception ex) {
    	   
       }
    }
    
    private List<String> fromSpreadsheet(String source) {
    	List<String> ret = new ArrayList<String>();
    	 try
         {
             FileInputStream file = new FileInputStream(new File(source));
  
             //Create Workbook instance holding reference to .xlsx file
             XSSFWorkbook workbook = new XSSFWorkbook(file);
  
             //Get first/desired sheet from the workbook
             XSSFSheet sheet = workbook.getSheetAt(0);
  
             //Iterate through each rows one by one
             Iterator<Row> rowIterator = sheet.iterator();
             while (rowIterator.hasNext()) 
             {
                 Row row = rowIterator.next();
                 //For each row, iterate through all the columns
                 Iterator<Cell> cellIterator = row.cellIterator();
                  
                 String value = "";
                 for(int i = 0; i < 2; i++) 
                 {
                     Cell cell = cellIterator.next();
                     value += cell.getStringCellValue()+ " ";
                 }
                 ret.add(value);
             }
             
             file.close();
             workbook.close();
            
         } 
         catch (Exception e) 
         {
             e.printStackTrace();
         } finally {
        	
         }
    	return ret;
    }

}
