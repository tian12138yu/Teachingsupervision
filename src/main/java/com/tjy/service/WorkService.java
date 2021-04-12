package com.tjy.service;

import com.tjy.dto.HistoryDto;
import com.tjy.domian.WeekInfo;
import com.tjy.domian.Work;

import java.util.List;

public interface WorkService {

    void addWork(Work work);

    Work getUpdateWork(int id);

    Work getWorkById(int id);

    int updateWorkTeacher(Work work);

    int editWork(Work work);

    int deleteWork(int id);

    void editWorkStatus(Integer wid, Integer id);

    int getNoWorksCounts(String s);

    int getAllWorkCounts(WeekInfo weekInfo);

    List<Work> getAllWork(WeekInfo weekInfo);

    void receiveWork(Integer id, String name);

    void updateWorkStatus(Integer id, Integer userId);

    int getMyWorkCounts(String s, String id);

    List<Work> getMyWork(String s, int pageStart, int pageSize, String id);

    List<Work> getNoWorks(String s, int pageStart, int pageSize);

    int getAllWorkNum();

    int getCountEvaluate();

    List<HistoryDto>  getHistoryByCname(String cname);
}
