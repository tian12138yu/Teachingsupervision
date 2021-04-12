package com.tjy.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeekInfo {

    /**
     *  任务简称
     */
    private String wname;
    /**
     * 代课老师
     */
    private String tname;
    /**
     * 任务拥有哲
     */
    private String ownerName;
    /**
     * 课程名
     */
    private String cname;
    /**
     * 课程号
     */
    private String cid;
    /**
     * 上课周
     */
    private String week;
    /**
     * 所属老师ID
     */
    private Integer tid;

    /**
     * 是否完成
     */
    private Integer isfinished;

    private int pageNum = 1;
    private int pageSize = 5;
    private int pageStart;

}
