package com.trainingmug.employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class PayrollTest {

    @Test
    @Order(1)
    @DisplayName("Test Payroll class should be present in com.trainingmug.employee.app package")
    void testPayrollClassShouldBePresent() {
        assertDoesNotThrow(() -> {
            Class.forName("com.trainingmug.employee.Payroll");
        }, "Payroll class should be present");
    }

    @Test
    @Order(2)
    @DisplayName("Test Payroll class has displayProfile method")
    public void testDisplayProfileMethodPresence() {
        try {
            Class<?> payrollClass = Class.forName("com.trainingmug.employee.Payroll");

            Method method = payrollClass.getDeclaredMethod("displayProfile", Employee.class);

            assertNotNull(method, "Payroll class should have displayProfile method");

            assertEquals(void.class, method.getReturnType(), "displayProfile should have void return type");

            Class<?>[] parameterTypes = method.getParameterTypes();
            assertEquals(1, parameterTypes.length, "displayProfile should have one parameter");
            assertEquals(Employee.class, parameterTypes[0], "Parameter should be of type Employee");
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            fail("Exception occurred during method testing: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Test displayProfile implementation in Payroll class")
    public void testDisplayProfileImplementation() {
        Employee mockEmployee = new Employee(1234L, "Jane Doe", "Senior Developer", 5000.0f, 300.0f, 150.0f, 100.0f, 10.0f) {
            @Override
            public void displayProfile() {
                System.out.println("displayProfile() - Mock Employee Class");
                System.out.println("Id : " + empId);
                System.out.println("Name : " + name);
                System.out.println("Designation : " + designation);
                System.out.println("Gross Salary : " + grossSalary);
                System.out.println("Travelling Allowances : " + travellingAllowances);
                System.out.println("Federal Tax : " + federalTax);
                System.out.println("State Tax : " + stateTax);
                System.out.println("Net Salary Increment Percentage : " + incrementPercentage);
            }
        };

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Payroll payroll = new Payroll();
        payroll.displayProfile(mockEmployee);

        String expectedOutput = "displayProfile() - Mock Employee Class" + System.lineSeparator() +
                "Id : 1234" + System.lineSeparator() +
                "Name : Jane Doe" + System.lineSeparator() +
                "Designation : Senior Developer" + System.lineSeparator() +
                "Gross Salary : 5000.0" + System.lineSeparator() +
                "Travelling Allowances : 300.0" + System.lineSeparator() +
                "Federal Tax : 150.0" + System.lineSeparator() +
                "State Tax : 100.0" + System.lineSeparator() +
                "Net Salary Increment Percentage : 10.0" + System.lineSeparator();

        String actualOutput = outContent.toString();

        assertEquals(expectedOutput, actualOutput, "The displayProfile method should call the Employee's displayProfile correctly");

        System.setOut(originalOut);
    }

    @Test
    @Order(4)
    @DisplayName("Test Payroll class has calculateNetSalary method")
    public void testCalculateNetSalaryMethodPresence() {
        try {
            Class<?> payrollClass = Class.forName("com.trainingmug.employee.Payroll");

            Method method = payrollClass.getDeclaredMethod("calculateNetSalary", Employee.class);

            assertNotNull(method, "Payroll class should have calculateNetSalary method");

            assertEquals(float.class, method.getReturnType(), "calculateNetSalary should have float return type");

            Class<?>[] parameterTypes = method.getParameterTypes();
            assertEquals(1, parameterTypes.length, "calculateNetSalary should have one parameter");
            assertEquals(Employee.class, parameterTypes[0], "Parameter should be of type Employee");
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            fail("Exception occurred during method testing: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @DisplayName("Test calculateNetSalary implementation in Payroll class")
    public void testCalculateNetSalaryImplementation() {
        Employee mockEmployee = new Employee(1234L, "John Doe", "Developer", 5000.0f, 300.0f, 150.0f, 100.0f, 10.0f) {
            @Override
            public float calculateNetSalary() {
                System.out.println("calculateNetSalary() - Mock Employee Class");
                return 4750.0f;
            }
        };

        Payroll payroll = new Payroll();
        float result = payroll.calculateNetSalary(mockEmployee);

        float expectedNetSalary = 4750.0f;

        assertEquals(expectedNetSalary, result, "The calculateNetSalary method should return the expected net salary");
    }

    @Test
    @Order(6)
    @DisplayName("Test Payroll class has calculateNetSalaryAfterIncrement method")
    public void testCalculateNetSalaryAfterIncrementMethodPresence() {
        try {
            Class<?> payrollClass = Class.forName("com.trainingmug.employee.Payroll");

            Method method = payrollClass.getDeclaredMethod("calculateNetSalaryAfterIncrement", Employee.class);

            assertNotNull(method, "Payroll class should have calculateNetSalaryAfterIncrement method");

            assertEquals(float.class, method.getReturnType(), "calculateNetSalaryAfterIncrement should have float return type");

            Class<?>[] parameterTypes = method.getParameterTypes();
            assertEquals(1, parameterTypes.length, "calculateNetSalaryAfterIncrement should have one parameter");
            assertEquals(Employee.class, parameterTypes[0], "Parameter should be of type Employee");
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            fail("Exception occurred during method testing: " + e.getMessage());
        }
    }

    @Test
    @Order(7)
    @DisplayName("Test calculateNetSalaryAfterIncrement implementation in Payroll class")
    public void testCalculateNetSalaryAfterIncrementImplementation() {
        Employee mockEmployee = new Employee(1234L, "Jane Doe", "Senior Developer", 5000.0f, 300.0f, 150.0f, 100.0f, 10.0f) {
            @Override
            public float calculateNetSalaryAfterIncrement() {
                System.out.println("calculateNetSalaryAfterIncrement() - Mock Employee Class");
                return 5225.0f;
            }
        };

        Payroll payroll = new Payroll();
        float result = payroll.calculateNetSalaryAfterIncrement(mockEmployee);

        float expectedNetSalaryAfterIncrement = 5225.0f;

        assertEquals(expectedNetSalaryAfterIncrement, result, "The calculateNetSalaryAfterIncrement method should return the expected net salary after increment");
    }

    @Test
    @Order(8)
    @DisplayName("Test Payroll class has displayProfile(int empId) method")
    public void testDisplayProfileIntMethodPresence() {
        try {
            Class<?> payrollClass = Class.forName("com.trainingmug.employee.Payroll");

            Method method = payrollClass.getDeclaredMethod("displayProfile", int.class);

            assertNotNull(method, "Payroll class should have displayProfile(int empId) method");
            assertEquals(void.class, method.getReturnType(), "displayProfile(int empId) should have void return type");
            assertEquals(1, method.getParameterCount(), "displayProfile(int empId) should have one parameter");
            assertEquals(int.class, method.getParameterTypes()[0], "Parameter should be of type int");

            Payroll payroll = new Payroll();
            payroll.displayProfile(101);

        } catch (NoSuchMethodException | ClassNotFoundException e) {
            fail("Exception occurred during method testing: " + e.getMessage());
        }
    }

    @Test
    @Order(9)
    @DisplayName("Test Payroll class has displayProfile(float fromSalaryRange, float toSalaryRange) method")
    public void testDisplayProfileFloatMethodPresence() {
        try {
            Class<?> payrollClass = Class.forName("com.trainingmug.employee.Payroll");

            Method method = payrollClass.getDeclaredMethod("displayProfile", float.class, float.class);

            assertNotNull(method, "Payroll class should have displayProfile(float fromSalaryRange, float toSalaryRange) method");
            assertEquals(void.class, method.getReturnType(), "displayProfile(float fromSalaryRange, float toSalaryRange) should have void return type");
            assertEquals(2, method.getParameterCount(), "displayProfile(float fromSalaryRange, float toSalaryRange) should have two parameters");
            assertEquals(float.class, method.getParameterTypes()[0], "First parameter should be of type float");
            assertEquals(float.class, method.getParameterTypes()[1], "Second parameter should be of type float");

            Payroll payroll = new Payroll();
            payroll.displayProfile(3000.0f, 5000.0f);

        } catch (NoSuchMethodException | ClassNotFoundException e) {
            fail("Exception occurred during method testing: " + e.getMessage());
        }
    }

    @Test
    @Order(10)
    @DisplayName("Test Payroll class has displayProfile(String department) method")
    public void testDisplayProfileStringMethodPresence() {
        try {
            Class<?> payrollClass = Class.forName("com.trainingmug.employee.Payroll");

            Method method = payrollClass.getDeclaredMethod("displayProfile", String.class);

            assertNotNull(method, "Payroll class should have displayProfile(String department) method");
            assertEquals(void.class, method.getReturnType(), "displayProfile(String department) should have void return type");
            assertEquals(1, method.getParameterCount(), "displayProfile(String department) should have one parameter");
            assertEquals(String.class, method.getParameterTypes()[0], "Parameter should be of type String");

            Payroll payroll = new Payroll();
            payroll.displayProfile("IT");

        } catch (NoSuchMethodException | ClassNotFoundException e) {
            fail("Exception occurred during method testing: " + e.getMessage());
        }
    }

}
