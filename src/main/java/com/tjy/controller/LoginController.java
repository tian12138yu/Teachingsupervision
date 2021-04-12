package com.tjy.controller;
import com.alibaba.fastjson.JSON;
import com.tjy.dao.StudentDao;
import com.tjy.domian.Student;
import com.tjy.domian.User;
import com.tjy.dao.UserDao;
import com.tjy.domian.WeekInfo;
import com.tjy.dto.HomeParamDto;
import com.tjy.service.WorkService;
import com.tjy.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    UserDao userDao;
    @Autowired
    WorkService workService;
    @Autowired
    StudentDao studentDao;
    @CrossOrigin
    @RequestMapping("/login")
    public String userLogin(@RequestBody User user) {
        System.out.println("User : " + user);
        log.info("login param:{}",user);
        User user1;
        if ("3".equals(user.getRole())) {
            Student student = userDao.getStudent(user.getUsername(), user.getPassword());
            user1 = new User();
            user1.setRole("3");
            user1.setState(true);
            if (student!= null && student.getUsername() != null && !"".equals(student.getUsername())) {
                user1.setUsername(student.getUsername());
                user1.setPassword(student.getPassword());
                user1.setName(student.getName());
                user1.setId(student.getId());
                user1.setLoginTimes(student.getLoginTimes());
                user1.setLastTime(student.getLastTime());
                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String format = ft.format(new Date());
                student.setLastTime(format);
                student.setLoginTimes(student.getLoginTimes() + 1);
                try {
                    studentDao.updateStudent(student);
                }catch (Exception e) {
                    log.error("更新学生登录信息失败!{}",e.toString());
                    return "更新学生登录信息失败";
                }
            }else {
                return "fail";
            }
        }else {
            user1 = userDao.getUserByMassage(user.getUsername(), user.getPassword());
            if (user1 != null) {
                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String format = ft.format(new Date());
                user1.setLastTime(format);
                user1.setLoginTimes(user1.getLoginTimes() + 1);
                userDao.updateUser(user1);
                UserUtil.setUser(user1);
            }

        }

        if (user1 == null || !user1.isState() || user1.getName() == null || !user1.getRole().equals(user.getRole())) {
            return "fail";
        }

        return JSON.toJSONString(user1);
    }

    @CrossOrigin
    @RequestMapping("/getParam")
    public String getParam() {
        HomeParamDto homeParamDto = new HomeParamDto();
        try {
            int countUserLogin = userDao.getCountUserLogin();
            int countWork = workService.getAllWorkNum();
            int countEvaluate = workService.getCountEvaluate();
            homeParamDto.setCountEvaluate(countEvaluate);
            homeParamDto.setCountLoginTimes(countUserLogin);
            homeParamDto.setCountWork(countWork);
        }catch (Exception e) {
            log.error("获取首页信息失败！{}",e.toString());
        }
        return JSON.toJSONString(homeParamDto);
    }
}
