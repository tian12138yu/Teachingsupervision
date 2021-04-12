package com.tjy.dao;

import com.tjy.domian.*;
import com.tjy.domian.Class;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    List<Student> getAllStudent(StudentInfo studentInfo);

    List<Course> getCourseByid(@Param("list")List<Integer> list);

    int getCountStudent(StudentInfo studentInfo);

    List<Class> getClassList();

    void addStudent(Student student);

    Student getUpdateStudent(Long sid);

    void editStudent(Student student);

    void deleteStudent(Long sid);

    List<Integer> getCourseidzBycid(Long cid);

    List<Class> getClassListByInfo(ClassInfo classInfo);

    int getClassListCount(ClassInfo classInfo);

    void addClass(Class c);

    List<Integer> getCouseIdWithoutCid(Long cid);

    void insertClassCourse(Long courseId, Long classId);

    List<Course> getNoCourseByList(List<Integer> list);

    Student getStudentCourseById(Integer id);


    void updateStudent(Student student);

}