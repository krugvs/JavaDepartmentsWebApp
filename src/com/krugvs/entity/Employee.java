package com.krugvs.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Class Employee entity
 * Created by vlad on 6/24/14.
 * @author vlad
 */
public class Employee {
    private Integer id;
    private String name;
    private Date birthday;
    private String passportNumber;
    private BigDecimal salary;
    private Department department;
    private Position position;

    public Employee(Integer id, String name, Date birthday, String passportNumber, BigDecimal salary, Department department, Position position) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.passportNumber = passportNumber;
        this.salary = salary;
        this.department = department;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", passportNumber='" + passportNumber + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                ", position=" + position +
                '}';
    }
}
