package com.schh.spring6.iocxml.ditest;

import java.util.Arrays;

//employee
public class Emp {
    private Dept dept;
    private String ename;
    private Integer age;
    private String[] loves;

    public void work() {
        System.out.println(ename + " emp working..." + age);
        dept.info();
        System.out.println(Arrays.toString(loves));
    }
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getLoves() {
        return loves;
    }

    public void setLoves(String[] loves) {
        this.loves = loves;
    }
}
