import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.macross.entity.*;
import org.macross.mapper.StudentMapper;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMyBatis {
    public static void queryStudentByStuno() throws IOException {
        //加载MyBatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //session - connection

        SqlSession session = sessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.queryStudentByStuno(1);

        System.out.println(student);
        session.close();
    }
    public static void queryStudentByStunoWithConverter() throws IOException {
        //加载MyBatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //session - connection

        SqlSession session = sessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.queryStudentByStunoWithConverter(1);

        System.out.println(student);
        session.close();
    }
    public static void queryAllStudents() throws IOException {
        //加载MyBatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader) ;
        //session - connection

        SqlSession session = sessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.queryAllStudents();

        System.out.println(students);
        session.close();
    }
    public static void queryStudentByaddress() throws IOException {
        //加载MyBatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader) ;
        //session - connection

        SqlSession session = sessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);

        Student student = new Student();
        Address address = new Address();
        address.setHomeAddress("广州");
        address.setSchoolAddress("珠海");
        student.setAddress(address);
        List<Student> students = mapper.queryStudentByaddress(student);

        System.out.println(students);
        session.close();
    }
    public static void queryCountByGradeWithProcedure() throws IOException {
        //加载MyBatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader) ;
        //session - connection

        SqlSession session = sessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);


        Map<String,Object> params = new HashMap<>();
        params.put("graName","haha");
        mapper.queryCountByGradeWithProcedure(params);

        Object count = params.get("scount");
        System.out.println(count);
        session.close();
    }
    public static void queryAllStudentsOutByHashMap() throws IOException {
        //加载MyBatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader) ;
        //session - connection

        SqlSession session = sessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<HashMap<String,Object>> students = mapper.queryAllStudentsOutByHashMap();

        System.out.println(students);
        session.close();
    }
    public static void queryStudentBySnoOrSname() throws IOException {
        //加载MyBatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader) ;
        //session - connection

        SqlSession session = sessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setStuNo(2);
//        student.setStuName("macross");
        student = mapper.queryStudentBySnoOrSname(student);

        System.out.println(student);
        session.close();
    }
    public static void queryStudentInStuno() throws IOException {
        //加载MyBatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader) ;
        //session - connection

        SqlSession session = sessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student1 = new Student();
        student1.setStuNo(1);
        Student student2 = new Student();
        student2.setStuNo(2);
        Student[] stu = new Student[]{student1,student2};
        List<Student> students = mapper.queryStudentInStuno(stu);

        System.out.println(students);
        session.close();
    }
    public static void addStudent() throws IOException {
        //加载MyBatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader) ;
        //session - connection

        SqlSession session = sessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setStuNo(5);
        student.setStuName("kl");
        student.setStuAge(55);
        student.setGraName("das");

        int count = mapper.addStudent(student);
        session.commit();
        System.out.println("增加了"+count+"个学生");
        session.close();
    }
    public static void addStudentWithConverter() throws IOException {
        //加载MyBatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader) ;
        //session - connection

        SqlSession session = sessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setStuNo(5);
        student.setStuName("kl");
        student.setStuAge(55);
        student.setGraName("das");
        student.setStuSex(false);

        int count = mapper.addStudentWithConverter(student);
        session.commit();
        System.out.println("增加了"+count+"个学生");
        session.close();
    }
    public static void deleteStudentByStuno() throws IOException {
        //加载MyBatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader) ;
        //session - connection

        SqlSession session = sessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        int count = mapper.deleteStudentByStuno(5);

        session.commit();
        System.out.println("删除了"+count+"个学生");
        session.close();
    }
    public static void updateStudentByStuno() throws IOException {
        //加载MyBatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader) ;
        //session - connection

        SqlSession session = sessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        Student student = new Student();
        student.setStuNo(2);
        student.setStuName("2");
        student.setStuAge(2);
        student.setGraName("1");

        final int count = mapper.updateStudentByStuno(student);
        session.commit();
        System.out.println("更新了"+count+"个学生");
        session.close();
    }

    //关联查询,一对一
    public static void queryStudentWithcardId() throws IOException {
        //加载MyBatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader) ;
        //session - connection

        SqlSession session = sessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);

        Student student = mapper.queryStudentWithcardId(1);

        System.out.println(student.toString_Basic());
        StudentCard studentCard = student.getCard();
        System.out.println(studentCard);
        session.close();
    }

    //关联查询，一对多
    public static void queryStudentClass() throws IOException {
        //加载MyBatis配置文件（为了访问数据库）
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader) ;
        //session - connection

        SqlSession session = sessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);

        StudentClass studentClass = mapper.queryStudentClass(1);

        System.out.println(studentClass);

        List<Student> students = studentClass.getStudents();
        for(Student student:students)
        {
            System.out.println(student.toString_Basic());
        }

        //二级缓存测试
        StudentMapper mapper2 = session.getMapper(StudentMapper.class);

        StudentClass studentClass2 = mapper2.queryStudentClass(1);

        System.out.println(studentClass2);

        List<Student> students2 = studentClass2.getStudents();
        for(Student student:students2)
        {
            System.out.println(student.toString_Basic());
        }


        session.close();
    }

    public static void main(String[] args) throws IOException {
//      queryStudentByStuno();
//       queryAllStudents();
//        queryStudentByStunoWithConverter();
//       queryStudentByaddress();
//        queryCountByGradeWithProcedure();
//        queryAllStudentsOutByHashMap();
//        queryStudentBySnoOrSname();
//        queryStudentInStuno();
//        addStudent();
//        addStudentWithConverter();
//        queryAllStudents();
//       deleteStudentByStuno();
//      updateStudentByStuno();

        //关联查询
//        queryStudentWithcardId();
        queryStudentClass();
    }
}
