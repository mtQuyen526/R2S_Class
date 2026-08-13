package com.example.project.client;

import com.example.project.dao.CustomerDAO;
import com.example.project.dao.EmployeeDAO;
import com.example.project.entities.Customer;
import com.example.project.entities.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesManagement {
    private static Scanner sc;
    private CustomerDAO customerDAO;
    private CustomerForm customerForm;
    private EmployeeForm employeeForm;
    private EmployeeDAO employeeDAO;

    // final customer
    static final String GET_ALL_CUSTOMERS = "1";
    static final String ADD_NEW_CUSTOMER = "2";
    static final String UPDATE_CUSTOMER = "3";
    static final String REMOVE_CUSTOMER = "4";

    // final employee

    static final String GET_ALL_EMPLOYEE = "5";
    static final String ADD_NEW_EMPLOYEE = "6";
    static final String UPDATE_EMPLOYEE = "7";
    static final String REMOVE_EMPLOYEE = "8";

    // quit
    static final String QUIT = "0";

    private void initialize() throws SQLException {
        sc = new Scanner(System.in);
        Connection conn = getConnection();

        // Customer
        customerForm = new CustomerForm(sc);
        customerDAO = new CustomerDAO(conn);
        employeeForm = new EmployeeForm(sc);
        employeeDAO = new EmployeeDAO(conn);
    }

    public SalesManagement() throws SQLException {
        initialize();
    }

    public static void main(String[] args) {
        String choice = "";
        SalesManagement management = null;
        do {
            try {
                management = new SalesManagement();
                createMenu();
                choice = sc.nextLine();

                switch (choice) {
                    case GET_ALL_CUSTOMERS:
                        management.displayAllCustomers();
                        break;
                    case ADD_NEW_CUSTOMER:
                        management.addCustomer();
                        break;
                    case UPDATE_CUSTOMER:
                        management.updateCustomer();
                        break;
                    case REMOVE_CUSTOMER:
                        management.removeCustomer();
                        break;
                    case GET_ALL_EMPLOYEE:
                        management.displayAllEmployees();
                        break;
                    case ADD_NEW_EMPLOYEE:
                        management.addEmployee();
                        break;
                    case UPDATE_EMPLOYEE:
                        management.updateEmployee();
                        break;
                    case REMOVE_EMPLOYEE:
                        management.removeEmployee();
                        break;
                    default:
                        if (!choice.equals(QUIT)) {
                            System.out.println("Wrong choice");
                        }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        } while (!choice.equals(QUIT));
    }

    private static void createMenu() {
        /*System.out.println("\n1. Get all customers");
        System.out.println("2. Add new an customer");
        System.out.println("3. Change customer information");
        System.out.println("4. Remove an customer");
        System.out.println("0. Quit");
        System.out.print("Your choice: ");*/

        System.out.println("""
                1. Get all customers.
                2. Add new an customer.
                3. Change customer information.
                4. Remove an customer.
                5. Get all employee.
                6. Add new an employee.
                7. Change employee information.
                8. Remove an employee.
                0. Quit.""");
        System.out.print("Your choice: ");
    }

    private static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sales_JDBC";

            return DriverManager.getConnection(url, "root", "123456");
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Can not open connection " + e.getMessage());
        }
    }

    private void displayAllCustomers() throws SQLException {
        ArrayList<Customer> customers = customerDAO.selectAll();

        if (customers == null || customers.isEmpty()) {
            System.out.println("Not found");
            return;
        }

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private void addCustomer() throws SQLException {
        Customer customer = customerForm.getCustomer();

        if (customerDAO.insert(customer)) {
            System.out.println("Successful");
        } else {
            System.out.println("Unsuccessful");
        }
    }

    private void updateCustomer() throws SQLException {
        int id = customerForm.getId();
        Customer customer = customerForm.getCustomer();
        if (customerDAO.update(id, customer)) {
            System.out.println("Successful");
        } else {
            System.out.println("Unsuccessful");
        }
    }

    private void removeCustomer() throws SQLException {
        int id = customerForm.getId();

        if (customerDAO.delete(id)) {
            System.out.println("Successful");
        } else {
            System.out.println("Unsuccessful");
        }
    }

    // table employee
    private void displayAllEmployees() throws SQLException {
        ArrayList<Employee> employees = employeeDAO.selectAll();

        if (employees == null || employees.isEmpty()) {
            System.out.println("Not found");
            return;
        }

        for (Employee employee  : employees) {
            System.out.println(employee);
        }
    }
    private void addEmployee() throws SQLException {
        Employee employee = employeeForm.getEmployee();

        if (employeeDAO.insert(employee)) {
            System.out.println("Successful");
        } else {
            System.out.println("Unsuccessful");
        }
    }

    private void updateEmployee() throws SQLException {
        int id = employeeForm.getId();
        Employee employee = employeeForm.getEmployee();
        if (employeeDAO.update(id, employee)) {
            System.out.println("Successful");
        } else {
            System.out.println("Unsuccessful");
        }
    }

    private void removeEmployee() throws SQLException {
        int id = employeeForm.getId();

        if (employeeDAO.delete(id)) {
            System.out.println("Successful");
        } else {
            System.out.println("Unsuccessful");
        }
    }

}
