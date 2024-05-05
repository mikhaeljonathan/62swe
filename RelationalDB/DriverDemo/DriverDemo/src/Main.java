import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/BelajarDBMS";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","1q2w3e4r");

        try {
            Connection conn = DriverManager.getConnection(url, props);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Author";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Hello world!");
    }
}