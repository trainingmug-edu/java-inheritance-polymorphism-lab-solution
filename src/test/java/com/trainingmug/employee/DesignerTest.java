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

public class DesignerTest {

    @Test
    @Order(1)
    @DisplayName("Test Designer class should be present in com.trainingmug.employee package")
    void testDesignerClassShouldBePresent() {
        assertDoesNotThrow(() -> {
            Class.forName("com.trainingmug.employee.Designer");
        }, "Designer class should be present");
    }


    @Test
    @Order(2)
    @DisplayName("Check if Designer Class Extends Employee Class")
    public void testDesignerClassInheritance() {
        try {
            Class<?> designerClass = Class.forName("com.trainingmug.employee.Designer");

            Class<?> employeeClass = Class.forName("com.trainingmug.employee.Employee");

            assertTrue(employeeClass.isAssignableFrom(designerClass),
                    "Designer class should extend Employee class");

        } catch (ClassNotFoundException e) {
            fail("Designer or Employee class not found: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Check if Designer Class Contains noOfProjects Field")
    public void testDesignerClassNoOfProjectsField() {
        try {
            Class<?> designerClass = Class.forName("com.trainingmug.employee.Designer");

            Field noOfWebsitesField = designerClass.getDeclaredField("noOfWebsites");

            assertEquals(int.class, noOfWebsitesField.getType(),
                    "Field noOfWebsites should be of type int");

        } catch (ClassNotFoundException e) {
            fail("Designer class not found: " + e.getMessage());
        } catch (NoSuchFieldException e) {
            fail("Field noOfWebsites not found in Designer class: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @DisplayName("Test Designer Constructor Presence and Super Constructor Invocation")
    public void testDesignerConstructor() {
        try {
            Class<?> designerClass = Class.forName("com.trainingmug.employee.Designer");

            Constructor<?> constructor = designerClass.getConstructor(
                    long.class, String.class, String.class, float.class, float.class,
                    float.class, float.class, float.class, int.class
            );

            assertNotNull(constructor, "All Args Constructor should be present in Designer class");

            Designer designer = (Designer) constructor.newInstance(
                    1234L, "Jane Doe", "Senior Developer", 5000.0f, 300.0f,
                    150.0f, 100.0f, 10.0f, 5
            );

            assertEquals(1234L, designer.empId, "Employee ID should be set correctly");
            assertEquals("Jane Doe", designer.name, "Name should be set correctly");
            assertEquals("Senior Developer", designer.designation, "Designation should be set correctly");
            assertEquals(5000.0f, designer.grossSalary, "Gross Salary should be set correctly");
            assertEquals(300.0f, designer.travellingAllowances, "Travelling Allowances should be set correctly");
            assertEquals(150.0f, designer.federalTax, "Federal Tax should be set correctly");
            assertEquals(100.0f, designer.stateTax, "State Tax should be set correctly");
            assertEquals(10.0f, designer.incrementPercentage, "Increment Percentage should be set correctly");
            assertEquals(5, designer.noOfWebsites, "No of Websites should be set correctly");

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
    @DisplayName("Test calculateNetSalary Method Override in Designer Class")
    public void testCalculateNetSalaryInDesigner() {
        Designer designer = new Designer(1234L, "Jane Doe", "Senior Developer", 5000.0f, 300.0f, 150.0f, 100.0f, 10.0f, 5);

        float expectedNetSalary = designer.grossSalary - designer.federalTax - designer.stateTax;
        float actualNetSalary = designer.calculateNetSalary();

         assertEquals(expectedNetSalary, actualNetSalary, "Net Salary calculation in Designer class should be correct");


    }

    @Test
    @Order(7)
    @DisplayName("Test calculateNetSalary Method Presence and Override in Designer Class")
    public void testCalculateNetSalaryMethodInDesignerClassShouldBePresence() {
        try {
            Class<?> designerClass = Class.forName("com.trainingmug.employee.Designer");

            Method method = designerClass.getDeclaredMethod("calculateNetSalary");

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
    @Order(8)
    @DisplayName("Test calculateNetSalaryAfterIncrement Method Override in Designer Class")
    public void testCalculateNetSalaryAfterIncrementInDesigner() {
        Designer designer = new Designer(1234L, "Jane Doe", "Senior Developer", 5000.0f, 300.0f, 150.0f, 100.0f, 10.0f, 5);



        // Call the method and verify its output
        float netSalary = designer.calculateNetSalary();
        float incrementPercentage = designer.incrementPercentage;
        float expectedNetSalaryAfterIncrement = netSalary + (netSalary * incrementPercentage / 100);
        float actualNetSalaryAfterIncrement = designer.calculateNetSalaryAfterIncrement();



        assertEquals(expectedNetSalaryAfterIncrement, actualNetSalaryAfterIncrement, "Net Salary After Increment calculation in Designer class should be correct");



    }

    @Test
    @Order(10)
    @DisplayName("Test calculateNetSalaryAfterIncrement Method Presence and Override in Designer Class")
    public void testCalculateNetSalaryAfterIncrementMethodPresence() {
        try {
            Class<?> designerClass = Class.forName("com.trainingmug.employee.Designer");

            Method method = designerClass.getDeclaredMethod("calculateNetSalaryAfterIncrement");

            assertEquals(float.class, method.getReturnType(), "Method should return float");
            assertEquals(0, method.getParameterCount(), "Method should have no parameters");

            Designer designer = new Designer(1234L, "Jane Doe", "Senior Developer", 5000.0f, 300.0f, 150.0f, 100.0f, 10.0f, 5);
            float netSalary = designer.calculateNetSalary();
            float incrementPercentage = designer.incrementPercentage;
            float expectedNetSalaryAfterIncrement = netSalary + (netSalary * incrementPercentage / 100);
            float actualNetSalaryAfterIncrement = designer.calculateNetSalaryAfterIncrement();

            assertEquals(expectedNetSalaryAfterIncrement, actualNetSalaryAfterIncrement, "Net Salary After Increment calculation should be correct");

        } catch (Exception e) {
            fail("Exception occurred during method testing: " + e.getMessage());
        }
    }

    @Test
    @Order(11)
    @DisplayName("Test displayProfile Method Override in Designer Class")
    public void testDisplayProfileMethodOverride() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.employee.Employee");
            Class<?> designerClass = Class.forName("com.trainingmug.employee.Designer");

            Method methodInDesigner = designerClass.getMethod("displayProfile");

            Method methodInEmployee = employeeClass.getMethod("displayProfile");

            assertNotNull(methodInEmployee, "Employee class should have displayProfile method");
            assertEquals(methodInDesigner.getDeclaringClass(), designerClass, "displayProfile should be overridden in Designer class");

        } catch (Exception e) {
            fail("Exception occurred during method testing: " + e.getMessage());
        }
    }

}
