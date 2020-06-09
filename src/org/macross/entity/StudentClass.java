package org.macross.entity;

import java.io.Serializable;
import java.util.List;

public class StudentClass implements Serializable {
    private int classId;
    private String className;
    List<Student> students;

    public StudentClass(int classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public StudentClass() {
    }
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
//                ", students=" + students.toString() +
                '}';
    }
}
