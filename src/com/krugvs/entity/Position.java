package com.krugvs.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by vlad on 6/18/14.
 */
public class Position {
    private int id;
    final private String name;
    private BigDecimal mixSalary;
    private BigDecimal maxSalary;
    private ArrayList<Employee> employees;

    /**
     *
     * @param name
     */
    public Position(String name) {
        this.name = name;
        employees= new ArrayList<Employee>();
    }

    /**
     *
     * @param name
     * @param mixSalary
     * @param maxSalary
     */
    public Position(String name, BigDecimal mixSalary, BigDecimal maxSalary) {
        this(name);
        this.mixSalary = mixSalary;
        this.maxSalary = maxSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getMixSalary() {
        return mixSalary;
    }

    public void setMixSalary(BigDecimal mixSalary) {
        this.mixSalary = mixSalary;
    }

    public BigDecimal getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(BigDecimal maxSalary) {
        this.maxSalary = maxSalary;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mixSalary=" + mixSalary +
                ", maxSalary=" + maxSalary +
                ", employees=" + employees +
                '}';
    }
}
