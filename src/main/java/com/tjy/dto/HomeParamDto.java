package com.tjy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HomeParamDto {

    /**
     * 总登录次数
     */
    private Integer countLoginTimes;
    /**
     * 总评价数
     */
    private Integer countEvaluate;
    /**
     * 总任务数
     */
    private Integer countWork;
}
