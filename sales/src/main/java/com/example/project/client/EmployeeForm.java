package com.example.project.client;

import com.example.project.entities.Employee;

import java.time.Year;
import java.util.Scanner;

public class EmployeeForm {


    private final Scanner sc;

    public EmployeeForm(Scanner sc) {
        this.sc = sc;
    }

    public int getId() {
        int id;

        System.out.print("Enter id: ");
        id = Integer.parseInt(sc.nextLine());

        return id;
    }

    public Employee getEmployee() {
        Employee employee = new Employee();

        System.out.print("Enter employee last name: ");
        employee.setLastName(sc.nextLine().trim());

        System.out.print("Enter employee first name: ");
        employee.setFirstName(sc.nextLine().trim());

        System.out.println("Enter employee birthdate:");
        int day = 0;
        int month = 0;
        int year = 0;
        System.out.print("Day: ");
        try {
            day = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Day must be a number. " + e.getMessage());
        }
        System.out.print("Month: ");
        try {
            month = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Month must be a number. " + e.getMessage());
        }
        System.out.print("Year: ");
        try {
            year = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Year must be a number. " + e.getMessage());
        }
        employee.setBirthdate(String.format("%04d-%02d-%02d", year, month, day));

        System.out.print("Enter employee supervisor id: ");
        try {
            employee.setSupervisor(Integer.parseInt(sc.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("supervisor id must be a number. " + e.getMessage());
        }

        return employee;
    }

}
