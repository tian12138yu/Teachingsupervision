package com.tjy.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    /**
     * 学生主键
     */
    private Integer id;

    /**
     * 学生姓名
     */
    private String name;
    /**
     * 学生学号
     */
    private Long sid;
    /**
     * 学生班级号
     */
    private Long cid;
    /**
     * 学生班级名称
     */
    private String cname;
    /**
     * 学生用户名
     */
    private String username;
    /**
     * 学生密码
     */
    private String password;
    /**
     * 学生院系
     */
    private String department;
    /**
     * 学生专业
     */
    private String major;

    /**
     * 学生课程集合
     */
    private List<Course> courseList;

    /**
     * 上次登录时间
     */
    private String lastTime;

    /**
     * 登陆次数
     */
    private Integer loginTimes;
}
