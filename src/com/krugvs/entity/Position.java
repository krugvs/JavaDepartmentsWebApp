package com.krugvs.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Class for Position entity
 * Created by vlad on 6/18/14.
 * @author vlad
 */
public class Position {
    private Integer id;
    private String name;
    private BigDecimal minSalary = BigDecimal.ZERO;
    private BigDecimal maxSalary = BigDecimal.ZERO;

    /**
     *
     * @param name
     */
    public Position(Integer id, String name) {
        this.name = name;
        this.id   = id;
    }

    /**
     *
     * @param name
     * @param minSalary
     * @param maxSalary
     */
    public Position(Integer id, String name, BigDecimal minSalary, BigDecimal maxSalary) {
        this(id, name);
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
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

    public BigDecimal getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    public BigDecimal getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(BigDecimal maxSalary) {
        this.maxSalary = maxSalary;
    }


    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}
