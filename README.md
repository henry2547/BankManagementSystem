# Bank Management System (Console-Based)

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange)

## 📌 Overview

A console-based banking application that allows customers to manage their accounts through a simple text interface. Built with Java and MySQL for secure data storage and transaction processing.

## ✨ Features

- **Account Management**
  - Create new bank accounts
  - View account details and balance
  - Secure login system

- **Transaction Processing**
  - Deposit funds
  - Withdraw funds (with balance validation)
  - View transaction history

- **Admin Functions**
  - View all customer accounts
  - Generate system reports

## 🛠️ Technologies Used

- **Backend**: Java 17+
- **Database**: MySQL 8.0
- **Dependencies**: 
  - MySQL Connector/J
  - JUnit (for testing)

## 🚀 Getting Started

### Prerequisites
- Java JDK 17 or later
- MySQL Server 8.0
- MySQL Workbench (recommended)

### Installation
1. Clone the repository:
```bash
git clone https://github.com/henry2547/BankManagementSystem.git
```

2. Update database credentials in `DatabaseConnection.java`:
```java
String url = "jdbc:mysql://localhost:3306/bank_system";
String username = "your_username";
String password = "your_password";
```

3. Compile and run:
```bash
javac *.java
java Main
```

## 🏦 System Architecture

```
src/
├── Main.java                 # Entry point
├── BankSystem.java           # Core banking logic
├── DatabaseConnection.java   # MySQL connection handler
├── Account.java              # Account model
└── Transaction.java          # Transaction model
```

## 💻 Usage Examples

### Create Account
```
=== BANK MANAGEMENT SYSTEM ===
1. Create Account
2. Login
3. Exit
> 1

Enter your name: John Doe
Enter your email: john@example.com
Enter initial deposit: 1000
Create a 4-digit PIN: 1234

Account created successfully!
Account Number: ACC20230001
```

### Deposit Funds
```
=== ACCOUNT MENU ===
1. Check Balance
2. Deposit
3. Withdraw
4. View Transactions
5. Logout
> 2

Enter amount to deposit: 500
Deposit successful. New balance: $1500.00
```

### Withdraw Funds
```
=== ACCOUNT MENU ===
> 3

Enter amount to withdraw: 200
Withdrawal successful. New balance: $1300.00
```

## 🔒 Security Features

- PIN-protected account access
- Input validation for all transactions
- Database parameterized queries to prevent SQL injection

## 📈 Future Enhancements

- [ ] Add interest calculation
- [ ] Implement fund transfers between accounts
- [ ] Add password recovery system
- [ ] Develop GUI version

## 🤝 Contributing

Contributions welcome! Please fork the repository and submit pull requests.

## 📜 License

MIT License
