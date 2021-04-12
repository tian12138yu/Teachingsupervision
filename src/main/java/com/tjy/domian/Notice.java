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
public class Notice {

    private Integer id;
    private String message;
    private int type;
    private String time;
    private String peopleName;
    private Integer state;
    //0未读1已读
}
