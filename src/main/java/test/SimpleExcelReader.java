package test;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class SimpleExcelReader {
    static String cellValue=null;
    static Integer id=null;
   public static void main(String[] args) throws IOException, JSONException {
       String excelFilePath = "C:\\Users\\kgcha\\Desktop\\data.xlsx";
       FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
       HashMap<String, String> data = new HashMap<String, String>();
       HashMap <String, String> keyValuePair = new HashMap<String, String>();
       int n = 5;
	ArrayList arrli = new ArrayList();
      
	Workbook workbook = new XSSFWorkbook(inputStream);
       Sheet firstSheet = workbook.getSheetAt(0);
       DataFormatter formatter = new DataFormatter();
       Iterator<Row> iterator = firstSheet.iterator();
       for (int i=0;iterator.hasNext();)
       {   
      while (iterator.hasNext()) {
           Row nextRow = iterator.next();
           Iterator<Cell> cellIterator = nextRow.cellIterator();
            
           while (cellIterator.hasNext()) {
               Cell cell = cellIterator.next();
                
               switch (cell.getCellType()) {
                   case Cell.CELL_TYPE_STRING:
                	    System.out.print(cell.getStringCellValue());
                	    data.put("City", cell.getStringCellValue()); 
                       break;
                   case Cell.CELL_TYPE_BOOLEAN:
                       System.out.print(cell.getBooleanCellValue());
                       break;
                   case Cell.CELL_TYPE_NUMERIC:
                       System.out.print(cell.getNumericCellValue());
                       //arrli.add(i); 
                       data.put("ID", String.valueOf(cell.getNumericCellValue()));
                       break;
               }

               System.out.print("");
               
           }
           keyValuePair.put(data.get("ID"), data.get("City"));
           System.out.println(keyValuePair);
      }

      System.out.println(keyValuePair);

       }
   }
}
          /* // Start constructing JSON.
	    JSONObject json = new JSONObject();

	    // Iterate through the rows.
	    JSONArray rows = new JSONArray();
	    for ( Iterator<Row> rowsIT = firstSheet.rowIterator(); rowsIT.hasNext(); )
	    {
	        Row row = rowsIT.next();
	        JSONObject jRow = new JSONObject();

	        // Iterate through the cells.
	        JSONArray cells = new JSONArray();
	        for ( Iterator<Cell> cellsIT = row.cellIterator(); cellsIT.hasNext(); )
	        {
	            Cell cell = cellsIT.next();
	            cells.put( cell.getStringCellValue() );
	        }
	        jRow.put( "cell", cells );
	        rows.put( jRow );
	    }

	    // Create the JSON.
	    json.put( "rows", rows );

	// Get the JSON text.
	    System.out.print( json);
       workbook.close();
       inputStream.close();
   }
*/
