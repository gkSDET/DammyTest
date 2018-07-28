package test;


import java.util.ArrayList;

import java.util.Iterator;

import java.util.Map;



public class ExcelReader
{

	public static void main(String args[])
	{
	   ArrayList<String>                colNames      = null;
	   ArrayList<Map<String, Object>>   columnMaps    = null;
	   ExcelReader                      excelReader   = null;
	   Iterator<String>                 colNamesIt    = null;
	   Iterator<Map<String, Object>>    columnMapsIt  = null;
	   Map<String, Object>              columnMap     = null;
	   String                           colKey        = null;
	   String[]                         myRecordings  = new
	      String[]{"id", "City"};

	   try
	   {
	      excelReader = getInstance("C:\\Users\\kgcha\\Desktop\\data.xlsx");

	      for(int i=0; i < myRecordings.length; i++)
	      {
	         colNames     = excelReader.getColNames(myRecordings[i]);
	         colNamesIt   = colNames.iterator();
	         columnMaps   = excelReader.getMappedValues(myRecordings[i]);
	         columnMapsIt = columnMaps.iterator();

	         while(columnMapsIt.hasNext())
	         {
	            columnMap     = columnMapsIt.next();

	            while(colNamesIt.hasNext())
	            {
	               colKey = colNamesIt.next();

	               System.out.println(colKey+"\t"+
	                  ((columnMap.get(colKey)!=null)?
	                    columnMap.get(colKey):""));
	            }
	            System.out.println("---------------------------------");
	            colNamesIt = colNames.iterator();
	         }
	      }
	   }
	   catch (Exception any)
	   {
	      any.printStackTrace();
	   }
	}

	private ArrayList<Map<String, Object>> getMappedValues(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private  ArrayList<String> getColNames(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private static ExcelReader getInstance(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}