package test;

import entity.Student;
import mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

//测试类
public class TestMyBatis {
    public static void queryStudentByStuNo(int stuNo) throws IOException {
        Reader reader = Resources.getResourceAsReader("config.xml");
        //可以通过build的第二个参数指定数据库环境（不建议）
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student stu = studentMapper.queryStudentByStuNo(stuNo);
        System.out.println(stu);
        sqlSession.close();
    }

    public static void queryStudentByStuNoWithConverter(int stuNo) throws IOException {
        Reader reader = Resources.getResourceAsReader("config.xml");
        //可以通过build的第二个参数指定数据库环境（不建议）
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student stu = studentMapper.queryStudentByStuNoWithConverter(stuNo);
        System.out.println(stu);
        sqlSession.close();
    }

    public static void queryAllStudents() throws IOException {
        Reader reader = Resources.getResourceAsReader("config.xml");
        //可以通过build的第二个参数指定数据库环境（不建议）
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = studentMapper.queryAllStudents();
        for (Student student : list) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    public static void queryAllStudentsOrderByColumn() throws IOException {
        Reader reader = Resources.getResourceAsReader("config.xml");
        //可以通过build的第二个参数指定数据库环境（不建议）
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = studentMapper.queryAllStudentsOrderByColumn("stuName");
        for (Student student : list) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    public static void addStudent(Student stu) throws IOException {
        Reader reader = Resources.getResourceAsReader("config.xml");
        //可以通过build的第二个参数指定数据库环境（不建议）
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        studentMapper.addStudent(stu);
        sqlSession.commit();//JDBC模式下必须手动提交事务
        sqlSession.close();
    }

    public static void addStudentWithConverter(Student stu) throws IOException {
        Reader reader = Resources.getResourceAsReader("config.xml");
        //可以通过build的第二个参数指定数据库环境（不建议）
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        studentMapper.addStudentWithConverter(stu);
        sqlSession.commit();//JDBC模式下必须手动提交事务
        sqlSession.close();
    }

    public static void deleteStudentByStuNo(int stuNo) throws IOException {
        Reader reader = Resources.getResourceAsReader("config.xml");
        //可以通过build的第二个参数指定数据库环境（不建议）
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        studentMapper.deleteStudentByStuNo(stuNo);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void updateStudentByStuNo(Student stu) throws IOException {
        Reader reader = Resources.getResourceAsReader("config.xml");
        //可以通过build的第二个参数指定数据库环境（不建议）
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        studentMapper.updateStudentByStuNo(stu);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void queryCountByGradeNameWithProcedure() throws IOException {
        Reader reader = Resources.getResourceAsReader("config.xml");
        //可以通过build的第二个参数指定数据库环境（不建议）
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String,Object> params = new HashMap<>();
        params.put("gName","研一");
        studentMapper.queryCountByGradeNameWithProcedure(params);
        int count = (Integer) params.get("scount");
        System.out.println(params.get("gName")+"的人数为："+count);
        sqlSession.close();
    }

    public static void main(String[] args) throws IOException {
        Student stu = new Student(10,"谭芬",false,23,"研一");
//        updateStudentByStuNo(stu);
//        queryStudentByStuNoWithConverter(1);
//        addStudent(stu);
//        deleteStudentByStuNo(5);
//        addStudentWithConverter(stu);
//        queryAllStudentsOrderByColumn();
//        queryStudentByStuNo(1);
//        queryCountByGradeNameWithProcedure();
    }
}
