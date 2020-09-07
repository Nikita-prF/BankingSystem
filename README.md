# Simple Banking System

The program implementing a simple banking system of creating and managing unique user credit cards with store user data in [SQLite database](https://en.wikipedia.org/wiki/SQLite)

## Allowed manage function

* Creating a correct card with a special ["Luhn" algorithm](https://en.wikipedia.org/wiki/Luhn_algorithm).
* Login to your private account by pin and card number.
* Adding cash.
* Transferring of cash to another credit card.
* Deleting card from database.

## How to run


*To launch the program you should have installed [JRE](https://java.com/ru/download/) on your computer. Please install it if there are no exists.*

1. Clone repository to your machine
2. Open the root folder of the project
3. Run the following command.

``` 
$ java -jar jar/BankingSystem.jar -fileName database.db 
```

Where:

* <b>'-fileName'</b> - Obligatory option for the program to get a database file or to create him. ( <b>Don't change it </b>)
* <b>'base.db'</b> - The path to the database file and his name or the place of its creation. ( *If you set the file name only, the program creates a database in the root directory of the project.*)
  
<b> Be careful. The database file format must be ".md". </b>

## Build with

* [JDBC SQlite Driver](https://www.sqlite.org/java/raw/doc/overview.html?name=0a704f4b7294a3d63e6ea2b612daa3b997c4b5f1) - A basic JDBC driver for the SQLite database engine.

## Authors

[Nikita-prF](https://github.com/Nikita-prF)