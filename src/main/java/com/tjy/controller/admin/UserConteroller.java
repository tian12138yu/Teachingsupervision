package com.tjy.controller.admin;

import com.alibaba.fastjson.JSON;
import com.tjy.domian.Notice;
import com.tjy.domian.QueryInfo;
import com.tjy.domian.User;
import com.tjy.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
public class UserConteroller {
    
    @Autowired
    UserDao userDao;

    @CrossOrigin
    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = userDao.getUserCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<User> users = userDao.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        System.out.println("总条数："+numbers);
        String users_json = JSON.toJSONString(res);
        return users_json;
    }

    @RequestMapping("/userState")
    public String updateUserState(@RequestParam("id") Integer  id,
                                  @RequestParam("state") Boolean state){
        int i = userDao.updateState(id, state);
        System.out.println("用户编号:"+id);
        System.out.println("用户状态:"+state);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        System.out.println(user);
        user.setState(false);
        int i = userDao.addUser(user);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/getUpdate")
    public String getUpdateUser(int id){
        System.out.println("编号:"+id);
        User updateUser = userDao.getUpdateUser(id);
        String users_json = JSON.toJSONString(updateUser);
        return users_json;
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user){
        System.out.println(user);
        int i = userDao.editUser(user);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        System.out.println(id);
        int i = userDao.deleteUser(id);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/getNotice")
    public String getNotice(@RequestBody User user){
        if (user.getRole().equals("1")) {
            user.setName(null);
        }
        List<Notice> notices = userDao.getNotice(user);
        List<Notice> notices1 = new ArrayList<>();
        if(user.getRole().equals("0")) {
            user.setRole("5");
            user.setName(null);
            notices1 = userDao.getNotice(user);
        }
        notices.addAll(notices1);
        return JSON.toJSONString(notices);
    }

    @GetMapping("updateNotice")
    public String updateNotice(Integer id){
        if (id == null){
            return "通知ID为空！";
        }
        try {
            userDao.updateNoticeById(id);
        }catch (Exception e) {
            log.error("更改通知状态失败："+e.toString());
        }
        return "Success";
    }

}
