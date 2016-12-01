

import org.testng.annotations.Test;

import java.sql.DriverManager;

public class TestngTest extends BaseJdbcTest {

    @Test
    public void test1() {
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            System.out.println(stmt.executeUpdate("insert into spaceships values ('starone', 45, 15 )"));
            System.out.println(stmt.executeUpdate("insert into spaceships values ('stargalaxy', 55, 58 )"));
            System.out.println(stmt.executeUpdate("insert into spaceships values ('staruniverse', 177, 133 )"));

            readTable();

            System.out.println("-----------Cleaning up the table...");
            System.out.println(stmt.executeUpdate("delete from spaceships"));
            readTable();

//            STEP 6: Clean-up environment
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            System.out.println("Exception e");
        }
    }
    @Test
    public void test2() {
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            System.out.println(stmt.executeUpdate("insert into spaceships values ('starone', 45, 15 )"));
            System.out.println(stmt.executeUpdate("insert into spaceships values ('stargalaxy', 55, 58 )"));
            System.out.println(stmt.executeUpdate("insert into spaceships values ('staruniverse', 177, 133 )"));

            readTable();

            System.out.println("-----------Updating one record...");
            stmt.executeUpdate("update spaceships set speed=49, passengers=19 where model='starone'");
            readTable();

            System.out.println("-----------Cleaning up the table...");
            System.out.println(stmt.executeUpdate("delete from spaceships"));
            readTable();

//            STEP 6: Clean-up environment
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            System.out.println("Exception e");
        }
    }

}
