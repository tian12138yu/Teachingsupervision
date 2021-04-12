package com.tjy.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseInfo {
    private Integer cid;
    private String cname;
    private String tid;
    private String departmentname;
    private String majorname;
    private int pageNum = 1;
    private int pageSize = 5;
    private int pageStart;

}
