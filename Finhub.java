import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Bank {
    private String accno;
    private String name;
    private long balance;

    // Constructor to initialize a new Bank object
    public Bank(String acc, String n, long bal) {
        accno = acc;
        name = n;
        balance = bal;
    }

    // Method to open or update an account
    public static Bank openAccount(Scanner KB) {
        System.out.print("Enter Account No: ");
        String accno = KB.next();
        System.out.print("Enter Name: ");
        String name = KB.next();
        System.out.print("Enter Balance: ");
        long balance = KB.nextLong();
        return new Bank(accno, name, balance); // Return the new account
    }

    // Method to display account details
    void showAccount() {
        //System.out.println(accno + "," + name + "," + balance);
        
    System.out.println("Account No: " + accno + ", Name: " + name + ", Balance: " + balance );
}
    

    // Method to deposit money
    void deposit(long amt) {
        balance += amt;
    }

    // Method to withdraw money
    boolean withdrawal(long amt) {
        if (balance >= amt) {
            balance -= amt;
            return true;
        } else {
            System.out.println("Less Balance..Transaction Failed..");
            return false;
        }
    }

    // Method to search an account number
    static Bank search(String acn, List<Bank> accounts) {
        for (Bank account : accounts) {
            if (account.accno.equals(acn)) {
                return account;
            }
        }
        return null; // Return null if account not found
    }
}

class ExBank {
    public static void main(String[] args) {
        Scanner KB = new Scanner(System.in);
        List<Bank> accounts = new ArrayList<>();

        // Main loop
        int ch;
        do {
            System.out.println("Main Menu\n1.Display\n2.Search By Account\n3.Deposit\n4.Withdrawal\n5.Exit");
            System.out.print("Ur Choice: ");
            ch = KB.nextInt();

            switch (ch) {
                case 1: // Display all accounts
                    for (Bank account : accounts) {
                        account.showAccount();
                    }
                    break;

                case 2: // Search by account number
                    System.out.print("Enter Account No U Want to Search...: ");
                    String acn = KB.next();
                    Bank foundAccount = Bank.search(acn, accounts);
                    if (foundAccount != null) {
                        foundAccount.showAccount();
                    } else {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;

                case 3: // Deposit
                    System.out.print("Enter Account No: ");
                    acn = KB.next(); // Use existing 'acn' variable
                    Bank account = Bank.search(acn, accounts);
                    if (account == null) {
                        System.out.println("Account does not exist. Creating new account.");
                        account = Bank.openAccount(KB);
                        accounts.add(account); // Add the new account to the list
                    }
                    System.out.print("Enter Amount U Want to Deposit: ");
                    long amt = KB.nextLong(); // Use existing 'amt' variable
                    account.deposit(amt);
                    System.out.println("Amount deposited successfully.");
                    break;

                case 4: // Withdrawal
                    System.out.print("Enter Account No: ");
                    acn = KB.next(); // Use existing 'acn' variable
                    foundAccount = Bank.search(acn, accounts);
                    if (foundAccount != null) {
                        System.out.print("Enter Amount U Want to Withdraw: ");
                        amt = KB.nextLong(); // Use existing 'amt' variable
                        if (!foundAccount.withdrawal(amt)) {
                            System.out.println("Transaction Failed.");
                        }
                    } else {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;

                case 5: // Exit
                    System.out.println("Good Bye..");
                    break;
            }
        } while (ch != 5);
    }
}
