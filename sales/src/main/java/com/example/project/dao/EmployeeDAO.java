package com.example.project.dao;

import com.example.project.entities.Customer;
import com.example.project.entities.Employee;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {
    private final Connection conn;

    public EmployeeDAO(Connection conn) throws SQLException {
        this.conn = conn;
    }

    public ArrayList<Employee> selectAll() throws SQLException {
        if (conn == null) {
            return null;
        }

        String select = "select * from employees";
        ArrayList<Employee> employees = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(select);
             ResultSet rs = ps.executeQuery();) {
            // Code here
            while (rs.next()) {
                Employee employee = new Employee();

                employee.setId(rs.getInt("employee_id"));
                employee.setLastName(rs.getString("first_Name"));
                employee.setFirstName(rs.getString("last_Name"));
                employee.setBirthdate(rs.getString("birth_date"));
                employee.setSupervisor(rs.getInt("supervisor_id"));

                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new SQLException("Can not display employees" + e.getMessage());
        }

        return employees;
    }


    public boolean insert(Employee employee) throws SQLException {
        if (conn == null) {
            return false;
        }

        String insert = "{call sp_add_employee(?, ?, ?, ?)}"; // sử dụng procedue

        int index = 1;
        try (CallableStatement cs = conn.prepareCall(insert);) {
            cs.setString(index++, employee.getLastName());
            cs.setString(index++, employee.getFirstName());
            cs.setString(index++, employee.getBirthdate());
            cs.setInt(index++, employee.getSupervisor());

            if (cs.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        return false;
    }

    public boolean update(int id, Employee employee) throws SQLException {
        if (conn == null) {
            return false;
        }

        String update = """
                UPDATE employees
                SET last_name = ?,
                    first_name = ?,
                    birth_date = ?,
                    supervisor_id = ?
                WHERE employee_id = ?
                """;

        int index = 1;
        try (PreparedStatement ps = conn.prepareStatement(update);) {
            // Code here
            ps.setString(index++, employee.getFirstName());
            ps.setString(index++, employee.getLastName());
            ps.setString(index++, employee.getBirthdate());
            ps.setInt(index++, employee.getSupervisor());
            ps.setInt(index++, id);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new SQLException("Can not update employee" + e.getMessage());
        }

        return false;
    }

    public boolean delete(int id) throws SQLException {
        if (conn == null) {
            return false;
        }

        String delete = "delete from employees where employee_id = ?"; // cau lenh trong sql

        int index = 1;

        try (PreparedStatement ps = conn.prepareStatement(delete);) {
            ps.setInt(index++, id);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new SQLException("Can not delete employee" + e.getMessage());
        }

        return false;
    }

    // lấy danh sách ID để kiểm tra tồn tại
    public ArrayList<Integer> selectAllID() throws SQLException {
        ArrayList<Integer> ids = new ArrayList<>();

        String sql = "SELECT employee_id FROM employees";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ids.add(rs.getInt("employee_id"));
            }
        }

        return ids;
    }
}