package com.tjy.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Form {

    private Integer id;
    private Integer wid;
    private String situation;
    private String attendanceRate;
    private String teacherStatus;
    private String departmentname;
    private String majorname;
    private String evaluate;
    private String cid;
    private String createtime;
    private String remarks;



}
