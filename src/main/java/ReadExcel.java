import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public void excel_Read() {
		try {
			FileInputStream file = new FileInputStream(new File("C:\\Users\\Administrator\\git\\JavaApachePOI\\src\\main\\resources\\Emp_Data.xlsx"));

			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {

			  Row row = rowIterator.next();

			  //For each row, iterate through all the columns
			  Iterator<Cell> cellIterator = row.cellIterator();
			   
			  while (cellIterator.hasNext()) {

			    Cell cell = cellIterator.next();

			    //Check the cell type and format accordingly
			    switch (cell.getCellType()) {
			      case NUMERIC:
			        System.out.print(cell.getNumericCellValue() + "|");
			        break;
			      case STRING:
			        System.out.print(cell.getStringCellValue() + "|");
			        break;
				default:
					break;
			    }
			  }
			  System.out.println("");
			}
			file.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadExcel rd = new ReadExcel();
		rd.excel_Read();
	}

}
