package com.tjy.dao;

import com.tjy.domian.MainMenu;
import com.tjy.dto.DepartmentVo;
import com.tjy.dto.ExcellentDto;
import com.tjy.dto.MajorVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    public List<MainMenu> getMainMenus(String role);

    List<DepartmentVo> getAllDepartment();

    List<MajorVo> getMajorByPid(int pid);

    List<ExcellentDto> getExcellent();

    List<Integer> getColumnCount();

    List<Integer> getColumnCountFinish();

    List<Integer> getExcellent1();

    List<Integer> getGood();

    List<Integer> getAverage();

    List<Integer> getPoor();

    List<Integer> getDepartmentNum();
}
