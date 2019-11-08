package mapper;

import entity.StuNoListWrapper;
import entity.Student;
import entity.StudentClass;

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
    Student queryStuByNameOrAgeWithSQLTag(Student stu);
    List<Student> queryStuByStuNoListWithAttribute(StuNoListWrapper stuNoListWrapper);
    List<Student> queryStuByStuNoListWithArray(int[] stuNoArray);
    List<Student> queryStuByStuNoListWithList(List<Integer> stuNoList);
    List<Student> queryStuByStuNoListWithObjectArray(Student[] students);
    Student queryStuAndCard(int stuNo);
    StudentClass queryAllStuInClass(int classId);
    List<Student> lazyQueryAllStuAndCard();
    List<Student> queryStuByClassId(int classId);   //用于一对多延迟加载
}
