## Inheritance and Polymorphism

### Objective

The objective of this module is to gain hands-on experience with the following topics:

1. Overview of Inheritance
2. Working with Inheritance
3. Introduction to Polymorphism
4. Method Overloading and Method Overriding

---

## Problem Statement 1: Understanding and Implementing Inheritance

### Objectives

1. Understand and Implement Inheritance in Java.
2. Invoking superclass argument constructors.

### Problem Statement

Create subclasses of the `Employee` class and add the necessary properties and constructors by invoking the superclass constructors.

### Tasks

1. **Create Subclass `Developer`**:
   - Extend from `Employee` class with a property `noOfProjects`.
   - Create both no-arg and argument constructors, invoking the superclass constructors.

2. **Create Subclass `Designer`**:
   - Extend from `Employee` class with a property `noOfWebsites`.
   - Create both no-arg and argument constructors, invoking the superclass constructors.

---

## Problem Statement 2: Understanding and Implementing Method Overriding and Polymorphism

### Objectives

1. Understand and implement method overriding.
2. Implement runtime polymorphism.

### Problem Statement

Override `calculateNetSalary()` and `calculateNetSalaryAfterIncrement()` methods in the `Employee` class and in `Developer` and `Designer` classes respectively.

### Tasks

1. **Implement Methods in Employee Class**:
   - `float calculateNetSalary()`: Calculate the Net Salary after tax deduction.
     
    ```
     float calculateNetSalary() {
        return grossSalary - federalTax - stateTax;
     }  
    ```
   - `float calculateNetSalaryAfterIncrement()`: Calculate the incremented Net Salary after the increment.
     
    ```
     float calculateNetSalaryAfterIncrement() {
       float netSalary;
       netSalary = calculateNetSalary();
       netSalary += (netSalary * incrementPercentage / 100);
       return netSalary;
     } 
    ```


2. **Update displayProfile() Method in Employee Class**:
   - Display the Net Salary and Net Salary after the increment.

3. **Override Methods in Developer and Designer Classes**:
   - Override `calculateNetSalary()`, `calculateNetSalaryAfterIncrement()`, and `displayProfile()` methods with the appropriate logic.

4. **Create Payroll Class**:
   - Implement `float calculateNetSalary(Employee employee)` to return the `calculateNetSalary()` method of the `Employee` class.
   - Implement `float calculateNetSalaryAfterIncrement(Employee employee)` to return the `calculateNetSalaryAfterIncrement()` method of the `Employee` class.

5. **Main Class Implementation**:
   - Create two `Developer` objects with necessary values.
   - Create two `Designer` objects with necessary values.
   - Create a `Payroll` object and invoke `calculateNetSalary()` and `calculateNetSalaryAfterIncrement()` methods for `Developer` and `Designer` objects.
   - Include SOP messages inside `Developer` and `Designer` class methods to observe which methods are invoked.

## Problem Statement 3: Understanding and Creating Overloaded Methods

### Objectives

1. Understand and create overloaded methods.

### Problem Statement

Create overloaded methods for the `displayProfile()` method of the `Payroll` class with different input parameters.

### Tasks

1. **Create Overloaded Methods in Payroll Class**:
   - `void displayProfile(int empId)`: Implement with an SOP statement to indicate method invocation.
   - `void displayProfile(float fromSalaryRange, float toSalaryRange)`: Implement with an SOP statement to indicate method invocation.
   - `void displayProfile(String department)`: Implement with an SOP statement to indicate method invocation.

---

This README provides an overview of the exercises focusing on inheritance, polymorphism, and method overloading/overriding in Java. Follow the tasks to implement the required functionality and observe the expected outputs.
