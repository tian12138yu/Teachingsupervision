package com.tjy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author tianjiayu
 * @version 1.0
 * @date 2021/4/13 2:33 下午
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FormDto {
    private List<FormVo> domains;
    private Integer wid;
}
