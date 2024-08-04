package com.trainingmug.employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class DeveloperTest {

    @Test
    @Order(1)
    @DisplayName("Test Developer class should be present in com.trainingmug.employee.app package")
    void testDeveloperClassShouldBePresent() {
        assertDoesNotThrow(() -> {
            Class.forName("com.trainingmug.employee.Developer");
        }, "Developer class should be present");
    }

    @Test
    @Order(2)
    @DisplayName("Check if Developer Class Extends Employee Class")
    public void testDeveloperClassInheritance() {
        try {
            Class<?> developerClass = Class.forName("com.trainingmug.employee.Developer");

            Class<?> employeeClass = Class.forName("com.trainingmug.employee.Employee");

            assertTrue(employeeClass.isAssignableFrom(developerClass),
                    "Developer class should extend Employee class");

        } catch (ClassNotFoundException e) {
            fail("Developer or Employee class not found: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Check if Developer Class Contains noOfProjects Field")
    public void testNoOfProjectsField() {
        try {
            Class<?> developerClass = Class.forName("com.trainingmug.employee.Developer");

            Field noOfProjectsField = developerClass.getDeclaredField("noOfProjects");

            assertEquals(int.class, noOfProjectsField.getType(),
                    "Field noOfProjects should be of type int");

        } catch (ClassNotFoundException e) {
            fail("Developer class not found: " + e.getMessage());
        } catch (NoSuchFieldException e) {
            fail("Field noOfProjects not found in Developer class: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @DisplayName("Test Developer Constructor Presence and Super Constructor Invocation")
    public void testDeveloperConstructor() {
        try {
            Class<?> developerClass = Class.forName("com.trainingmug.employee.Developer");

            Constructor<?> constructor = developerClass.getConstructor(
                    long.class, String.class, String.class, float.class, float.class,
                    float.class, float.class, float.class, int.class
            );

            assertNotNull(constructor, "Constructor should be present in Developer class");

            Developer developer = (Developer) constructor.newInstance(
                    1234L, "Jane Doe", "Senior Developer", 5000.0f, 300.0f,
                    150.0f, 100.0f, 10.0f, 5
            );

            assertEquals(1234L, developer.empId, "Employee ID should be set correctly");
            assertEquals("Jane Doe", developer.name, "Name should be set correctly");
            assertEquals("Senior Developer", developer.designation, "Designation should be set correctly");
            assertEquals(5000.0f, developer.grossSalary, "Gross Salary should be set correctly");
            assertEquals(300.0f, developer.travellingAllowances, "Travelling Allowances should be set correctly");
            assertEquals(150.0f, developer.federalTax, "Federal Tax should be set correctly");
            assertEquals(100.0f, developer.stateTax, "State Tax should be set correctly");
            assertEquals(10.0f, developer.incrementPercentage, "Increment Percentage should be set correctly");
            assertEquals(5, developer.noOfProjects, "No of Projects should be set correctly");

        } catch (Exception e) {
            fail("Exception occurred during constructor testing: " + e.getMessage());
        }
    }



    @Test
    @Order(5)
    @DisplayName("Test calculateNetSalary Method in Employee Class")
    public void testCalculateNetSalaryInEmployee() {
        Employee employee = new Employee(1234L, "Jane Doe", "Senior Developer", 5000.0f, 300.0f, 150.0f, 100.0f, 10.0f);

        // Call the method and verify its output
        float expectedNetSalary = employee.grossSalary - employee.federalTax - employee.stateTax;
        float actualNetSalary = employee.calculateNetSalary();

        assertEquals(expectedNetSalary, actualNetSalary, "Net Salary calculation in Employee class should be correct");
    }

    @Test
    @Order(6)
    @DisplayName("Test calculateNetSalary Method Override in Developer Class")
    public void testCalculateNetSalaryInDeveloper() {
        // Initialize Developer with specific values
        Developer developer = new Developer(1234L, "Jane Doe", "Senior Developer", 5000.0f, 300.0f, 150.0f, 100.0f, 10.0f, 5);

        // Redirect System.out to capture the print statements
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Call the method and verify its output
        float expectedNetSalary = developer.grossSalary - developer.federalTax - developer.stateTax;
        float actualNetSalary = developer.calculateNetSalary();

        // Verify method output
        String expectedOutput = "calculateNetSalary() - Developer Class" + System.lineSeparator();
        String actualOutput = outContent.toString();

        assertTrue(actualOutput.contains(expectedOutput), "The method should print the correct output");
        assertEquals(expectedNetSalary, actualNetSalary, "Net Salary calculation in Developer class should be correct");

        // Reset System.out
        System.setOut(originalOut);
    }

    @Test
    @Order(7)
    @DisplayName("Test calculateNetSalary Method Presence and Override in Developer Class")
    public void testCalculateNetSalaryMethodPresence() {
        try {
            Class<?> developerClass = Class.forName("com.trainingmug.employee.Developer");

            Method method = developerClass.getDeclaredMethod("calculateNetSalary");

            assertEquals(float.class, method.getReturnType(), "Method should return float");
            assertEquals(0, method.getParameterCount(), "Method should have no parameters");

            Developer developer = new Developer(1234L, "Jane Doe", "Senior Developer", 5000.0f, 300.0f, 150.0f, 100.0f, 10.0f, 5);
            float actualNetSalary = developer.calculateNetSalary();
            float expectedNetSalary = developer.grossSalary - developer.federalTax - developer.stateTax;

            assertEquals(expectedNetSalary, actualNetSalary, "Net Salary calculation should be correct");

        } catch (Exception e) {
            fail("Exception occurred during method testing: " + e.getMessage());
        }
    }




    @Test
    @Order(9)
    @DisplayName("Test calculateNetSalaryAfterIncrement Method Override in Developer Class")
    public void testCalculateNetSalaryAfterIncrementInDeveloper() {
        // Initialize Developer with specific values
        Developer developer = new Developer(1234L, "Jane Doe", "Senior Developer", 5000.0f, 300.0f, 150.0f, 100.0f, 10.0f, 5);

        // Redirect System.out to capture the print statements
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Call the method and verify its output
        float netSalary = developer.calculateNetSalary();
        float incrementPercentage = developer.incrementPercentage;
        float expectedNetSalaryAfterIncrement = netSalary + (netSalary * incrementPercentage / 100);
        float actualNetSalaryAfterIncrement = developer.calculateNetSalaryAfterIncrement();

        // Verify method output
        String expectedOutput = "calculateNetSalaryAfterIncrement() - Developer Class" + System.lineSeparator();
        String actualOutput = outContent.toString();

        assertTrue(actualOutput.contains(expectedOutput), "The method should print the correct output");
        assertEquals(expectedNetSalaryAfterIncrement, actualNetSalaryAfterIncrement, "Net Salary After Increment calculation in Developer class should be correct");

        // Reset System.out
        System.setOut(originalOut);
    }

    @Test
    @Order(10)
    @DisplayName("Test calculateNetSalaryAfterIncrement Method Presence and Override in Developer Class")
    public void testCalculateNetSalaryAfterIncrementMethodPresence() {
        try {
            // Load the Developer class
            Class<?> developerClass = Class.forName("com.trainingmug.employee.Developer");

            // Check if the method is overridden
            Method method = developerClass.getDeclaredMethod("calculateNetSalaryAfterIncrement");

            // Verify that the method is overridden and has the correct return type and parameters
            assertEquals(float.class, method.getReturnType(), "Method should return float");
            assertEquals(0, method.getParameterCount(), "Method should have no parameters");

            // Instantiate Developer to test method behavior
            Developer developer = new Developer(1234L, "Jane Doe", "Senior Developer", 5000.0f, 300.0f, 150.0f, 100.0f, 10.0f, 5);
            float netSalary = developer.calculateNetSalary();
            float incrementPercentage = developer.incrementPercentage;
            float expectedNetSalaryAfterIncrement = netSalary + (netSalary * incrementPercentage / 100);
            float actualNetSalaryAfterIncrement = developer.calculateNetSalaryAfterIncrement();

            assertEquals(expectedNetSalaryAfterIncrement, actualNetSalaryAfterIncrement, "Net Salary After Increment calculation should be correct");

        } catch (Exception e) {
            fail("Exception occurred during method testing: " + e.getMessage());
        }
    }


    @Test
    @Order(11)
    @DisplayName("Test displayProfile Method Override in Developer Class")
    public void testDisplayProfileMethodOverride() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.employee.Employee");
            Class<?> developerClass = Class.forName("com.trainingmug.employee.Developer");

            Method methodInDeveloper = developerClass.getMethod("displayProfile");

            Method methodInEmployee = employeeClass.getMethod("displayProfile");

            assertNotNull(methodInEmployee, "Employee class should have displayProfile method");
            assertTrue(methodInDeveloper.getDeclaringClass().equals(developerClass),
                    "displayProfile should be overridden in Developer class");

        } catch (Exception e) {
            fail("Exception occurred during method testing: " + e.getMessage());
        }
    }


}
