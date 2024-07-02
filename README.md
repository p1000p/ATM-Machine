# ATM Machine

### This Java program simulates basic ATM functionalities like account creation, management of multiple accounts(deposit, withdraw, change PIN), transaction history tracking, and account enumeration using console-based menus and data structures like ArrayList and HashMap.
### Packages Imported:
- java.util.ArrayList: For storing transaction history.
- java.util.HashMap: For storing account details.
- java.util.Map: For the map interface.
- java.util.Scanner: For user input.
### Classes and Functions:
- Account Class:
variables:
- balance: Stores the account balance.
- pin: Stores the account PIN.
- transactionHistory: Stores transactions.
Methods:
- verifyPin(): Checks if the entered PIN is correct.
- getBalance(): Returns the balance.
- deposit(): Adds money to the balance.
- withdraw(): Takes money from the balance.
- changePin(): Changes the PIN.
- printTransactionHistory(): Shows the transaction history.

  ATM Class:
Variables:
- accounts: Stores accounts.
 Methods:
- createAccount(): Creates a new account.
- getAccount(): Gets an account by number.
- displayAccountNumbers(): Shows all account numbers or a message if there are none.



### Main Program Flow:
1.Main Menu:
 - Options: Create account, enter account number, view all accounts, exit.
 - Input taken using Scanner.
2.Create Account:
- User inputs account number, balance, and PIN.
- Account is created and added to the map.

3.Enter Account Number:
- User inputs account number and PIN.
- If correct, displays sub-menu with options to check balance, deposit, withdraw, change PIN, view history, or exit.
4.View All Account Numbers:
- Shows all accounts or "No accounts" if none exist.
5.Exit:
- Ends the program.


### Java Functionalities Used
- Classes and Objects: Account and ATM classes.
- Encapsulation: Private variables with public methods.
- Collections: ArrayList for transactions, HashMap for accounts.
- Loops and Conditionals: For menu navigation and option handling.
- User Input: Scanner for reading inputs.
