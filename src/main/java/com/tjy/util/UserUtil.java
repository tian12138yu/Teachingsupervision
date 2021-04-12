package com.tjy.util;

import com.tjy.domian.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
public class UserUtil {

    private static User user;
    public static void setUser(User user) {
        UserUtil.user = user;
    }

    public static User getUser() {
        if (user == null) {
            log.error("当前登录用户为空！！");
            return null;
        }
        return user;
    }
}
