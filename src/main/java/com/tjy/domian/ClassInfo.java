package com.tjy.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClassInfo {
    private Long cid;
    private String cname;
    private String department;
    private String major;
    private int pageNum = 1;
    private int pageSize = 5;
    private int pageStart;

}
