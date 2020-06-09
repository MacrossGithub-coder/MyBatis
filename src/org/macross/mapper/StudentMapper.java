package org.macross.mapper;

import org.macross.entity.Student;
import org.macross.entity.StudentBusiness;
import org.macross.entity.StudentClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudentMapper {
    /*
     * 1.方法名和mapper.xml文件中标签的id值相同
     * 2.方法的 输入参数 和mapper.xml文件中标签的 parameterType类型一致
     * 3.方法的返回值  和mapper.xml文件中标签的 resultType类型一致
     *
     */
    Student queryStudentByStuno(int stuno);

    List<Student> queryAllStudents();

    Student queryStudentByStunoWithConverter(int stuno);

    List<Student> queryStudentByaddress(Student student);

    void queryCountByGradeWithProcedure(Map<String,Object> params);

    List<HashMap<String,Object>> queryAllStudentsOutByHashMap();

    Student queryStudentBySnoOrSname(Student student);

    List<Student> queryStudentInStuno(Student[] students);

    int addStudent(Student student);

    int addStudentWithConverter(Student student);

    int deleteStudentByStuno(int stuno);

    int updateStudentByStuno(Student student);

    //关联查询
    Student queryStudentWithcardId(int stuno);
    StudentClass queryStudentClass(int classid);
}