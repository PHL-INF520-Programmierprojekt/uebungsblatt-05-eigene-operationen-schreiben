# Exercise Sheet: Writing own operations in given Java classes
[Link to German Version](./README.md)


In this exercise sheet, you will learn to extend given Java programms by writing own operations.


## Exercise: Operation Rectangle

In this exercise, we will be working with an existing Java class and add new operations to it. The class we will be working with is a `Rectangle` class that represents a rectangle with length and width.

### Background Information

The `Rectangle` class has the following attributes:

- `length`: the length of the rectangle (type: double)
- `width`: the width of the rectangle (type: double)

The `Rectangle` class has the following operations:

- `getLength()`: returns the length of the rectangle
- `getWidth()`: returns the width of the rectangle
- `setLength(final double length)`: sets the length of the rectangle to the specified value
- `setWidth(final double width)`: sets the width of the rectangle to the specified value
- `getArea()`: returns the area of the rectangle (i.e., $length * width$)

### Tasks

1. Create a new operation in the `Rectangle` class called `getPerimeter()` that returns the perimeter of the rectangle (i.e., $2 * (length + width)$).
2. Modify the `Rectangle` class to include a constructor that takes in the length and width of the rectangle as parameters. Pay attention to defensive programming.
   * Make sure that you can still create a rectangle without specifying the length and width, i.e., the default constructor should still be available.
3. Create a new operation in the `Rectangle` class called `getDiagonal()` that returns the diagonal length of the rectangle (i.e., $\sqrt{length^2 + width^2}$).
4. Create a new operation in the `Rectangle` class called `isSquare()` that returns a boolean value indicating whether the rectangle is a square (i.e., if `length == width`).
5. Create a new operation in the `Rectangle` class called `scale(final double scaleFactor)` that scales the rectangle by the given factor. This operation should multiply the length and width by the scale factor. Pay attention to defensive programming.
   * Note: You may need to import the `java.lang.Math` package to use the `sqrt()` operation.

Note: You may need to import the `java.lang.Math` package to use the `sqrt()` operation.

After completing the above tasks, create an instance of the `Rectangle` class in your `main()` operation and test out the various operations you have created. Additionally, create a few more instances of `Rectangle` and test out the new `isSquare()` and `scale()` operations.


## Exercise: Banking 101

In this exercise, we will be working with an existing Java class and add new operations to it. The class we will be working with is the `BankAccount` class that represents a bank account with balance and account number.

### Background Information

The `BankAccount` class has the following attributes:

- `balance`: the balance of the bank account (type: double)
- `accountNumber`: the account number of the bank account (type: int)

The `BankAccount` class has the following operations:

- `getBalance()`: returns the balance of the bank account
- `getAccountNumber()`: returns the account number of the bank account
- `deposit(final double amount)`: adds the specified amount to the balance of the bank account
- `withdraw(final double amount)`: subtracts the specified amount from the balance of the bank account
- `toString()`: returns a string representation of the bank account in the format "Account Number: {account number}, Balance: ${balance}"

### Tasks


1. Create a new operation in the `BankAccount` class called `transferTo(final BankAccount otherAccount, final double amount)` that transfers the specified amount from the current bank account to the other bank account. For example, if the current bank account has a balance of \$100 and the other bank account has a balance of \$50, and the transfer amount is \$25, the new balances should be \$75 for the current bank account and \$75 for the other bank account. Pay attention to defensive programming.
2. Create a new operation in the `BankAccount` class called `addInterest(final double rate)` that adds interest to the bank account based on the specified interest rate. For example, if the current balance is \$100 and the interest rate is 5%, the new balance should be \$105. Pay attention to defensive programming.
3. Create a new operation in the `BankAccount` class called `getNetBalance()` that returns the balance of the bank account after subtracting any negative balances due to overdrafts. For example, if the balance of the bank account is -50, the `getNetBalance()` operation should return 0.
   Change the implementation of `BankAccount` so that `balance` can be negative.


After completing the above tasks, create an instance of the `BankAccount` class in your `main()` operation and test out the various operations you have created.

## Exercise: A Restaurant's Tale

In this exercise, we will be working with a Java program that simulates a restaurant. The program includes a `Restaurant` class, a `Table` class, a `MenuItem` class, and an `Order` class.

### Background Information

The `Restaurant` class has the following attributes:

- `tables`: a list of `Table` objects representing the tables in the restaurant
- `menuItems`: a list of `MenuItem` objects representing the items on the restaurant's menu

The `Restaurant` class has the following operations:

- `getTables()`: returns the `tables` list
- `getMenuItems()`: returns the `menuItems` list
- `findTable(final int tableNumber)`: returns the `Table` object with the specified table number, or `null` if no such table exists
- `findMenuItem(final String itemName)`: returns the `MenuItem` object with the specified item name, or `null` if no such item exists

The `Table` class has the following attributes:

- `tableNumber`: an integer representing the table number
- `seats`: an integer representing the number of seats at the table
- `occupied`: a boolean representing whether the table is currently occupied
- `orders`: a list of all orderes that have been placed at the table

The `Table` class has the following operations:

- `getTableNumber()`: returns the `tableNumber`
- `getSeats()`: returns the `seats`
- `isOccupied()`: returns the `occupied` value
- `setOccupied(final boolean isOccupied)`: sets the `occupied` attribute to the specified value
- `getOrders()`: returns the `orders`
- `placeOrder(final MenuItem menuItem, final int amount)`: creates an order which orders the menu item amount of times

The `MenuItem` class has the following attributes:

- `itemName`: a string representing the name of the menu item
- `description`: a string representing a description of the menu item
- `price`: a double representing the price of the menu item

The `MenuItem` class has the following operations:

- `getItemName()`: returns the `itemName`
- `getDescription()`: returns the `description`
- `getPrice()`: returns the `price`

The `Order` class has the following attributes:

- `menuItem`: the menu item which is ordered
- `amount`: how often the menu item is ordered

The `Order` class has the following operations:

- `getMenuItem`: return the `menuItem`
- `getAmount`: return the `amount`

### Tasks

1. Add a new operation to the `Restaurant` class called `findUnoccupiedTable(final int partySize)` that finds an unoccupied table with enough seats for the specified party size, or `null` if no such table exists.
2. Add a new operation to the `Restaurant` class called `getTotalRevenue()` that returns the total revenue earned by the restaurant from all orders.
3. Add a new operation to the `Restaurant` class called `getTableOccupancyPercentage()` that returns the percentage (as double, `[0,1]`) of tables that are currently occupied.
4. Add a new operation to the `Restaurant` class called `getSeatsOccupancyPercentage()` that returns the percentage (as double, `[0,1]`) of seats that are currently occupied. You can assume that if a table is occupied, all its seats are occupied.
5. Add a new operation to the `MenuItem` class called `isVegetarian()` that returns `true` if the menu item is vegetarian (i.e., if its description includes the word "vegetarian") and `false` otherwise.

After completing the above tasks, create instances of the classes in your `main()` operation and test out the various operations you have created.

Note: You should not need to create any new classes for this exercise. Instead, you will be adding new operations to the existing classes.