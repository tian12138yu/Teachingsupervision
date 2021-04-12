package com.tjy.service.impl;

import com.tjy.dao.WorkDao;
import com.tjy.dto.HistoryDto;
import com.tjy.domian.WeekInfo;
import com.tjy.domian.Work;
import com.tjy.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkDao workDao;
    @Override
    public void addWork(Work work) {
        workDao.addWork(work);
    }

    @Override
    public Work getUpdateWork(int id) {
        return workDao.getUpdateWork(id);
    }

    @Override
    public Work getWorkById(int id) {
        return workDao.getWorkById(id);
    }

    @Override
    public int updateWorkTeacher(Work work) {
        return workDao.updateWorkTeacher(work);
    }

    @Override
    public int editWork(Work work) {
        return workDao.editWork(work);
    }

    @Override
    public int deleteWork(int id) {
        return workDao.deleteWork(id);
    }

    @Override
    public void editWorkStatus(Integer wid, Integer id) {
            workDao.editWorkStatus(wid,id);
    }

    @Override
    public int getNoWorksCounts(String s) {
        return workDao.getNoWorksCounts(s);
    }

    @Override
    public int getAllWorkCounts(WeekInfo weekInfo) {
        return workDao.getAllWorkCounts(weekInfo);
    }

    @Override
    public List<Work> getAllWork(WeekInfo weekInfo) {
        return workDao.getAllWork( weekInfo);
    }

    @Override
    public void receiveWork(Integer id, String name) {
        workDao.receiveWork(id,name);
    }

    @Override
    public void updateWorkStatus(Integer id, Integer userId) {
        workDao.updateWorkStatus(id,userId);
    }

    @Override
    public int getMyWorkCounts(String s, String id) {
        return workDao.getMyWorkCounts(s,id);
    }

    @Override
    public List<Work> getMyWork(String s, int pageStart, int pageSize, String id) {
        return workDao.getMyWork(s,pageStart,pageSize,id);
    }

    @Override
    public List<Work> getNoWorks(String s, int pageStart, int pageSize) {
        return workDao.getNoWorks(s,pageStart,pageSize);
    }

    @Override
    public int getAllWorkNum() {
        return workDao.getAllWorkNum();
    }

    @Override
    public int getCountEvaluate() {
        return workDao.getCountEvaluate();
    }

    @Override
    public List<HistoryDto>  getHistoryByCname(String cname) {
        return workDao.getHistoryByCname(cname);
    }
}
