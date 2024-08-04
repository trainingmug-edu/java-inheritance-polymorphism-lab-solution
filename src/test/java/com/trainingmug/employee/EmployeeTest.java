package com.trainingmug.employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    @Order(1)
    @DisplayName("Test Employee class should be present in com.trainingmug.employee.app package")
    void testEmployeeClassShouldBePresent() {
        assertDoesNotThrow(() -> {
            Class.forName("com.trainingmug.employee.Employee");
        }, "Employee class should be present");
    }

    @Test
    @Order(2)
    @DisplayName("Should create the fields in Employee class with the appropriate Type")
    void testVariablesInEmployeeShouldBePresent() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.employee.Employee");
            assertFieldIsPublic(employeeClass, "empId", long.class);
            assertFieldIsPublic(employeeClass, "name", String.class);
            assertFieldIsPublic(employeeClass, "designation", String.class);
            assertFieldIsPublic(employeeClass, "grossSalary", float.class);
            assertFieldIsPublic(employeeClass, "travellingAllowances", float.class);
            assertFieldIsPublic(employeeClass, "federalTax", float.class);
            assertFieldIsPublic(employeeClass, "stateTax", float.class);
            assertFieldIsPublic(employeeClass, "incrementPercentage", float.class);

        } catch (ClassNotFoundException e) {
            fail("Class Employee should be present, but it was not found");
        }
    }

    private void assertFieldIsPublic(Class<?> clazz, String fieldName, Class<?> fieldType) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            assertEquals(fieldType, field.getType(), "Field " + fieldName + " should be of type " + fieldType.getSimpleName());
            assertTrue(Modifier.isPublic(field.getModifiers()), "Field " + fieldName + " should be public");
        } catch (NoSuchFieldException e) {
            fail("Field " + fieldName + " should be present in the class " + clazz.getSimpleName());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Should have Employee() no-arg constructor")
    public void testEmployeeConstructor() {
        String className = "com.trainingmug.employee.Employee";
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> noArgConstructor = clazz.getDeclaredConstructor();
            assertNotNull(noArgConstructor, "Employee() No-arg constructor should be present");
            assertTrue(Modifier.isPublic(noArgConstructor.getModifiers()), "No-arg constructor should be public");
        } catch (ClassNotFoundException e) {
            fail("Class " + className + " does not exist");
        } catch (NoSuchMethodException e) {
            fail("Employee() No-arg constructor not found in class " + className);
        }
    }

    @Test
    @Order(4)
    @DisplayName("Should be able to create Employee Constructor and initialize the properties")
    public void shouldBeAbleToCreateEmployeeConstructorAndInitializeProperties() {
        Employee employee = new Employee();
        float delta = 0.01f;

        assertEquals(1111, employee.empId, "Employee id should be 111");
        assertEquals("Andrew Fuller", employee.name, "Employee name should be Andrew Fuller");
        assertEquals("Senior Software Engineer", employee.designation, "Employee designation should be Senior Software Engineer");
        assertEquals(5208.33, employee.grossSalary,delta, "Employee grossSalary should be 5208.33");
        assertEquals(300.0, employee.travellingAllowances,delta, "Employee travellingAllowances should be 300.0f");
        assertEquals(611.86, employee.federalTax,delta, "Employee federalTax should be 611.86");
        assertEquals(359.24, employee.stateTax,delta, "Employee stateTax should be 359.24");
        assertEquals(15.3, employee.incrementPercentage,delta, "Employee incrementPercentage should be 15.3");
    }


    @Test
    @Order(5)
    @DisplayName("Should create Employee All Args Constructor")
    public void testEmployeeAllArgsConstructor() {
        String className = "com.trainingmug.employee.Employee";
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor(long.class, String.class, String.class, float.class, float.class, float.class, float.class,float.class);

            assertNotNull(constructor, "Employee All Args Constructor should be present");
            assertTrue(Modifier.isPublic(constructor.getModifiers()), "Constructor should be public");
        } catch (ClassNotFoundException e) {
            fail("Class " + className + " does not exist");
        } catch (NoSuchMethodException e) {

            fail("Employee All Args Constructor is not found in class  " + className);
        }
    }

    @Test
    @Order(6)
    @DisplayName("Should be able to create Employee Arg Constructor and initialize the properties")
    public void shouldBeAbleToCreateEmployeeArgConstructorAndInitializeProperties() {
        float delta = 0.01f;
        Employee employee = new Employee(1111,"Andrew Fuller","Senior Software Engineer",5208.33f,300.0f,611.86f,359.24f,15.3f);
        assertEquals(1111, employee.empId, "Id value should be 111");
        assertEquals("Andrew Fuller", employee.name, "Name should be Andrew Fuller");
        assertEquals("Senior Software Engineer", employee.designation, "Department should be Senior Software Engineer");
        assertEquals(5208.33, employee.grossSalary, delta,"Gross Salary should be 5208.33");
        assertEquals(300.0, employee.travellingAllowances, delta,"Gross Salary should be 5208.33");
        assertEquals(611.86, employee.federalTax, delta, "TravellingAllowances should be 300.0");
        assertEquals(359.24, employee.stateTax, delta,"StateTax should be 611.86");
        assertEquals(15.3, employee.incrementPercentage,delta, "Increment Percentage should be 15.3");
    }



    @Test
    @Order(7)
    @DisplayName("Test if calculateNetSalary Method is Present")
    void testCalculateNetSalaryMethodPresence() {
        try {
            Method method = Employee.class.getDeclaredMethod("calculateNetSalary");
            assertNotNull(method, "calculateNetSalary method should be present in Employee class");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("calculateNetSalary method not found", e);
        }
    }

    @Test
    @Order(8)
    @DisplayName("Test calculateNetSalary Method Return Type should be float")
    void testCalculateNetSalaryMethodReturnTypeShouldBeFloat() {
        try {
            Method method = Employee.class.getDeclaredMethod("calculateNetSalary");
            assertEquals(float.class, method.getReturnType(), "calculateNetSalary method should return float");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("calculateNetSalary method not found", e);
        }
    }

    @Test
    @Order(9)
    @DisplayName("Test calculateNetSalary Method Parameters Should Be Empty")
    void testCalculateNetSalaryMethodParametersShouldBeEmpty() {
        try {
            Method method = Employee.class.getDeclaredMethod("calculateNetSalary");
            assertEquals(0, method.getParameterCount(), "calculateNetSalary method should have no parameters");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("calculateNetSalary method not found", e);
        }
    }

    @Test
    @Order(10)
    @DisplayName("Test calculateNetSalary Method Logic")
    void testCalculateNetSalaryMethodLogic() {
        Employee employee = new Employee(1234, "John Doe", "Software Engineer", 5000.0f, 300.0f, 200.0f, 100.0f, 5.0f);

        float expectedNetSalary = 4700.0f; // 5000 - 200 - 100
        float actualNetSalary = employee.calculateNetSalary();

        assertEquals(expectedNetSalary, actualNetSalary, "calculateNetSalary method logic should correctly calculate the net salary");
    }

    @Test
    @Order(11)
    @DisplayName("Test if calculateNetSalaryAfterIncrement Method is Present")
    void testCalculateNetSalaryAfterIncrementMethodPresence() throws NoSuchMethodException {
        Method method = Employee.class.getDeclaredMethod("calculateNetSalaryAfterIncrement");
        assertNotNull(method, "calculateNetSalaryAfterIncrement method should be present in Employee class");
    }

    @Test
    @Order(12)
    @DisplayName("Test calculateNetSalaryAfterIncrement Method Return Type should be ")
    void testCalculateNetSalaryAfterIncrementMethodReturnType() throws NoSuchMethodException {
        Method method = Employee.class.getDeclaredMethod("calculateNetSalaryAfterIncrement");
        assertEquals(float.class, method.getReturnType(), "calculateNetSalaryAfterIncrement method should return float");
    }

    @Test
    @Order(13)
    @DisplayName("Test calculateNetSalaryAfterIncrement Method Parameters")
    void testCalculateNetSalaryAfterIncrementMethodParameters() throws NoSuchMethodException {
        Method method = Employee.class.getDeclaredMethod("calculateNetSalaryAfterIncrement");
        assertEquals(0, method.getParameterCount(), "calculateNetSalaryAfterIncrement method should have no parameters");
    }

    @Test
    @Order(14)
    @DisplayName("Test calculateNetSalaryAfterIncrement Method Logic")
    void testCalculateNetSalaryAfterIncrementMethodLogic() {
        Employee employee = new Employee(1234, "John Doe", "Software Engineer", 5000.0f, 300.0f, 200.0f, 100.0f, 10.0f);

        float expectedNetSalary = 5000.0f - 200.0f - 100.0f; // grossSalary - federalTax - stateTax
        float incrementedNetSalary = expectedNetSalary + (expectedNetSalary * 10.0f / 100); // netSalary + 10% increment
        float actualNetSalaryAfterIncrement = employee.calculateNetSalaryAfterIncrement();

        assertEquals(incrementedNetSalary, actualNetSalaryAfterIncrement, "calculateNetSalaryAfterIncrement method logic should correctly calculate the incremented net salary");
    }

    @Test
    @Order(15)
    @DisplayName("Test if displayProfile Method is Present")
    void testDisplayProfileMethodPresence() throws NoSuchMethodException {
        Method method = Employee.class.getDeclaredMethod("displayProfile");
        assertNotNull(method, "displayProfile method should be present in Employee class");
    }

    @Test
    @Order(16)
    @DisplayName("Test displayProfile Method Return Type")
    void testDisplayProfileMethodReturnType() throws NoSuchMethodException {
        Method method = Employee.class.getDeclaredMethod("displayProfile");
        assertEquals(void.class, method.getReturnType(), "displayProfile method should return void");
    }

    @Test
    @Order(17)
    @DisplayName("Test displayProfile Method Parameters")
    void testDisplayProfileMethodParameters() throws NoSuchMethodException {
        Method method = Employee.class.getDeclaredMethod("displayProfile");
        assertEquals(0, method.getParameterCount(), "displayProfile method should have no parameters");
    }

//    @Test
//    @Order(18)
//    @DisplayName("Test DisplayProfile Output")
//    public void testDisplayProfileOutput() {
//        // Initialize Employee object with specific values
//        Employee employee = new Employee(1111, "Andrew Fuller", "Senior Software Engineer", 5208.33f, 300.0f, 611.86f, 359.24f, 15.3f);
//        float netSalary = employee.calculateNetSalary();
//        float netSalaryAfter = employee.calculateNetSalaryAfterIncrement();
//
//        // Redirect System.out to capture the print statements
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        PrintStream originalOut = System.out;
//        System.setOut(new PrintStream(outContent));
//
//        try {
//            // Call the displayProfile method
//            employee.displayProfile();
//
//            // Build expected output with platform-specific newlines
//            String expectedOutput = String.format(
//                    "displayProfile() - Employee Class%s" +
//                            "Employee ID: %d%s" +
//                            "Name: %s%s" +
//                            "Designation: %s%s" +
//                            "Gross Salary: %.2f%s" +
//                            "Travelling Allowances: %.1f%s" +
//                            "Federal Tax: %.2f%s" +
//                            "State Tax: %.2f%s" +
//                            "Net Salary Increment Percentage: %.1f%s" +
//                            "Net Salary : %.2f%s" +
//                            "Net Salary After Increment : %.2f%s",
//                    System.lineSeparator(),
//                    employee.empId, System.lineSeparator(),
//                    employee.name, System.lineSeparator(),
//                    employee.designation, System.lineSeparator(),
//                    employee.grossSalary, System.lineSeparator(),
//                    employee.travellingAllowances, System.lineSeparator(),
//                    employee.federalTax, System.lineSeparator(),
//                    employee.stateTax, System.lineSeparator(),
//                    employee.incrementPercentage, System.lineSeparator(),
//                    netSalary, System.lineSeparator(),
//                    netSalaryAfter, System.lineSeparator()
//            );
//
//            // Compare actual output with expected output
//            String actualOutput = outContent.toString();
//
//            // Print outputs for debugging
//            System.out.println("Expected Output:");
//            System.out.println(expectedOutput);
//            System.out.println("Actual Output:");
//            System.out.println(actualOutput);
//
//            assertEquals(expectedOutput, actualOutput, "The displayProfile method should print the correct output");
//        } finally {
//            // Restore System.out to its original state
//            System.setOut(originalOut);
//        }
//    }


}
