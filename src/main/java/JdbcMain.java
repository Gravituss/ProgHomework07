import java.sql.*;


public class JdbcMain {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/sakila";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "salamatos59K";


    public static void main(String[] args) {



            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                //STEP 2: Register JDBC driver
                Class.forName(JDBC_DRIVER);
                //STEP 3: Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();

                System.out.println(stmt.executeUpdate("delete from spaceships where speed > 0"));
                System.out.println(stmt.executeUpdate("insert into spaceships values ('starone', 45, 15 )"));
                System.out.println(stmt.executeUpdate("insert into spaceships values ('stargalaxy', 55, 58 )"));
                System.out.println(stmt.executeUpdate("insert into spaceships values ('staruniverse', 177, 133 )"));
                rs = stmt.executeQuery("SELECT * FROM spaceships");

//            System.out.println(stmt.executeUpdate("delete from cars where model='ZAZ'"));
                while (rs.next()) {
                    //Retrieve by index
                    String model = rs.getString("model");
                    int speed = rs.getInt("speed");
                    int passengers = rs.getInt("passengers");
                    System.out.println(model + " | " + speed + " | " + passengers + "|");
                }

//                PreparedStatement updateEXP = conn.prepareStatement("update`user` set `exp` = '666'  where `username` = '"+loggedusername+"'");
//                ResultSet updateEXP_done = updateEXP.executeUpdate();












                System.out.println("Cleaning up the database...");
                System.out.println(stmt.executeUpdate("delete from spaceships where speed > 0"));
                rs = stmt.executeQuery("SELECT * FROM spaceships");
//            STEP 6: Clean-up environment
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.out.println("Exception e");
            }

    }
}