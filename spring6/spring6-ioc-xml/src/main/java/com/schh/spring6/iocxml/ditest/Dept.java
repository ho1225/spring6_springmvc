package com.schh.spring6.iocxml.ditest;

import java.util.List;

// department
public class Dept {
    private List<Emp> empList;

    private String dname;

    public void info() {
        System.out.println("dname: " + dname);
        for (Emp emp : empList){
            System.out.println(emp.getEname());
        }
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }
}
