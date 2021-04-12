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
public class Message {

    private Integer id;
    private String operter;
    private String message;
    private String influenceType;
    private String people;
    private String time;


}
