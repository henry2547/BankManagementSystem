import java.sql.*;

public class DBUtils {
    private String loggedInAccount = null; // Keeps track of the logged-in account

    public void signUpUser(String fullname, String email, String residence, int phone,
                           int age, int account, double balance, String password) {

        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello_fx", "root", "");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM user WHERE email = ?");
            psCheckUserExists.setString(1, email);
            resultSet = psCheckUserExists.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("\n\t\tEmail already taken.");
            } else {
                psInsert = connection.prepareStatement("INSERT INTO user (fullname, email, residence, phone, age, account, balance, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                psInsert.setString(1, fullname);
                psInsert.setString(2, email);
                psInsert.setString(3, residence);
                psInsert.setInt(4, phone);
                psInsert.setInt(5, age);
                psInsert.setInt(6, account);
                psInsert.setDouble(7, balance);
                psInsert.setString(8, password);
                psInsert.executeUpdate();

                System.out.println("\n\t\tAccount created successfully!\n");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            closeResources(resultSet, psCheckUserExists, psInsert, connection);
        }
    }

    public void logInUser(String account, String password) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello_fx", "root", "");
            preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE account = ? AND password = ?");
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("\n\t\tUser not found in the database!");
            } else {
                resultSet.next();
                loggedInAccount = account; // Set the logged-in account
                System.out.println("\n\n\t\tLogin successful! Welcome " + resultSet.getString("fullname") + "\n");

                //retrieve all the details from the database and store them to variables
                String retrievedEmail = resultSet.getString("email");
                String retrievedFullname = resultSet.getString("fullname");
                int retrievedPhone = resultSet.getInt("phone");
                String retrievedResidence = resultSet.getString("residence");
                int retrievedAge = resultSet.getInt("age");
                int retrievedAccount = resultSet.getInt("account");
                double retrievedBalance = resultSet.getDouble("balance");


                //set the details to the BankController class
                BankController.setFullname(retrievedFullname);
                BankController.setEmail(retrievedEmail);
                BankController.setPhone(retrievedPhone);
                BankController.setAge(retrievedAge);
                BankController.setResidence(retrievedResidence);
                BankController.setAccount(retrievedAccount);
                BankController.setBalance(retrievedBalance);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(resultSet, null, preparedStatement, connection);
        }
    }

    public void depositAmount(double amount) {

        if (loggedInAccount == null) {
            System.out.println("\n\t\tPlease log in before performing a transaction.");
            return;
        }

        Connection connection = null;
        PreparedStatement psUpdateBalance = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello_fx", "root", "");
            psUpdateBalance = connection.prepareStatement("UPDATE user SET balance = balance + ? WHERE account = ?");
            psUpdateBalance.setDouble(1, amount);
            psUpdateBalance.setString(2, loggedInAccount);
            psUpdateBalance.executeUpdate();

            System.out.println("\n\t\tAmount deposited successfully!\n");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            closeResources(null,null, psUpdateBalance, connection);
        }
    }

    public void withdrawAmount(double amount) {

        if (loggedInAccount == null) {
            System.out.println("\n\t\tPlease log in before performing a transaction.");
            return;
        }

        Connection connection = null;
        PreparedStatement psCheckBalance = null;
        PreparedStatement psUpdateBalance = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello_fx", "root", "");
            psCheckBalance = connection.prepareStatement("SELECT balance FROM user WHERE account = ?");
            psCheckBalance.setString(1, loggedInAccount);
            resultSet = psCheckBalance.executeQuery();

            if (resultSet.next()) {
                double currentBalance = resultSet.getDouble("balance");

                if (currentBalance >= amount) {
                    psUpdateBalance = connection.prepareStatement("UPDATE user SET balance = balance - ? WHERE account = ?");
                    psUpdateBalance.setDouble(1, amount);
                    psUpdateBalance.setString(2, loggedInAccount);
                    psUpdateBalance.executeUpdate();

                    System.out.println("\n\t\tAmount withdrawn successfully!\n");
                }
                else {
                    System.out.println("\n\t\tInsufficient balance!\n");
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            closeResources(resultSet, psCheckBalance, psUpdateBalance, connection);
        }
    }

    private void closeResources(ResultSet rs, PreparedStatement ps1, PreparedStatement ps2, Connection conn) {

        try {
            if (rs != null) rs.close();
            if (ps1 != null) ps1.close();
            if (ps2 != null) ps2.close();
            if (conn != null) conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
