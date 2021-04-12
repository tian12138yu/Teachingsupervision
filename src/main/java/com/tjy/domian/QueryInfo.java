package com.tjy.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QueryInfo {
    private String id;
    private String query;
    private int pageNum = 1;
    private int pageSize = 5;
}
