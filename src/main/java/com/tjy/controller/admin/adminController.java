package com.tjy.controller.admin;

import com.alibaba.fastjson.JSON;
import com.tjy.dao.AdminDao;
import com.tjy.dao.UserDao;
import com.tjy.domian.*;
import com.tjy.service.CourseService;
import com.tjy.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class adminController {
    @Autowired
    AdminDao adminDao;

    @Autowired
    UserDao userDao;

    @Autowired
    WorkService workService;

    @Autowired
    CourseService courseService;

    @CrossOrigin
    @GetMapping("/getAllWorks")
    public String getAllWork(WeekInfo weekInfo) {
        System.out.println(weekInfo);
        int numbers = workService.getAllWorkCounts(weekInfo);
        int pageStart = (weekInfo.getPageNum()-1)*weekInfo.getPageSize();
        weekInfo.setPageStart(pageStart);
        List<Work> works = workService.getAllWork(weekInfo);
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",works);
        System.out.println("总条数："+numbers);
        return JSON.toJSONString(res);
    }

    @CrossOrigin
    @PostMapping("/addWorks")
    public String addWork(@RequestBody Work work) {
        System.out.println(work);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = ft.format(new Date());
        work.setCreatime(format);
        if (work.getOwnerName() != null && !"".equals(work.getOwnerName())) {
            work.setIsfinished(0);
        }
        Course cidByName = courseService.getCidByName(work.getCname());
        String tid = cidByName.getTid();
        if (work.getOwnerName().equals(tid)) {
            return "代课老师和听课老师不能为同一个人！";
        }
        work.setTname(tid);
        try {
            workService.addWork(work);
        }catch (Exception e) {
            System.out.println(e);
            return "fail";
        }

        return "success";
    }

    @RequestMapping("/getWorkUpdate")
    public String getUpdateUser(int id){
        System.out.println("编号:"+id);
        Work work = workService.getUpdateWork(id);
        return JSON.toJSONString(work);
    }

    @RequestMapping("/getWorkById")
    public String getWorkById(int id){
        System.out.println("编号:"+id);
        Work work = workService.getWorkById(id);
        return JSON.toJSONString(work);
    }

    @RequestMapping("/updateWorkTeacher")
    public String updateWorkTeacher(@RequestBody Work work){
        System.out.println("更新work听课老师:"+work);
        int i  = workService.updateWorkTeacher(work);
        String str = i >0?"success":"error";
        return str;
    }



    @RequestMapping("/editWork")
    public String editWork(@RequestBody Work work){
        System.out.println(work);
        int userIdByName = userDao.getUserIdByName(work.getOwnerName());
        work.setTid(userIdByName+"");
        int i = workService.editWork(work);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/deleteWork")
    public String deleteWork(int id){
        System.out.println(id);
        int i = workService.deleteWork(id);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/getForm")
    public String getForm(int id){
        System.out.println("编号:"+id);
        Form form = adminDao.getForm(id);
        return JSON.toJSONString(form);
    }

    @RequestMapping("/editForm")
    public String editForm(@RequestBody Form form){
        System.out.println("form:"+form);
        form.setId(form.getWid());
        if (form.getCreatetime() == null || "".equals(form.getCreatetime())) {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = ft.format(new Date());
            form.setCreatetime(format);
        }
        try {
            workService.editWorkStatus(form.getWid(),form.getId());
            adminDao.editForm(form);
        }catch (Exception e) {
            System.out.println(e);
            return "fail";
        }

        return "success";
    }

    @CrossOrigin
    @GetMapping("/getCourseList")
    public String getCourseList(CourseInfo courseInfo) {
        System.out.println(courseInfo);
        int numbers = courseService.getCourseCounts(courseInfo);
        int pageStart = (courseInfo.getPageNum()-1)*courseInfo.getPageSize();
        courseInfo.setPageStart(pageStart);
        List<Course> works = courseService.getCourseList(courseInfo);
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",works);
        System.out.println("总条数："+numbers);
        return JSON.toJSONString(res);
    }


    @CrossOrigin
    @PostMapping("/addCourse")
    public String addCourse(@RequestBody Course course) {
        System.out.println(course);
        try {
            courseService.addCourse(course);
        }catch (Exception e){
            System.out.println(e.toString());
            return "fail";
        }
        return "success";
    }


    @CrossOrigin
    @GetMapping("/getNoWorks")
    public String getNoWorks(QueryInfo queryInfo) {
        System.out.println(queryInfo);
        int numbers = workService.getNoWorksCounts("%"+queryInfo.getQuery()+"%");
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<Work> works = workService.getNoWorks("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",works);
        System.out.println("总条数："+numbers);
        return JSON.toJSONString(res);
    }

    @CrossOrigin
    @GetMapping("/getCourseMap")
    public String getCourseMap() {
        List<CourseParam> courseMap = courseService.getCourseMap();

        return JSON.toJSONString(courseMap);
    }

    @CrossOrigin
    @GetMapping("/getCidByName")
    public String getCidByName(String val) {
        Course course = courseService.getCidByName(val);
        System.out.println(course);
        return JSON.toJSONString(course);
    }


    @CrossOrigin
    @GetMapping("/getTeacherList")
    public String getTeacherList() {
        List<String> al= adminDao.getTeacherList();
        System.out.println(al);
        return JSON.toJSONString(al);
    }


    @CrossOrigin
    @GetMapping("/getidByName")
    public String getidByName(String val) {
        int id = adminDao.getidByName(val);
        System.out.println(id);
        return JSON.toJSONString(id);
    }




    public static void main(String[] args) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = ft.format(new Date());
        System.out.println(format);
    }
}
