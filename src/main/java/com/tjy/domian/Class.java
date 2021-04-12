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
public class Class {

    private Integer id;
    private Long cid;
    private String cname;
    private String department;
    private String major;
    private List<Course> courseList;


}
