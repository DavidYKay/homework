package edu.mccc.ist239.piechart;
import java.sql.*;

public class DataModel {

    private int[] data = new int[5];

    public DataModel() {

        //Sample data
        //data = new int[] {
        //    100,
        //    50,
        //    10,
        //    25,
        //    80
        //};
        data = fetchDataFromDB();
    }

    private int[] fetchDataFromDB() {
        int[] result = new int[5];
        //open db connection
        Connection conn = null;

        try {
            String userName = "ist239";
            String password = "password";
            String url = "jdbc:mysql://localhost/ist239";
            Class.forName ("com.mysql.jdbc.Driver").newInstance ();
            conn = DriverManager.getConnection (url, userName, password);
            System.out.println ("Database connection established");

            //fetch that shit
            String query = 
                "SELECT deptId, count(*)"
                + " FROM Student"
                + " WHERE deptId IS NOT NULL"
                + " GROUP BY deptId";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int dept = resultSet.getInt(1);
                int count = resultSet.getInt(2);
                result[dept] = count;
            }
        }
        catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close ();
                    System.out.println ("Database connection terminated");
                }
                catch (Exception e) { /* ignore close errors */ }
            }
        }
        return result;
    }

    public int[] getData() {
        return data;
    }
}
