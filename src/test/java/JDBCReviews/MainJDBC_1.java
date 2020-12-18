package JDBCReviews;

import oracle.sql.NUMBER;
import org.testng.annotations.Test;

import java.sql.*;

public class MainJDBC_1 {

    @Test
    public void test1() throws SQLException {
        String url="jdbc:oracle:thin:@3.85.237.76:1521:xe";
        String user="hr";
        String password="hr";

        Connection connection= DriverManager.getConnection(url,user,password);

        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet=statement.executeQuery("select * from employees");
//
//        while(resultSet.next()){
//
//            System.out.println(resultSet.getString(5));
//        }
//
//        resultSet.beforeFirst();
//        while(resultSet.next()){
//
//            System.out.println(resultSet.getString(2));
//        }

        resultSet.beforeFirst();

        resultSet.next();
        System.out.println("*******************************************");
        System.out.println(resultSet.getString(2));
        System.out.println(resultSet.relative(2));
        System.out.println(resultSet.getString(2));
        System.out.println(resultSet.getString(2));
        System.out.println("resultSet.absolute(3) = " + resultSet.absolute(3));
        System.out.println(resultSet.getString(2));

        System.out.println("resultSet.getObject(2) = " + resultSet.getObject(2));

        System.out.println(resultSet.getObject("first_name"));
        System.out.println("*******************************************");

        ResultSetMetaData resultSetMetaData= resultSet.getMetaData();

        System.out.println("resultSetMetaData.getColumnName(2) = " + resultSetMetaData.getColumnName(2));
        System.out.println(resultSetMetaData.getColumnCount());
        System.out.println("resultSetMetaData.getColumnTypeName() = " + resultSetMetaData.getColumnTypeName(2));
        System.out.println("resultSetMetaData.isNullable(5) = " + resultSetMetaData.isNullable(1));
        System.out.println("resultSetMetaData.isNullable(5) = " + resultSetMetaData.isReadOnly(1));
        System.out.println("resultSetMetaData.isAutoIncrement(1) = " + resultSetMetaData.isAutoIncrement(1));

        System.out.println("*******************************************");
        DatabaseMetaData databaseMetaData= connection.getMetaData();
        System.out.println("databaseMetaData.getDriverVersion() = " + databaseMetaData.getDriverVersion());
        System.out.println("databaseMetaData.supportsColumnAliasing() = " + databaseMetaData.supportsColumnAliasing());


        resultSet.close();
        statement.close();
        connection.close();





    }
}
