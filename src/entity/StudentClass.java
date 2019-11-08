package entity;

import java.util.List;

public class StudentClass {
    private int classId;
    private String className;
    //增加学生属性（通过该字段让student类和studentClass类相互关联）
    private List<Student> students;

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
