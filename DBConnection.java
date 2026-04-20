import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
    private static Connection c2;
    public static Connection getConnection() {
        if (c2 == null) {
            try {
                c2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/rh", "root", "");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return c2;
    }
}