import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database_name"; // Replace with your DB name
        String user = "your_username";  // Replace with your DB username
        String password = "your_password";  // Replace with your DB password

        try {
            // Load MySQL JDBC Driver (optional for newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // Create statement and execute query
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(query);

            // Process results
            while (rs.next()) {
                int id = rs.getInt("id"); // Assuming 'id' column
                String name = rs.getString("name"); // Assuming 'name' column
                int age = rs.getInt("age"); // Assuming 'age' column
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error:");
            e.printStackTrace();
        }
    }
}
