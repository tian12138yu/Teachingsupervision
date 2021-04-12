package com.tjy.dao;

import com.tjy.domian.Course;
import com.tjy.domian.CourseInfo;
import com.tjy.domian.CourseParam;
import com.tjy.domian.Form;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {

     int getCourseCounts(CourseInfo courseInfo);

     Form getForm(int id);

     List<Course> getCourseList(CourseInfo courseInfo);

     void addCourse(Course course);

     void editForm(Form form);

     List<CourseParam> getCourseMap();

     Course getCidByName(String val);

     List<String> getTeacherList();

     int getidByName(String val);

}
