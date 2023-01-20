package com.scm.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility extends JavaUtility {
	/**
	 * This method is used to read data from excel
	 * @author Siddharth
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	

	public String readDataFromExcel(String SheetName, int RowNo, int ColumnNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.getRow(RowNo);
		Cell cel = ro.getCell(ColumnNo);
		String value = cel.getStringCellValue();
		return value;
	}
	/**
	 * This method is used to write data into excel
	 * @author Siddharth
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	

	

	
	public void writeDataIntoExcel(String SheetName, int RowNo, int ColumnNo, String data) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(SheetName);
	Row ro = sh.createRow(RowNo);
	Cell cel = ro.createCell(ColumnNo);
	cel.setCellValue(data);
	FileOutputStream fos=new FileOutputStream(IPathConstants.ExcelPath);
	wb.write(fos);

}
	/**
	 * This method is used to get last row count
	 * @author Siddharth
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public int getLastRowNo(String SheetName) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(SheetName);
	int count = sh.getLastRowNum();
	return count;
}

public Map<String,String>getList(String sheetName, int keyCell, int valueCell) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	int count = sh.getLastRowNum();
	Map<String,String> map=new HashMap<String,String>();
	for(int i=0; i<=count;i++)
	{
		String key = sh.getRow(i).getCell(keyCell).getStringCellValue();
		String value = sh.getRow(i).getCell(valueCell).getStringCellValue();
		map.put(key, value);
		
	}
	return map;
}
	
}
