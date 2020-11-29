package HomeWork;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Working {
    public static void main(String[] args) throws SQLException {
        //it used form connect between java application and database
        //it help us access and manipulate data base

        String username="hr";
        String password="hr";
        String url="jdbc:oracle:thin:@3.80.189.73:1521:xe";

        //it help us to connect to database
        Connection connection= DriverManager.getConnection(url,username,password);
        //it help us to write and execute query
        Statement statement=connection.createStatement();
         // A data structure where we can store the dat came from database
        ResultSet resultSet=statement.executeQuery("select * from regions");

         //Connection,ResultSet,Statement are interface

//        resultSet.next();
//        System.out.println(resultSet.getInt("region_id"));
//        System.out.println(resultSet.getString("region_name"));
//        while ((resultSet.next())){
//            String firstname=resultSet.getString("region_name");
//            System.out.println(firstname);
//        }
    //LıST
       /* List<String> info=new ArrayList<>();
        while(resultSet.next()){
            String firstname=resultSet.getString("region_name");
            info.add(firstname);
        }
        System.out.println(info.toString());

        */
    //MAP

      /*  Map<String,Integer> info=new LinkedHashMap<>();
        while(resultSet.next()){

            String firstname=resultSet.getString("region_name");
            int id=resultSet.getInt("region_id");
            info.put(firstname,id);
            if(id>20){
                System.out.println(firstname);
            }
        }
        System.out.println(info.toString());

       */
       /* Connection connection1= DriverManager.getConnection(url,username,password);

        Statement statement1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet1=statement.executeQuery("select * from regions");

        resultSet1.first();//moves the cursor to first to the first row
        resultSet1.absolute(12);//moves to the cursor to the specified row
        resultSet1.relative(7);//move to cursor the given number of rows forward
        // or backward from where it is currently pointing
        resultSet1.getRow();//read the number of row
        resultSet1.previous();//move to cursor to the previous row
        resultSet1.beforeFirst();//move the cursor to the default position(before first row)

        */
        resultSet.close();
        statement.close();
        connection.close();


    }
}
