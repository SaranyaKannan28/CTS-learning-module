public class Main {
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();

        // Transfer 200 from Alice (1) to Bob (2)
        dao.transferMoney(1, 2, 200.00);
    }
}