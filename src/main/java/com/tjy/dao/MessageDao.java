package com.tjy.dao;

import com.tjy.domian.Message;
import com.tjy.domian.User;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDao {
    Message getMessage(User user);
}
