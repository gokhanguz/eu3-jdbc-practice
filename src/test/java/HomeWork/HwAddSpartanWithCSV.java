package HomeWork;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HwAddSpartanWithCSV {

    //Optional homeworks
    //Homework-1
    //1-Create csv file from mackaroo website, which includes name,gender,phone
    //2-Download csv file
    //3- using testng data provider and apache poi create data driven posting from spartan


    public static void main(String[] args) throws IOException, CsvException {


        CSVReader csvReader=new CSVReader(new FileReader("C:\\Users\\Gökhan\\IdeaProjects\\eu3-jdbc-practice\\SpartanInformation.csv"));
        List<String[]> list=csvReader.readAll();


        Iterator<String[]>iterator= list.iterator();

        while(iterator.hasNext()){

            String[] str=iterator.next();

            System.out.print(" Values are ");

            for(int i=0;i<str.length;i++){

                System.out.print(" "+str[i]);

            }

            System.out.println("   ");


        }
    }

//    public  List<Map<String, String>> getDataList() {
//
//        // this will be returned
//        List<Map<String, Object>> data = new ArrayList<>();
//
//        for (int i = 0; i < 3; i++) {
//
//            Map<String, Object> rowData = new HashMap<>();
//
//        }
//
//    }

}
