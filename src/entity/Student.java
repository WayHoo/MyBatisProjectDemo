package entity;

//学生实体类
public class Student {
    private int stuNo;
    private String stuName;
    private boolean stuGender;
    private int stuAge;
    private String gradeName;

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
