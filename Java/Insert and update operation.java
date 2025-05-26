import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    private final String url = "jdbc:mysql://localhost:3306/your_database_name"; // replace with DB name
    private final String user = "your_username";  // replace with DB user
    private final String password = "your_password";  // replace with DB password

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void insertStudent(int id, String name, int age) {
        String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            
            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + " student(s) inserted.");
        } catch (SQLException e) {
            System.out.println("Insert error:");
            e.printStackTrace();
        }
    }

    public void updateStudentAge(int id, int newAge) {
        String sql = "UPDATE students SET age = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, newAge);
            pstmt.setInt(2, id);
            
            int rowsUpdated = pstmt.executeUpdate();
            System.out.println(rowsUpdated + " student(s) updated.");
        } catch (SQLException e) {
            System.out.println("Update error:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        dao.insertStudent(1, "Alice", 20);
        dao.updateStudentAge(1, 21);
    }
}
