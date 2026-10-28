package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PayrollCalc {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /* Test
        Employee worker = new Employee("12121", "Firdavs", 25, 22.50);
        System.out.println(worker.getGrossPay());
         */

        System.out.print("Enter the name of the file to process: ");
        String inputFile = scanner.nextLine();

        System.out.print("Enter the name of the payroll file to create: ");
        String outputFile = scanner.nextLine();

        try{
            FileReader fileReader = new FileReader("src/main/resources/" + inputFile);
            BufferedReader bufReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            bufWriter.write("id|name|gross pay");

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

                String writeInput = String.format("\n%s|%s|%.2f", worker.getEmployeeId(), worker.getName(), worker.getGrossPay());
                bufWriter.write(writeInput);
            }

            bufReader.close();
            bufWriter.close();
        } catch (Exception e) {
            System.out.println("Kapoot, there's an error");
            e.printStackTrace();
        }



    }
}
