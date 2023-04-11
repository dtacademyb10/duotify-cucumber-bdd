package utils;

import org.junit.Assert;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class JDBCDemo {


    public static void main(String[] args) throws SQLException {

//
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


//          Util class demo
//
        // Establish connection to the DB
        DBUtils.createConnection();

        List<List<Object>> listOfLists = DBUtils.getListOfLists("select * from users where username='duotech2001'");

        System.out.println(listOfLists);

        System.out.println( listOfLists.get(0).get(4));

        List<Map<String, Object>> listOfMaps = DBUtils.getListOfMaps("select * from users where username='duotech2001'");


        System.out.println(listOfMaps);

        System.out.println(listOfMaps.get(0).get("email"));

        List<String> columnNames = DBUtils.getColumnNames("select * from users where username='duotech2001'");

        System.out.println(columnNames);



        // UPDATE
        DBUtils.executeUpdate("update users set email='myEmail@gmail.com', firstName='JDBC' where username='duotech2001'");

        //CREATE
        DBUtils.executeUpdate("insert into users (username, firstName, lastName, email, password) values ('byeworld', 'Bye', 'World', 'bw@gmail.com', 'ca8193792644b5bd78269c737fb442c1')");

        // DELETE
        DBUtils.executeUpdate("DELETE FROM users WHERE username='byeworld'");


    }
}
