package com.tjy.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String phone;
    private String role;
    private boolean state;
    private String name;
    private String department;
    private String lastTime;
    private Integer loginTimes;


}
