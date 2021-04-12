package com.tjy.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {

    private Integer id;
    private Integer cid;
    private String cname;
    private String tid;
    private String time1;
    private String time2;
    private String time3;
    private String time4;
    private String time5;
    private int start;
    private int end;
    private String departmentname;
    private String majorname;
    private String address;

}
