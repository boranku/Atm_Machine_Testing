import java.util.ArrayList;

// BankDatabase.java
// Represents the bank account information database 

public class BankDatabase
{
    static ArrayList<Account> accounts = new ArrayList<Account>() ; // array of Accounts



    // no-argument BankDatabase constructor initializes accounts
    public BankDatabase()
    {
        //The original array has been changed into an arraylist, this makes it easier to add/delete from the database
        Account accounts1 = new Account("Customer1", 12345, 11111, 1000.0, 1200.0, 0);
        Account accounts2 = new Account("Customer2", 98765, 22222, 200.0, 200.0, 0);
        Account accounts3 = new Account("Customer3", 19234, 33333, 200.0, 200.0, 0);
        Account accounts4 = new Account("Manager1", 99999, 00000, 0, 0, 1);
        accounts.add(accounts1);
        accounts.add(accounts2);
        accounts.add(accounts3);
        accounts.add(accounts4);
    } // end no-argument BankDatabase constructor

    // retrieve Account object containing specified account number

    public int getAccountType(int accountNumber) {
        for (Account currentAccount : accounts) {
            if (currentAccount.getAccountNumber() == accountNumber) {
                if (currentAccount.getIsAdmin() == 1) {
                    System.out.println("User is admin.");
                    return 1;
                }
                else {
                    System.out.println("User is a customer.");
                    return 0;
                }
            }
        }
        System.out.println("Not a user.");
        return -1;
    }

    public int getAccountType_mutant1(int accountNumber) {
        for (Account currentAccount : accounts) {
            if (currentAccount.getAccountNumber() != accountNumber) { //*
                if (currentAccount.getIsAdmin() == 1) {
                    System.out.println("User is admin.");
                    return 1;
                }
                else {
                    System.out.println("User is a customer.");
                    return 0;
                }
            }
        }
        System.out.println("Not a user.");
        return -1;
    }

    public int getAccountType_mutant2(int accountNumber) {
        for (Account currentAccount : accounts) {
            if (currentAccount.getAccountNumber() == accountNumber) {
                if (currentAccount.getIsAdmin() != 1) { //*
                    System.out.println("User is admin.");
                    return 1;
                }
                else {
                    System.out.println("User is a customer.");
                    return 0;
                }
            }
        }
        System.out.println("Not a user.");
        return -1;
    }

    public int getAccountType_mutant3(int accountNumber) {
        for (Account currentAccount : accounts) {
            if (currentAccount.getAccountNumber() == accountNumber) {
                if (currentAccount.getIsAdmin() == 1) {
                    System.out.println("User is admin.");
                    return 3; //*
                }
                else {
                    System.out.println("User is a customer.");
                    return 0;
                }
            }
        }
        System.out.println("Not a user.");
        return -1;
    }

    public int getAccountType_mutant4(int accountNumber) {
        for (Account currentAccount : accounts) {
            if (currentAccount.getAccountNumber() == accountNumber) {
                if (currentAccount.getIsAdmin() == 1) {
                    System.out.println("User is admin.");
                    return 3;
                }
                else {
                    System.out.println("User is a customer.");
                    return 0;
                }
            }
        }
        System.out.println("Not a user.");
        return 0;
    }

    public Account getAccount(int accountNumber)
    {
        // loop through accounts searching for matching account number
        for (Account currentAccount : accounts)
        {
            // return current account if match found
            if (currentAccount.getAccountNumber() == accountNumber)
                return currentAccount;
        } // end for

        return null; // if no matching account was found, return null
    } // end method getAccount

    private Account getAccountWithPin(int PIN)
    {
        // loop through accounts searching for matching account number
        for (Account currentAccount : accounts)
        {
            // return current account if match found
            if (currentAccount.GetPin() == PIN)
                return currentAccount;
        } // end for

        return null; // if no matching account was found, return null
    } //

    // determine whether user-specified account number and PIN match
    // those of an account in the database
    public boolean authenticateUser(int userPIN)
    {
        // attempt to retrieve the account with the account number
        Account userAccount = getAccountWithPin(userPIN);

        // if account exists, return result of Account method validatePIN
        if (userAccount != null)
            return userAccount.validatePIN(userPIN);
        else
            return false; // account number not found, so return false
    } // end method authenticateUser

    // return available balance of Account with specified account number
    public double getAvailableBalance(int userAccountNumber)
    {
        return getAccount(userAccountNumber).getAvailableBalance();
    } // end method getAvailableBalance

    // return total balance of Account with specified account number
    public double getTotalBalance(int userAccountNumber)
    {
        return getAccount(userAccountNumber).getTotalBalance();
    } // end method getTotalBalance

    // credit an amount to Account with specified account number
    public void credit(int userAccountNumber, double amount)
    {
        getAccount(userAccountNumber).credit(amount);
    } // end method credit

    // debit an amount from Account with specified account number
    public void debit(int userAccountNumber, double amount)
    {
        getAccount(userAccountNumber).debit(amount);
    } // end method debit
    public int getIsAdmin(int userAccountNumber)
    {
        if(getAccount(userAccountNumber)==null){
            return -1;
        }
        else{
            return getAccount(userAccountNumber).isAdmin();
        }
    }

    public static Iterator createIterator() {
        return new AccountIterator(accounts);
    }

    public int getAccountNumberWithPin(int pin){
        for (Account currentAccount : accounts)
        {
            // return current account if match found
            if (currentAccount.GetPin() == pin)
                return currentAccount.getAccountNumber();
            else
                return 1;
        }
        return pin;

        // correct code
//      for (Account currentAccount : accounts)
//      {
//          if (currentAccount.GetPin() == pin) return currentAccount.getAccountNumber();
//      }
//      return -1;

    }


    public static void addUser(){
        String name = Screen.Inputfield1.getText();
        int accountNumber = Integer.parseInt( Screen.Inputfield2.getText() );
        int pin = Integer.parseInt( Screen.Inputfield4.getText() );
        int balance = Integer.parseInt( Screen.Inputfield3.getText() );

        Account newAccount = new Account(name, accountNumber, pin, balance, balance, 0);
        accounts.add(newAccount);

        Screen.Inputfield1.setText("");
        Screen.Inputfield2.setText("");
        Screen.Inputfield3.setText("");
        Screen.Inputfield4.setText("");
    }

    public static void deleteUser(int position) {
        if(position > accounts.size() || position < 0) throw new IllegalArgumentException("Invalid index!");
        else accounts.remove(position);

    }




} // end class BankDatabase



/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/