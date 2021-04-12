package com.tjy.controller;

import com.alibaba.fastjson.JSON;
import com.tjy.dao.AdminDao;
import com.tjy.domian.WeekInfo;
import com.tjy.dto.HistoryDto;
import com.tjy.domian.Work;
import com.tjy.domian.QueryInfo;
import com.tjy.service.WorkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@Slf4j
public class TeacherController {

    @Autowired
    AdminDao adminDao;

    @Autowired
    WorkService workService;

    @CrossOrigin
    @GetMapping("/getMyWorks")
    public String getMyWorks( WeekInfo weekInfo) {
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
    @GetMapping("/receiveWork")
    public String receiveWork(Integer id, String name,Integer userId) {
        Work workById = workService.getWorkById(id);
        if (name.equals(workById.getTname())) {
            return "fail,不能领取自己的课程！";
        }
        try {
            workService.receiveWork(id,name);
            workService.updateWorkStatus(id,userId);
        }catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    @CrossOrigin
    @GetMapping("/getHistory")
    public String getHistory(String cname) {
        log.info("getHistory param is :{}",cname);
        if (cname == null || cname.equals("")) {
            return "课程名不能为空！";
        }
        List<HistoryDto> historyDto = workService.getHistoryByCname(cname);
        return JSON.toJSONString(historyDto);
    }


}
