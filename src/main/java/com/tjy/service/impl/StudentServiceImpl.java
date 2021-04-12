package com.tjy.service.impl;


import com.tjy.dao.StudentDao;
import com.tjy.domian.*;
import com.tjy.service.StudentService;
import com.tjy.domian.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl  implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> getAllStudent(StudentInfo studentInfo) {
       return studentDao.getAllStudent(studentInfo);
    }

    @Override
    public List<Course> getCourseByid(List<Integer> list) {
        return studentDao.getCourseByid(list);
    }

    @Override
    public int getCountStudent(StudentInfo studentInfo) {
        return studentDao.getCountStudent(studentInfo);
    }

    @Override
    public List<Class> getClassList() {
        return studentDao.getClassList();
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public Student getUpdateStudent(Long sid) {

        return studentDao.getUpdateStudent(sid);
    }

    @Override
    public void editStudent(Student student) {
        studentDao.editStudent(student);
    }

    @Override
    public void deleteStudent(Long sid) {
        studentDao.deleteStudent(sid);
    }

    @Override
    public List<Integer> getCourseidzBycid(Long cid) {
        return studentDao.getCourseidzBycid(cid);
    }

    @Override
    public List<Class> getClassListByInfo(ClassInfo classInfo) {
        return studentDao.getClassListByInfo(classInfo);
    }

    @Override
    public int getClassListCount(ClassInfo classInfo) {
        return studentDao.getClassListCount(classInfo);
    }

    @Override
    public void addClass(Class c) {
        studentDao.addClass(c);
    }

    @Override
    public List<Integer> getCouseIdWithoutCid(Long cid) {
        return studentDao.getCouseIdWithoutCid(cid);
    }

    @Override
    public void insertClassCourse(Long courseId, Long classId) {
        studentDao.insertClassCourse(courseId,classId);
    }

    @Override
    public List<Course> getNoCourseByList(List<Integer> list) {
        return studentDao.getNoCourseByList(list);
    }

    @Override
    public Student getStudentCourseById(Integer id) {
        return studentDao.getStudentCourseById(id);
    }

}
