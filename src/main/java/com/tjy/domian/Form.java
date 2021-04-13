package com.tjy.domian;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Form {

    private Integer id;
    private Integer wid;
    private String departmentname;
    private String cid;
    private String createtime;

    private String entry1;
    private String entry2;
    private String entry3;
    private String entry4;
    private String entry5;
    private String entry6;
    private String entry7;
    private String entry8;
    private String entry9;

    private Integer evaluate1;
    private Integer evaluate2;
    private Integer evaluate3;
    private Integer evaluate4;
    private Integer evaluate5;
    private Integer evaluate6;
    private Integer evaluate7;
    private Integer evaluate8;
    private Integer evaluate9;

    private Integer summary;
    private String remarks;
}
