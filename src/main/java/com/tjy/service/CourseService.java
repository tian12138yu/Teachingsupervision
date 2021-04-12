package com.tjy.service;

import com.tjy.domian.Course;
import com.tjy.domian.CourseInfo;
import com.tjy.domian.CourseParam;

import java.util.List;

public interface CourseService {

    Course getCidByName(String cname);

    int getCourseCounts(CourseInfo courseInfo);

    List<Course> getCourseList(CourseInfo courseInfo);

    void addCourse(Course course);

    List<CourseParam> getCourseMap();
}
