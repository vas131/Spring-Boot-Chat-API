package com.myk.chat.chatApi.repositories;

import com.myk.chat.chatApi.models.Messages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MessagesRep extends MongoRepository<Messages, String> {


    List<Messages> findByCID(Integer conversationID);

    List<Messages> findByCToken(String cToken);

    // Repository
    @Query(value = "{cToken: ?0}")
    Page<Messages> findByCToken(String name, Pageable pageable);

    @Query(value = "{uniqueID: ?0}")
    List<Messages> deleteByUniqueID(String uniqueID);

}
