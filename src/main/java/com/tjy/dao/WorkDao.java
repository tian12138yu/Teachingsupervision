package com.tjy.dao;

import com.tjy.dto.HistoryDto;
import com.tjy.domian.WeekInfo;
import com.tjy.domian.Work;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkDao {

    int getAllWorkCounts(WeekInfo weekInfo);
    List<Work> getAllWork(WeekInfo weekInfo);
    void addWork(Work work);
    Work getUpdateWork(int id);
    int editWork(Work work);
    int deleteWork(int id);
    int getMyWorkCounts(@Param("wname") String wname,String id);
    List<Work> getMyWork(@Param("wname") String wname,@Param("pageStart") int pageStart, @Param("pageSize") int pageSize,String id);
    void editWorkStatus(Integer wid,Integer id);
    List<Work> getNoWorks(@Param("wname") String wname,@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    int getNoWorksCounts(@Param("wname") String wname);
    void receiveWork(int id, String name);
    void updateWorkStatus(Integer id,Integer userId);
    Work getWorkById(int id);
    int updateWorkTeacher(Work work);


    int getAllWorkNum();

    int getCountEvaluate();

    List<HistoryDto> getHistoryByCname(String cname);
}
