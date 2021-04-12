package com.tjy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentTree {

    private String name;
    private List<String> major;
}
