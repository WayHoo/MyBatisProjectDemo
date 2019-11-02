package mapper;

import entity.Student;

import java.util.HashMap;
import java.util.List;

//操作MyBatis的接口
public interface StudentMapper {
    Student queryStudentByStuNo(int stuNo);
    List<Student> queryAllStudents();
    void addStudent(Student stu);
    void deleteStudentByStuNo(int stuNo);
    void updateStudentByStuNo(Student stu);
    Student queryStudentByStuNoWithConverter(int stuNo);
    void addStudentWithConverter(Student stu);
    List<Student> queryAllStudentsOrderByColumn(String stuName);
    void queryCountByGradeNameWithProcedure(HashMap<String,Object> params);
}
