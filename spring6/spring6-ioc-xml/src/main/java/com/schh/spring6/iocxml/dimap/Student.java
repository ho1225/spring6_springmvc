package com.schh.spring6.iocxml.dimap;

import java.util.Map;

public class Student {
    private Map<String, Teacher> teacherMap;
    private String sid;
    private String sname;

    public void run() {
        System.out.println("sid: " + sid + "sname: "+ sname);
        System.out.println(teacherMap);
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
