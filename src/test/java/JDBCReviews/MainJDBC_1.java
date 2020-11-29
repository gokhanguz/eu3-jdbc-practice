package JDBCReviews;

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

        while(resultSet.next()){

            System.out.println(resultSet.getString(5));
        }

        resultSet.beforeFirst();
        while(resultSet.next()){

            System.out.println(resultSet.getString(2));
        }

        resultSet.beforeFirst();
        resultSet.next();
        System.out.println(resultSet.relative(-2));

        resultSet.close();
        statement.close();
        connection.close();
        resultSet.absolute(5);



    }
}
