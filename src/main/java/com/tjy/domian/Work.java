package com.tjy.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Work {

    private Integer id;
    private String wname;
    private String time;
    private String tid;//听课教师
    private String tname;//代课教师
    private int cid;
    private String creatime;
    private int formid;
    private int isfinished;
    private String cname;
    private String ownerName;//听课老师名
    private String address;
    private String week;//周次


}
