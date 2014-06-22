package com.krugvs.javatest.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 6/18/14.
 */
public class Department {
    private int id;
    private String name;
    private ArrayList<Position> positions;

    public Department() {
        positions = new ArrayList<Position>();
    }

    public Department(String name) {
        this();
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    public List<Position> getPositions() {
        return positions;
    }

    /**
     *
     * @param positions
     */
    public void setPositions(ArrayList<Position> positions) {
        this.positions = positions;
    }

    public void addPosition(Position position){
        positions.add(position);
    }

    /**
     *
     * @return
     */
    public List<Employee> getEmployees(){
        List<Employee> employees = new ArrayList<Employee>() ;
        for (Position position : positions) {
            employees.addAll(position.getEmployees());
        }
        return employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
               // ", positions=" + positions +
                '}';
    }
}
