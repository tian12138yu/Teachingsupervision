package com.tjy.service;



import com.tjy.domian.*;
import com.tjy.domian.Class;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent(StudentInfo studentInfo);

    List<Course> getCourseByid(List<Integer> list);

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
}
