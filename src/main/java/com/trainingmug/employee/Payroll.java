package com.trainingmug.employee;

public class Payroll {
    public void displayProfile(Employee employee) {
        employee.displayProfile();
    }

    public float calculateNetSalary(Employee employee) {
        return employee.calculateNetSalary();
    }

    public float calculateNetSalaryAfterIncrement(Employee employee) {
        return employee.calculateNetSalaryAfterIncrement();
    }

    public void displayProfile(int empId) {
        System.out.println("This method display the employee profile with Employee ID");
    }

    public void displayProfile(float fromSalaryRange,float toSalaryRange) {
        System.out.println("This method display all employee profiles from and to given salary ranges");
    }

    public void displayProfile(String department) {
        System.out.println("This method display all the employee profiles from a given department");
    }

}

