package test;

import entity.StuNoListWrapper;
import entity.Student;
import entity.StudentClass;
import mapper.StudentClassMapper;
import mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//测试类
public class TestMyBatis {
    private static Reader reader;
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession sqlSession;
    private static StudentMapper studentMapper;

    public static void queryStudentByStuNo(int stuNo) throws IOException {
        Student stu = studentMapper.queryStudentByStuNo(stuNo);
        System.out.println(stu);
        sqlSession.close();
    }

    public static void queryStudentByStuNoWithConverter(int stuNo) throws IOException {
        Student stu = studentMapper.queryStudentByStuNoWithConverter(stuNo);
        System.out.println(stu);
        sqlSession.close();
    }

    public static void queryAllStudents() throws IOException {
        List<Student> list = studentMapper.queryAllStudents();
        for (Student student : list) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    public static void queryAllStudentsOrderByColumn() throws IOException {
        List<Student> list = studentMapper.queryAllStudentsOrderByColumn("stuName");
        for (Student student : list) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    public static void addStudent(Student stu) throws IOException {
        studentMapper.addStudent(stu);
        sqlSession.commit();//JDBC模式下必须手动提交事务
        sqlSession.close();
    }

    public static void addStudentWithConverter(Student stu) throws IOException {
        studentMapper.addStudentWithConverter(stu);
        sqlSession.commit();//JDBC模式下必须手动提交事务
        sqlSession.close();
    }

    public static void deleteStudentByStuNo(int stuNo) throws IOException {
        studentMapper.deleteStudentByStuNo(stuNo);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void updateStudentByStuNo(Student stu) throws IOException {
        studentMapper.updateStudentByStuNo(stu);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void queryCountByGradeNameWithProcedure() throws IOException {
        HashMap<String,Object> params = new HashMap<>();
        params.put("gName","研一");
        studentMapper.queryCountByGradeNameWithProcedure(params);
        int count = (Integer) params.get("scount");
        System.out.println(params.get("gName")+"的人数为："+count);
        sqlSession.close();
    }

    public static void queryStuByNameOrAgeWithSQLTag() throws IOException {
        Student stu = new Student();
        stu.setStuName("胡伟");
        stu.setStuAge(22);
        Student stuAns = studentMapper.queryStuByNameOrAgeWithSQLTag(stu);
        System.out.println(stuAns);
        sqlSession.close();
    }
    public static void queryStuByStuNoListWithAttribute() throws IOException {
        StuNoListWrapper stuNoListWrapper = new StuNoListWrapper();
        ArrayList<Integer> stuNoList = new ArrayList<>();
        stuNoList.add(1);
        stuNoList.add(2);
        stuNoList.add(3);
        stuNoListWrapper.setStuNoList(stuNoList);
        List<Student> stuAns = studentMapper.queryStuByStuNoListWithAttribute(stuNoListWrapper);
        for (Student stu : stuAns) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    public static void queryStuByStuNoListWithArray() throws IOException {
        int[] stuNoArray = {1,2,3};
        List<Student> stuAns = studentMapper.queryStuByStuNoListWithArray(stuNoArray);
        for (Student stu : stuAns) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    public static void queryStuByStuNoListWithList() throws IOException {
        List<Integer> stuNoArray = new ArrayList<>();
        stuNoArray.add(1);
        stuNoArray.add(2);
        stuNoArray.add(3);
        List<Student> stuAns = studentMapper.queryStuByStuNoListWithList(stuNoArray);
        for (Student stu : stuAns) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    public static void queryStuByStuNoListWithObjectArray() throws IOException {
        Student stu1 = new Student();
        stu1.setStuNo(1);
        Student stu2 = new Student();
        stu2.setStuNo(2);
        Student stu3 = new Student();
        stu3.setStuNo(3);
        Student[] students = new Student[]{stu1,stu2,stu3};
        List<Student> stuAns = studentMapper.queryStuByStuNoListWithObjectArray(students);
        for (Student stu : stuAns) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    public static void queryStuAndCard() throws IOException {
        Student stuAns = studentMapper.queryStuAndCard(1);
        System.out.println(stuAns);
        System.out.println(stuAns.getStuCard());
        sqlSession.close();
    }

    public static void queryAllStuInClass() throws IOException {
        StudentClass stuClass = studentMapper.queryAllStuInClass(1);
        System.out.println(stuClass.getClassName());
        List<Student> stuAns = stuClass.getStudents();
        for (Student stu : stuAns) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    //一对一延迟加载
    public static void lazyQueryAllStuAndCard() throws IOException {
        List<Student> stuAns = studentMapper.lazyQueryAllStuAndCard();
        System.out.println(stuAns.get(0).getStuName());
//        for (Student stu : stuAns) {
//            System.out.println(stu);
//            System.out.println(stu.getStuCard());
//        }
        sqlSession.close();
    }

    //一对多延迟加载
    public static void lazyQueryClassByClassId() throws IOException {
        StudentClassMapper studentClassMapper = sqlSession.getMapper(StudentClassMapper.class);
        StudentClass studentClass = studentClassMapper.lazyQueryClassByClassId(1);
        System.out.println(studentClass.getClassName());
        List<Student> students = studentClass.getStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    //测试二级缓存
    public static void test2LevleCache() throws IOException {
        Student stu1 = studentMapper.queryStudentByStuNo(2);
        System.out.println(stu1);
        sqlSession.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);
        Student stu2 = studentMapper2.queryStudentByStuNo(2);
        System.out.println(stu2);
        sqlSession.close();
    }

    public static void main(String[] args) throws IOException {
        //加载MyBatis配置文件（为了访问数据库）
        reader = Resources.getResourceAsReader("config.xml");
        //可以通过build的第二个参数指定数据库环境（不建议）
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = sqlSessionFactory.openSession();
        studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student stu = new Student(10,"谭芬",false,23,"研一");
//        updateStudentByStuNo(stu);
//        queryStudentByStuNoWithConverter(1);
//        addStudent(stu);
//        deleteStudentByStuNo(5);
//        addStudentWithConverter(stu);
//        queryAllStudentsOrderByColumn();
//        queryStudentByStuNo(1);
//        queryCountByGradeNameWithProcedure();
//        queryStuByNameOrAgeWithSQLTag();
//        queryStuByStuNoListWithAttribute();
//        queryStuByStuNoListWithArray();
//        queryStuByStuNoListWithList();
//        queryStuByStuNoListWithObjectArray();
//        queryStuAndCard();
//        queryAllStuInClass();
//        lazyQueryAllStuAndCard();
//        lazyQueryClassByClassId();
        test2LevleCache();
    }
}
