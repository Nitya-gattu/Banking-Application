# Java Banking Application

A Java console application that simulates basic banking operations, designed to illustrate object-oriented programming concepts in Java such as classes, objects, constructors, methods, and data encapsulation.

## Features

- **Account Creation and Management**: Create and update bank accounts with unique identifiers, names, and initial balances.
- **Balance Inquiry**: View detailed account information, including account numbers, holder names, and current balances.
- **Deposits and Withdrawals**: Perform deposit and withdrawal transactions with checks to prevent overdrawing.
- **Account Search**: Locate accounts using their account numbers for quick access.

## Classes

### Bank

- **Attributes**: Holds details such as `accno` (account number), `name` (account holder's name), and `balance`.
- **Methods**:
  - `openAccount()`: Opens a new or updates an existing account.
  - `showAccount()`: Displays detailed account information.
  - `deposit()`: Increases account balance by a specified amount.
  - `withdrawal()`: Decreases account balance by a specified amount, ensuring sufficient funds are available.
  - `search()`: Finds an account by its number and returns the corresponding `Bank` object.

### ExBank

- Hosts the `main` method to initiate the application, showcasing a user interface for account management and executing user commands.

## Usage

1. **Run the Application**: Start by executing the `ExBank` class.
2. **Menu Navigation**: Interact with the console menu to manage accounts:
   - `1. Display`: Lists all accounts.
   - `2. Search By Account`: Finds an account by number.
   - `3. Deposit`: Adds funds to an account.
   - `4. Withdrawal`: Removes funds from an account.
   - `5. Exit`: Ends the session.
3. **Input Prompts**: The application will request necessary information based on your chosen action.

## Contributing

Contributions are welcome to enhance functionality or improve the codebase. Feel free to fork the repository, make changes, and submit a pull request.

## License

This project is licensed under the MIT License.
