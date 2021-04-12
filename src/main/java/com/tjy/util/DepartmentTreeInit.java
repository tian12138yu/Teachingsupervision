package com.tjy.util;

import com.tjy.dao.MenuDao;
import com.tjy.dto.DepartmentVo;
import com.tjy.dto.DepartmentTree;
import com.tjy.dto.MajorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DepartmentTreeInit {

    public static List<DepartmentTree> departmentTrees;

    @Autowired
    MenuDao menuDao;
    public  List<DepartmentTree> initTree() {
        departmentTrees = new ArrayList<>();
        List<DepartmentVo> allDepartment = menuDao.getAllDepartment();
        for (DepartmentVo departmentVo : allDepartment) {
            DepartmentTree departmentTree = new DepartmentTree();
            departmentTree.setName(departmentVo.getName());
            List<MajorVo> majorByPid = menuDao.getMajorByPid(departmentVo.getId());
            List<String> list = new ArrayList<>();
            for (MajorVo majorVo : majorByPid) {
                list.add(majorVo.getName());
            }
            departmentTree.setMajor(list);
            departmentTrees.add(departmentTree);
        }
        return departmentTrees;
    }
}
