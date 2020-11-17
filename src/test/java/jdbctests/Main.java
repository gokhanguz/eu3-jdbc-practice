package jdbctests;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        String dbUrl = "jdbc:oracle:thin:@3.85.237.76:1521:xe";
        String dbUsername = "hr";
        String dbPassword = "hr";

        //create connection
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        //crate statement object
        Statement statement=connection.createStatement();
        //run query and get the result in result set object
        ResultSet resultSet=statement.executeQuery("Select * from departments");

//        //move pointer to first row
//        resultSet.next();
//
//        //getting information with column name
//        System.out.println(resultSet.getString("region_name"));
//        //getting information with column index (starts from1)
//        System.out.println(resultSet.getString(2));
//        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString("region_name"));
//
//        //move pointer to second row
//        resultSet.next();
//
//          //getting information with column name
////        System.out.println(resultSet.getString("region_name"));
////        //getting information with column index (starts from)
////        System.out.println(resultSet.getString(2));
////        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString("region_name"));


        while(resultSet.next()){
            System.out.println(resultSet.getString(1)+" - "+resultSet.getString(2) +" - "+resultSet.getString(3) +" - "+ resultSet.getString(4));
        }
        //close all connections
        resultSet.close();
        statement.close();
        connection.close();

    }
}
