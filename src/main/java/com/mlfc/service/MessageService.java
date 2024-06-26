package com.mlfc.service;

import com.mlfc.entity.Message;

import java.util.List;

public interface MessageService {
    List<Message> userList();

    void addUserMessage(Integer userId, Message message);

    List<Message> rootList();

    Message announcement();

    void deleteRootMessage(Integer id);

    void addRootMessage(Message message, Integer root_id);

    void deleteUserMessage(Integer id);
}
