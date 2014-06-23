package com.krugvs.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 6/18/14.
 */
public class Department {
    private Integer id =  null;
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public Department(String name, int id) {
        this(name);
        this.id = id;
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

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
