package main.java.com.javaextracttocsvorparquet.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javadataframe.models.Cars;

public class CarManager {



    public static ArrayList<Cars> getCarList() {
    ArrayList<Cars> carList = new ArrayList<>();
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "postgres";

    String query = "SELECT buying, maint, doors, persons, lug_boot, safety FROM cars";

    try {
        Class.forName("org.postgresql.Driver"); // Load the PostgreSQL JDBC driver

        try (Connection conn = DriverManager.getConnection(url, user, password);
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String buying = rs.getString("buying");
                String maint = rs.getString("maint");
                String doors = rs.getString("doors");
                String persons = rs.getString("persons");
                String lug_boot = rs.getString("lug_boot");
                String safety = rs.getString("safety");
                carList.add(new Cars(buying, maint, doors, persons, lug_boot, safety));
            }
        }
    } catch (ClassNotFoundException e) {
        System.out.println("PostgreSQL JDBC Driver not found.");
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return carList;
    
    }
}
