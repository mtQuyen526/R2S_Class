package com.example.project.entities;

public class Employee {
    private int id;
    private String lastName;
    private String firstName;
    private String birthdate;
    private int supervisor;

    // getter
    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public int getSupervisor() {
        return supervisor;
    }

    //setter

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        if (supervisor == 0)
            return "Employee{" +
                    "id=" + id +
                    ", lastName='" + lastName + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", birthdate='" + birthdate + '\'' +
                    ", supervisor= null" +
                    '}';
        else
            return "Employee{" +
                    "id=" + id +
                    ", lastName='" + lastName + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", birthdate='" + birthdate + '\'' +
                    ", supervisor=" + supervisor +
                    '}';
    }
}
