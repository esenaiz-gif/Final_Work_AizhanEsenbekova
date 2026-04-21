# 🌍 Tourist Destination Catalog (Kyrgyzstan)

## 👤 Student Information
- Name: Aizhan Esenbekova  
- Group: COMFCI-24  

---

# 📖 Project Description
The Tourist Destination Catalog is a Java-based application designed to manage and explore tourist destinations in Kyrgyzstan.  
It allows users to store, view, update, and delete information about attractions, activities, and accommodations.

The system uses **Object-Oriented Programming principles**, a **MySQL database for data persistence**, and both **Command Line Interface (CLI)** and **Graphical User Interface (GUI)** using Java Swing.

---

# 🎯 Objectives
The main objectives of this project are:
- To create a functional tourism management system
- To implement CRUD operations using Java and MySQL
- To apply Object-Oriented Programming principles (Encapsulation, Inheritance, Polymorphism)
- To design both CLI and GUI interfaces
- To ensure data persistence using a relational database
- To validate user input and handle errors properly
- To organize code into reusable and modular components

---

# 📌 Project Requirement List
The system includes the following key requirements:

1. Add new tourist destinations (Create)
2. Display all destinations (Read)
3. Update existing destination records
4. Delete destination records
5. Command Line Interface (CLI) menu system
6. Graphical User Interface (GUI using Java Swing)
7. MySQL database integration (JDBC)
8. Input validation for user entries
9. Error handling using try-catch blocks
10. Modular design using multiple classes
11. Use of inheritance between destination types
12. Demonstration of polymorphism via overridden methods
13. Encapsulation using private fields and getters/setters
14. Data persistence between sessions

---

# 🧠 Documentation

## 📌 Algorithms Used
- CRUD algorithm for database operations
- Conditional logic for object type selection (polymorphism handling)
- Looping structures for menu navigation and data display

## 📌 Data Structures
- ArrayList (used in GUI or internal handling if applicable)
- MySQL relational tables for persistent storage
- Object-oriented class structure for destinations

## 📌 Functions / Modules
- `DatabaseManager` → handles database connection
- `DatabaseService` → contains CRUD operations
- `InputValidator` → handles input validation
- `Destination` (parent class)
- `Attraction`, `Activity`, `Accommodation` (child classes)
- `GUI` → graphical interface
- `Main` → CLI entry point

## 📌 Challenges Faced
- Preventing duplicate data display in GUI table
- Handling type conversion between database and Java objects
- Ensuring polymorphism works with database-loaded objects
- Maintaining input validation consistency across CLI and GUI

---

# 🧪 Test Cases and Expected Outputs

## ✔ Test Case 1: Add Destination
**Input:**
- Name: Issyk-Kul
- Type: Attraction
- Location: Kyrgyzstan

**Expected Output:**
- “Destination added successfully”
- Record appears in database and GUI table

---

## ✔ Test Case 2: View Destinations
**Input:** Click “View”

**Expected Output:**
- List of all stored destinations displayed in CLI or GUI table

---

## ✔ Test Case 3: Update Destination
**Input:**
- Old Name: Issyk-Kul
- New Name: Issyk-Kul Lake

**Expected Output:**
- Record updated successfully in database

---

## ✔ Test Case 4: Delete Destination
**Input:**
- Name: Issyk-Kul Lake

**Expected Output:**
- Record removed from database and GUI updates

---

## 📸 Screenshots
Screenshots are attached showing:
- CLI menu execution
- GUI interface with data table
- MySQL database content
- CRUD operations in action

(All screenshots include system date and time as required.)

---

# 💻 Code Quality
- Code is fully functional and tested
- Clean structure following OOP principles
- Minimal comments used (only where necessary)
- Proper separation of classes and responsibilities

---

# 📁 Files Used in Project

- `Main.java` → CLI entry point  
- `GUI.java` → graphical interface  
- `DatabaseManager.java` → DB connection  
- `DatabaseService.java` → CRUD operations  
- `InputValidator.java` → validation logic  
- `Destination.java` → parent class  
- `Attraction.java`, `Activity.java`, `Accommodation.java` → child classes  
- MySQL database → stores persistent data  

---

# 🚀 Conclusion
This project demonstrates a complete tourism management system using Java, MySQL, and OOP principles.  
It supports full CRUD operations, input validation, GUI and CLI interfaces, and ensures data persistence.

The system can be further improved by adding authentication, search filters, and export functionality.
