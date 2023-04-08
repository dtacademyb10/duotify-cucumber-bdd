package utils;

import org.junit.Assert;

import java.sql.*;
import java.util.List;

public class JDBCDemo {


    public static void main(String[] args) throws SQLException {


//        String url = "jdbc:mysql://apps-database.cb72canasobc.us-east-2.rds.amazonaws.com/employees";
//
//        Connection connection = DriverManager.getConnection(url, "duotech", "duotech2023");
//
//        System.out.println("Connection established");
//
//        Statement statement = connection.createStatement();
//
//        ResultSet resultSet = statement.executeQuery("select * from employees limit 10");
//
//         while(resultSet.next()){
//             System.out.println(resultSet.getString(1) +"\t" + resultSet.getString(2) +"\t" + resultSet.getString(3) +"\t" + resultSet.getString(3));
//         }


         // Util class demo

        DBUtils.createConnection();

        List<List<Object>> listOfLists = DBUtils.getListOfLists("select * from users where username='duotech2023'");

//        for (List<Object> row : listOfLists) {
//            System.out.println(row);
//        }

        String expectedEmail = "blabla2024@gmail.com";

        Assert.assertEquals(expectedEmail,listOfLists.get(0).get(4));

    }
}
