package com.tjy.service.impl;

import com.tjy.dao.MessageDao;
import com.tjy.domian.Message;
import com.tjy.domian.User;
import com.tjy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageDao messageDao;
    @Override
    public Message getMessage(User user) {
        return messageDao.getMessage(user);
    }
}
