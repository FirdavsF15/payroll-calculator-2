package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class PayrollCalc {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /* Test
        Employee worker = new Employee("12121", "Firdavs", 25, 22.50);
        System.out.println(worker.getGrossPay());
         */

        try{
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String input;
            input = bufReader.readLine();

            while((input = bufReader.readLine()) != null){
                String[] parts = input.split("\\|");
                String id = parts[0];
                String name = parts[1];
                double hours = Double.parseDouble(parts[2]);
                double rate = Double.parseDouble(parts[3]);
                Employee worker = new Employee(id, name, hours, rate);

                System.out.printf("Employee %s: %s earned $%.2f \n",worker.getEmployeeId(), worker.getName(), worker.getGrossPay());
            }

            bufReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
