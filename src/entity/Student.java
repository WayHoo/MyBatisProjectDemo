package entity;

import java.io.Serializable;

//学生实体类
public class Student implements Serializable {
    //学生基本信息
    private int stuNo;
    private String stuName;
    private boolean stuGender;
    private int stuAge;
    private String gradeName;
    //学生证信息
    private StudentCard stuCard;

    public Student() {

    }

    public Student(int stuNo, String stuName, boolean stuGender, int stuAge, String gradeName) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.stuAge = stuAge;
        this.gradeName = gradeName;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public boolean isStuGender() {
        return stuGender;
    }

    public void setStuGender(boolean stuGender) {
        this.stuGender = stuGender;
    }

    public StudentCard getStuCard() { return stuCard; }

    public void setStuCard(StudentCard stuCard) { this.stuCard = stuCard; }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo=" + stuNo +
                ", stuName='" + stuName + '\'' +
                ", stuGender=" + stuGender +
                ", stuAge=" + stuAge +
                ", gradeName='" + gradeName + '\'' +
                '}';
    }
}
