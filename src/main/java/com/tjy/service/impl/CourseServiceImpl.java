package com.tjy.service.impl;

import com.tjy.dao.AdminDao;
import com.tjy.domian.Course;
import com.tjy.domian.CourseInfo;
import com.tjy.domian.CourseParam;
import com.tjy.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    AdminDao adminDao;
    @Override
    public Course getCidByName(String cname) {
        return adminDao.getCidByName(cname);
    }

    @Override
    public int getCourseCounts(CourseInfo courseInfo) {
        return adminDao.getCourseCounts(courseInfo);
    }

    @Override
    public List<Course> getCourseList(CourseInfo courseInfo) {
        return adminDao.getCourseList(courseInfo);
    }

    @Override
    public void addCourse(Course course) {
        adminDao.addCourse(course);
    }

    @Override
    public List<CourseParam> getCourseMap() {
        return adminDao.getCourseMap();
    }
}
