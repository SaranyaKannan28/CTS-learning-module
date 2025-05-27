import java.sql.*;

public class AccountDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/student1";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "msec@123";

    // Establish connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // Transfer amount between accounts
    public void transferMoney(int fromAccId, int toAccId, double amount) {
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false); // Start transaction

            try (PreparedStatement debitStmt = conn.prepareStatement(debitSQL);
                 PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {

                // Debit from sender
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccId);
                int debitResult = debitStmt.executeUpdate();

                // Credit to receiver
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccId);
                int creditResult = creditStmt.executeUpdate();

                if (debitResult == 1 && creditResult == 1) {
                    conn.commit(); // Success
                    System.out.println("Transaction committed successfully.");
                } else {
                    conn.rollback(); // Fail
                    System.out.println("Transaction failed. Rolled back.");
                }

            } catch (SQLException e) {
                conn.rollback(); // Rollback on error
                System.out.println("Exception occurred, transaction rolled back.");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
