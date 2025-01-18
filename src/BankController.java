public class BankController {

    public static String fullname;
    public static int phone;
    public static String email;
    public static int age;
    public static String residence;
    public static double balance = 0.0;
    public static String password;
    public static int account;

    public BankController() {
    }



    public static String getFullname() {
        return fullname;
    }

    public static void setFullname(String fullname) {
        BankController.fullname = fullname;
    }

    public static int getPhone() {
        return phone;
    }

    public static void setPhone(int phone) {
        BankController.phone = phone;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        BankController.email = email;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        BankController.age = age;
    }

    public static String getResidence() {
        return residence;
    }

    public static void setResidence(String residence) {
        BankController.residence = residence;
    }

    public static double getBalance() {
        return balance;
    }

    public static void setBalance(double balance) {
        BankController.balance = balance;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        BankController.password = password;
    }

    public static int getAccount() {
        return account;
    }

    public static void setAccount(int account) {
        BankController.account = account;
    }
}
