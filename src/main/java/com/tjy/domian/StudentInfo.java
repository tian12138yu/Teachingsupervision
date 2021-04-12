package com.tjy.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentInfo {
    private Integer cid;
    private String name;
    private Integer sid;
    private String department;
    private String major;
    private int pageNum = 1;
    private int pageSize = 5;
    private int pageStart;
}
