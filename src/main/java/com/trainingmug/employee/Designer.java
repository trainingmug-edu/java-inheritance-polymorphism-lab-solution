package com.trainingmug.employee;

public class Designer extends Employee {

    int noOfWebsites;

    public Designer() {
        super();
    }

    public Designer(long empId, String name, String designation, float grossSalary, float travellingAllowances,
                    float federalTax, float stateTax, float incrementPercentage, int noOfWebsites) {
        super(empId, name, designation, grossSalary, travellingAllowances, federalTax, stateTax, incrementPercentage);
        this.noOfWebsites = noOfWebsites;
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

