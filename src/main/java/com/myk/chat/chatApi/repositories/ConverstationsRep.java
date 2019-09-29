package com.myk.chat.chatApi.repositories;

import com.myk.chat.chatApi.models.Conversations;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ConverstationsRep extends MongoRepository<Conversations, String> {

    List<Conversations> findByChatToken(String chatToken);



}
