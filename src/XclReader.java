package raedxml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XclReader {

	public static void main(String[] args) throws IOException {
		
		File file = new File("F:\\Techm_Code\\Excel dependency\\employee.xlsx"); // creating a new file instance
		FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
		// creating Workbook instance that refers to .xlsx file
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("defects");
		TableStartTag();
		defineTableCaptionTag(); // Table caption 
		int count = 0; // to validate this is first time then mark as header
		for (Row row : sheet) {
		    Cell firstCell = row.getCell(1);
		    Cell firstCell1 = row.getCell(2);
		    if (count==0) {
				System.out.println("<tr>");
				System.out.print("<th>" + firstCell + "</th>");
				System.out.print("<th>" + firstCell1 + "</th>");
		    } else {
		    	System.out.println("<tr>");
				System.out.print("<td>" + firstCell + "</td>");
				System.out.print("<td>" + firstCell1 + "</td>");
		    }
		    count = count+1;
		    System.out.println("");
		   
		}
		 defineTableClosingTag();
		 TableCloseTag();		
	}

	private static void defineTableCaptionTag() {
		System.out.println( "<caption>Department List</caption>");
	}

	private static void defineTableClosingTag() {
		System.out.println("</table>");
		
	}

	private static void defineTableStyleOpenTag() {
		System.out.println("<table style=\"width:100%\">");
	}

	private static void defineHtmlBodyOpenTag() {
		System.out.println("<body>");
		
	}
	
	private static void defineHtmlBodyCloseTag() {
		System.out.println("</body>");
		
	}

	private static void defineHtmlHeaderOpen() {
		System.out.println("<head>");
		
	}
	private static void defineHtmlHeaderClose() {
		System.out.println("</head>");
		
	}
	private static void defineStyleTag() {
		System.out.println("<style>");
		System.out.println("table, th, td {");
		System.out.println("border: 1px solid black;");
		System.out.println("border-collapse: collapse;");
		System.out.println("}");
		System.out.println("th, td {");
		System.out.println(" padding: 5px;");
		System.out.println("text-align: left;");
		System.out.println("}");
		System.out.println("</style>");
		
	}
	private static void defineHtmlOpenTag(){
		System.out.println("<html>");
	}
	
	private static void defineHtmlCloseTag(){
		System.out.println("</html>");
	}
	
	private static void TableStartTag() {
		defineHtmlOpenTag();
		defineHtmlHeaderOpen();
		defineStyleTag();
		defineHtmlHeaderClose();
		defineHtmlBodyOpenTag();
		defineTableStyleOpenTag();
	}
	
	private static void TableCloseTag() {
		 defineHtmlBodyCloseTag();
		 defineHtmlCloseTag();
	}


}
