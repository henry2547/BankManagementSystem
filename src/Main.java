import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("\t\t-----------------------------");
            System.out.println("\t\t\t1. Create account");
            System.out.println("\t\t\t2. Deposit amount");
            System.out.println("\t\t\t3. Withdraw amount");
            System.out.println("\t\t\t4. My account info");
            System.out.println("\t\t\t5. Exit program");
            System.out.println("\t\t------------------------------");

            System.out.print("\t\tSelect option to continue: ");

            char option = scan.next().charAt(0);

            switch(option) {
                case '1':
                    Account();
                    break;
                case '2':
                    Deposit();
                    break;
                case '3':
                    Withdraw();
                    break;
                case '4':
                    Info();
                    break;
                case '5':
                    System.out.println("\n\t\t<--------Thank you for using our System--------->\n");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\n\t\tInvalid option entered\n");


            }


        }

    }

    private static void Info() {

        //get the account number in order to show the details
        Scanner scan = new Scanner(System.in);

        System.out.print("\t\tEnter your account number to continue: ");
        String account = scan.nextLine();

        System.out.print("\t\tEnter your password to continue: ");
        String password = scan.nextLine();

        DBUtils utils = new DBUtils();
        utils.logInUser(account, password);


        //get the details from the Bank controller class
        System.out.println("\n\t\t-------------------------------");
        System.out.println("\t\tFull name: " + BankController.getFullname());
        System.out.println("\t\tEmail address: " + BankController.getEmail());
        System.out.println("\t\tPhone number: " + BankController.getPhone());
        System.out.println("\t\tResidence: " + BankController.getResidence());
        System.out.println("\t\tAge: " + BankController.getAge());
        System.out.println("\t\tAccount number: " + BankController.getAccount());
        System.out.println("\t\tBalance: " + BankController.getBalance());
        System.out.println("\t\t-------------------------------");




    }

    private static void Withdraw() {

        //get the account number in order to show the details
        Scanner scan = new Scanner(System.in);

        System.out.print("\t\tEnter your account number to continue: ");
        String account = scan.nextLine();

        System.out.print("\t\tEnter your password to continue: ");
        String password = scan.nextLine();

        DBUtils utils = new DBUtils();
        utils.logInUser(account, password);

        System.out.print("\t\tEnter amount to withdraw: ");
        double amount = scan.nextDouble();

        utils.withdrawAmount(amount);

    }

    private static void Deposit() {

        //get the account number in order to show the details
        Scanner scan = new Scanner(System.in);

        System.out.print("\t\tEnter your account number to continue: ");
        String account = scan.nextLine();

        System.out.print("\t\tEnter your password to continue: ");
        String password = scan.nextLine();

        DBUtils utils = new DBUtils();
        utils.logInUser(account, password);


        System.out.print("\t\tEnter amount to deposit: ");
        double amount = scan.nextDouble();

        utils.depositAmount(amount);



    }

    private static void Account() {
        //when the user create the account, the amount is set to 0.00
        Scanner scan = new Scanner(System.in);


        System.out.print("\t\tEnter your fullname: ");
        String fullname = scan.nextLine();

        System.out.print("\t\tEnter your residence: ");
        String residence = scan.nextLine();

        System.out.print("\t\tEnter your email: ");
        String email = scan.nextLine();

        System.out.print("\t\tEnter your password: ");
        String password = scan.nextLine();

        System.out.print("\t\tEnter your phone number: ");
        int phone = scan.nextInt();

        System.out.print("\t\tEnter your age: ");
        int age = scan.nextInt();



        //validate the password first before setting the values to the
        //Bank contoller class

        if(password.length() < 5) {
            System.out.println("\nPassword must be greater than 5 Characters\n");
        }

        else {

            //save the data to the DBUtils class
            //set the balance to 0.00

            double balance = 0.0;

           Random rand = new Random();
           int account = rand.nextInt();


            System.out.println("\n\t\tYour account number is: " + account);

           DBUtils dbUtils = new DBUtils();

           dbUtils.signUpUser(fullname, email, residence, phone, age, account, balance, password);




        }






    }

}
