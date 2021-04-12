package com.tjy.controller;


import com.alibaba.fastjson.JSON;
import com.tjy.domian.Message;
import com.tjy.domian.User;
import com.tjy.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MessageController {

    @Autowired
    MessageService messageService;
    @RequestMapping("getMessage")
    public String getMessage(@RequestBody User user) {
        if (user == null) {
            return "用户为空！！";
        }
        Message message = messageService.getMessage(user);
        return JSON.toJSONString(message);
    }
}
