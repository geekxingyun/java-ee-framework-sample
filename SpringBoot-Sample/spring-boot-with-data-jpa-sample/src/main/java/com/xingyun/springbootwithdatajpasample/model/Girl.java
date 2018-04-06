package com.xingyun.springbootwithdatajpasample.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;
    private String girlName;
    private Integer girlAge;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGirlName() {
        return girlName;
    }

    public void setGirlName(String girlName) {
        this.girlName = girlName;
    }

    public Integer getGirlAge() {
        return girlAge;
    }

    public void setGirlAge(Integer girlAge) {
        this.girlAge = girlAge;
    }
}
