package com.tjy.controller;

import com.alibaba.fastjson.JSON;
import com.tjy.dao.MenuDao;
import com.tjy.dto.DepartmentTree;
import com.tjy.dto.ExcellentDto;
import com.tjy.dto.InitDto;
import com.tjy.util.ClassTimeUtil;
import com.tjy.util.DepartmentTreeInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InitController {
    @Autowired
    DepartmentTreeInit departmentTreeInit;

    @Autowired
    MenuDao menuDao;

    @CrossOrigin
    @RequestMapping("/init")
    public String init() {
        List<DepartmentTree> departmentTrees =
                departmentTreeInit.initTree();
        List<String> classList = ClassTimeUtil.getClassList();
        return JSON.toJSONString(new InitDto(departmentTrees,classList));
    }

    @CrossOrigin
    @RequestMapping("/getPie")
    public String getPie() {
        List<ExcellentDto> list = menuDao.getExcellent();
        return JSON.toJSONString(list);
    }

    @CrossOrigin
    @RequestMapping("/getColumn")
    public String getColumn() {
        List<Integer> list = menuDao.getColumnCount();
        List<Integer> list1 = menuDao.getColumnCountFinish();
        return JSON.toJSONString(list);
    }

    @CrossOrigin
    @RequestMapping("/getHistogram")
    public String getHistogram() {
        /**
         * 按照学院分组分别查出各个学院最后评价的优良中差评价
         *excellent good average poor
         */
        List<Integer> list = menuDao.getExcellent1();
        List<Integer> list1 = menuDao.getGood();
        List<Integer> list2 = menuDao.getAverage();
        List<Integer> list3 = menuDao.getPoor();
        List<List<Integer>> res = new ArrayList<>();
        res.add(list);
        res.add(list1);
        res.add(list2);
        res.add(list3);
        return JSON.toJSONString(res);
    }

    @CrossOrigin
    @RequestMapping("/getHistogram1")
    public String getHistogram1() {
        List<Integer> list = menuDao.getDepartmentNum();
        return JSON.toJSONString(list);
    }
}
