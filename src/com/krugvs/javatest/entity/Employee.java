package com.krugvs.javatest.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by vlad on 6/18/14.
 */
public class Employee {
    private String name;
    private Date birthday;
    private String passportNumber;
    private BigDecimal salary;

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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", passportNumber='" + passportNumber + '\'' +
                ", salary=" + salary +
                '}';
    }
}
