package com.tjy.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
/**
 * @author tianjiayu
 * @version 1.0
 * @date 2021/4/8 2:13 下午
 */
public class HistoryDto {

    private String createtime;
    private String evaluate;

}
