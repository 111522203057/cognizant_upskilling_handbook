import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDemo {

    private final String url = "jdbc:mysql://localhost:3306/your_database_name";
    private final String user = "your_username";
    private final String password = "your_password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void transferMoney(int fromAccountId, int toAccountId, double amount) {
        String debitSql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
        String creditSql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false); // start transaction

            try (PreparedStatement debitStmt = conn.prepareStatement(debitSql);
                 PreparedStatement creditStmt = conn.prepareStatement(creditSql)) {

                // Debit from sender
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccountId);
                int debitUpdated = debitStmt.executeUpdate();

                // Credit to receiver
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccountId);
                int creditUpdated = creditStmt.executeUpdate();

                if (debitUpdated == 1 && creditUpdated == 1) {
                    conn.commit();
                    System.out.println("Transfer successful.");
                } else {
                    conn.rollback();
                    System.out.println("Transfer failed, transaction rolled back.");
                }
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Exception occurred, transaction rolled back.");
                e.printStackTrace();
            } finally {
                conn.setAutoCommit(true); // restore default
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TransactionDemo demo = new TransactionDemo();
        demo.transferMoney(1, 2, 100.0);
    }
}
