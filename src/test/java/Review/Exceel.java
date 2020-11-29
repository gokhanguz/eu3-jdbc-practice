package Review;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exceel {
    public static void main(String[] args) throws IOException {

        FileInputStream file=new FileInputStream("masaüstündeki exceel pathi.xlxs");

        //if you are using xlxs==>xssf
        //if you are using xls==>hssf
         //create object for xss workbook
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        System.out.println(workbook.getNumberOfSheets());

        //get the specific sheet and read data

        XSSFSheet sheet=workbook.getSheet("Sheet1");
       // XSSFSheet sheet1=workbook.getSheetAt(1);


        sheet.getLastRowNum();
        sheet.getRow(5).getFirstCellNum();

    }
}
