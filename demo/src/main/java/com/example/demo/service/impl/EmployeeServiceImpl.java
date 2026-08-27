package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeRequest;
import com.example.demo.dto.EmployeeResponse;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // ===== READ ALL =====
    @Override
    @Transactional
    public List<EmployeeResponse> getAll() {
        return employeeRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // ===== READ ONE =====
    @Override
    @Transactional

    public EmployeeResponse getById(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with id = " + id));
        return toResponse(employee);
    }

    // ===== CREATE =====
    @Override
    public EmployeeResponse create(EmployeeRequest request) {
        Employee employee = new Employee();

        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setBirthDate(request.getBirthDate());

        if (request.getSupervisorId() != null) {
            Employee supervisor = employeeRepository
                    .findById(request.getSupervisorId())
                    .orElseThrow(() -> new RuntimeException("Supervisor not found"));

            employee.setSupervisor(supervisor);
        }

        // employee.setSupervisorId(request.getSupervisorId());

        Employee saved = employeeRepository.save(employee);
        return toResponse(saved);
    }


    // ===== UPDATE =====
    @Override
    public EmployeeResponse update(Integer id, EmployeeRequest request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with id = " + id));

        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setBirthDate(request.getBirthDate());

        if (request.getSupervisorId() != null) {
            Employee supervisor = employeeRepository
                    .findById(request.getSupervisorId())
                    .orElseThrow(() -> new RuntimeException("Supervisor not found"));

            employee.setSupervisor(supervisor);
        }
        // employee.setSupervisorId(request.getSupervisorId());

        Employee updated = employeeRepository.save(employee);
        return toResponse(updated);
    }

    // ===== DELETE =====
    @Override
    public void delete(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with id = " + id));

        employeeRepository.delete(employee);
    }

    // ===== MAPPER =====
    private EmployeeResponse toResponse(Employee e) {
        EmployeeResponse res = new EmployeeResponse();
        res.setEmployeeId(e.getEmployeeId());
        res.setFirstName(e.getFirstName());
        res.setLastName(e.getLastName());
        res.setBirthDate(e.getBirthDate());

        if (e.getSupervisor() != null) {
            res.setSupervisorId(e.getSupervisor().getEmployeeId());
        } else {
            res.setSupervisorId(null);
        }
        return res;
    }
}