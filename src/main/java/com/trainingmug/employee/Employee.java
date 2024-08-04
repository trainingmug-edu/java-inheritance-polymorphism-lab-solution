package com.trainingmug.employee;

public class Employee {

    // Instance Variables

    public long empId;
    public String name;
    public String designation;
    public float grossSalary;
    public float travellingAllowances;
    public float federalTax;
    public float stateTax;
    public float incrementPercentage;


    public static String companyName = "Digi-Safari Pvt Ltd";
    public static String companyContactNo = "+1 678-505-0990";
    public static int employeeCount = 0;


    public Employee(){
        employeeCount++;
        empId = 1111;
        name = "Andrew Fuller";
        designation = "Senior Software Engineer";
        grossSalary = 5208.33f;
        travellingAllowances = 300.0f;
        federalTax = 611.86f;
        stateTax = 359.24f;
        incrementPercentage = 15.3f;

    }

    public Employee(long empId, String name, String designation, float grossSalary, float travellingAllowances,
                    float federalTax, float stateTax, float incrementPercentage) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.grossSalary = grossSalary;
        this.travellingAllowances = travellingAllowances;
        this.federalTax = federalTax;
        this.stateTax = stateTax;
        this.incrementPercentage = incrementPercentage;
        employeeCount++;
    }

    public void displayProfile() {
        System.out.println("Id : " + empId);
        System.out.println("Name : " + name);
        System.out.println("Designation : " + designation);
        System.out.println("Gross Salary : " + grossSalary);
        System.out.println("Travelling Allowances : " + travellingAllowances);
        System.out.println("Federal Tax : " + federalTax);
        System.out.println("State Tax : " + stateTax);
        System.out.println("Net Salary Increment Percentage : " + incrementPercentage);
        System.out.println("Net Salary : " + this.calculateNetSalary());
        System.out.println("Net Salary After Increment : " + this.calculateNetSalaryAfterIncrement());

    }

    public static void displayCompanyInfo() {
        System.out.println("Company Name : " + companyName);
        System.out.println("Company Contact No : " + companyContactNo);
        System.out.println("Employee Count : " + employeeCount);
    }

    public float calculateNetSalary() {
        return grossSalary - federalTax - stateTax;
    }

    public float calculateNetSalaryAfterIncrement() {
        float netSalary;
        netSalary = calculateNetSalary();
        netSalary += (netSalary * incrementPercentage / 100);
        return netSalary;
    }

}
