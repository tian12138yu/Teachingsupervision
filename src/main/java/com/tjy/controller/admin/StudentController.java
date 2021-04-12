package com.tjy.controller.admin;

import com.alibaba.fastjson.JSON;

import com.tjy.domian.Class;
import com.tjy.service.StudentService;

import com.tjy.domian.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping("/getAllStudent")
    public String getAllStudent(StudentInfo studentInfo) {
        System.out.println(studentInfo);
        int pageStart = (studentInfo.getPageNum()-1)*studentInfo.getPageSize();
        studentInfo.setPageStart(pageStart);
        List<Student> allStudent = studentService.getAllStudent(studentInfo);
        int count = studentService.getCountStudent(studentInfo);
        for (Student s : allStudent) {
            List<Integer> list = studentService.getCourseidzBycid(s.getCid());
            List<Course> courseByid = studentService.getCourseByid(list);
            s.setCourseList(courseByid);
        }
        HashMap<String, Object> res = new HashMap<>();
        res.put("count",count);
        res.put("data",allStudent);
        return JSON.toJSONString(res);
    }

    @GetMapping("/getClassList")
    public String getClassList() {
        List<Class> list = studentService.getClassList();
        return JSON.toJSONString(list);
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) {
        try {
            studentService.addStudent(student);
        }catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    @GetMapping("/getUpdateStudent")
    public String getUpdateStudent(Long sid ) {
        Student student = studentService.getUpdateStudent(sid);
        return JSON.toJSONString(student);
    }

    @PutMapping("/editStudent")
    public String editStudent(@RequestBody Student student) {
        System.out.println(student);
        try {
            studentService.editStudent(student);
        }catch (Exception e) {

        }
        return "success";

    }

    @DeleteMapping("/deleteStudent")
    public String deleteStudent(Long sid) {
        System.out.println("删除学生sid:"+sid);
        try {
            studentService.deleteStudent(sid);
        }catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    @GetMapping("/getClassListByInfo")
    public String getClassListByInfo(ClassInfo classInfo) {
        System.out.println(classInfo);
        int pageStart = (classInfo.getPageNum()-1)*classInfo.getPageSize();
        classInfo.setPageStart(pageStart);
        List<Class> classList = studentService.getClassListByInfo(classInfo);
        int count = studentService.getClassListCount(classInfo);
        for (Class c : classList) {
            List<Integer> list = studentService.getCourseidzBycid(c.getCid());
            List<Course> courseByid = studentService.getCourseByid(list);
            c.setCourseList(courseByid);
        }
        HashMap<String, Object> res = new HashMap<>();
        res.put("count",count);
        res.put("data",classList);
        return JSON.toJSONString(res);
    }

    @PostMapping("/addClass")

    public String addClass(@RequestBody Class c) {
        System.out.println(c);
        try {
            studentService.addClass(c);
        }catch (Exception e) {

        }

        return "success";
    }

    @GetMapping("/getCourseWithout")
    public String getCourseWithout(Long cid) {
        List<Integer> list = studentService.getCouseIdWithoutCid(cid);
        List<Course> courseByid = studentService.getNoCourseByList(list);
        return JSON.toJSONString(courseByid);
    }


    @GetMapping("/insertClassCourse")
    public String insertClassCourse(Long courseId,Long classId) {
        try {
            studentService.insertClassCourse(courseId,classId);
        }catch (Exception e) {
            System.out.println(e);
            return "fail";
        }
        return "success";
    }

    @GetMapping("/getStudentCourse")
    public String getStudentCourse(Integer id) {
        log.info("getStudentCourse param :{}",id );
        Student s = studentService.getStudentCourseById(id);
        if (s == null) {
            return "fair";
        }
        List<Integer> courseidzBycid = studentService.getCourseidzBycid(s.getCid());
        List<Course> courseByid = studentService.getCourseByid(courseidzBycid);
        return JSON.toJSONString(courseByid);
    }

}
