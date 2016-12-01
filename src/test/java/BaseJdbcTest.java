import org.testng.annotations.BeforeMethod;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseJdbcTest {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/sakila";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "salamatos59K";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;


    public void readTable(){

        try {
            rs = stmt.executeQuery("SELECT * FROM spaceships");
            while (rs.next()) {
                //Retrieve by index
                String model = rs.getString("model");
                int speed = rs.getInt("speed");
                int passengers = rs.getInt("passengers");
                System.out.println(model + " | " + speed + " | " + passengers + " |");
            }
        } catch (Exception e){
            System.out.println("Exception in the readTable() method");
        }
    }

    @BeforeMethod
    public void preConfig () {

    }

}
