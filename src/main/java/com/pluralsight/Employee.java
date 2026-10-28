package com.pluralsight;

public class Employee {

    private String employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee(){

    }

    public Employee(String employeeId, String name, double hoursWorked, double payRate){
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;

    }

    public String getEmployeeId(){
        return this.employeeId;
    }
    public void setEmployeeId(String employeeId){
        this.employeeId = employeeId;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getHoursWorked(){
        return this.hoursWorked;
    }
    public void setHoursWorked(double hoursWorked){
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate(){
        return this.payRate;
    }
    public void setPayRate(double payRate){
        this.payRate = payRate;
    }

    public double getGrossPay(){
        if( hoursWorked<=40){
            return hoursWorked * payRate;
        }else{
            return calcOvertimePay(hoursWorked, payRate);
        }
    }

    //helper method
    public static double calcOvertimePay(double hours, double rate){
        double totalPay = 40 * rate;

        hours = hours - 40;

        totalPay += hours * (rate * 1.5);
        return totalPay;
    }
}

