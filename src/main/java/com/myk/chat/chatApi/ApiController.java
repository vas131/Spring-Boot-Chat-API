package com.myk.chat.chatApi;

import com.myk.chat.chatApi.configs.SpringMongoConfig;
import com.myk.chat.chatApi.models.Messages;
import com.myk.chat.chatApi.helpers.RandomString;
import com.myk.chat.chatApi.repositories.MessagesRep;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class ApiController {

    //GET VALUE FROM application.properties
    @Value("${access.token}")
    private String accesstoken;



    //loading mongo template
    @Autowired
    MongoTemplate mongoTemplate;

    //conversations repository
    @Autowired
    private MessagesRep messagesRepository;

    //GET THE MESSAGES BY CONVERSATION UNIQUE TOKEN
    @RequestMapping(method = RequestMethod.POST, value="/getMessagesDiscussion")
    public List<Messages> getConvByToken(@RequestBody Map<String, String> body) {
        String convToken = body.get("cToken");

        return messagesRepository.findByCToken(convToken);
    }

    //GET LAST MESSAGE FROM A CONVERSATION
    @RequestMapping(method = RequestMethod.POST, value="/getLastMessage")
    public Messages getLastMessage(@RequestBody Map<String, String> body) {
        String convToken = body.get("cToken");

        PageRequest request = PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "time_created"));
        return messagesRepository.findByCToken(convToken, request).getContent().get(0);

    }


    //ADD A NEW LINE
    @RequestMapping(method = RequestMethod.POST, value="/writeMessage")
    public Messages addConvInMessages(@RequestBody Map<String, String> body) {

        String convToken = body.get("cToken");
        Integer sender = Integer.parseInt(body.get("sender"));
        String message = body.get("message");
        Integer cId = Integer.parseInt(body.get("conversationId"));
        Date date = new Date();
        String uniqueId = new RandomString().generateRandomString(64);


//        addMessage.setcToken(convToken);
//        addMessage.setSender(sender);
//        addMessage.setMessage(message);
//        addMessage.setConversationID(cId);
//        addMessage.setTime_created(date);

        Messages addMessage = new Messages(sender, message, date, cId, convToken, uniqueId);

        return messagesRepository.save(addMessage);

    }

    //DELETE MESSAGE BY UNIQUEID
    @RequestMapping(method = RequestMethod.POST, value="/deleteMessage")
    public ResponseEntity<Object> deleteMessage(@RequestBody Map<String, String> body) {

        String convToken = body.get("cToken");
        String uniqueId = body.get("uniqueID");

       // return messagesRepository.deleteByUniqueID(uniqueId);
        mongoTemplate.remove(Query.query(Criteria.where("uniqueID").is(uniqueId)), Messages.class);


        JSONObject result = new JSONObject();
            result.put("status", "ok");
            result.put("errorCode", null);
            return new ResponseEntity<Object>(result, HttpStatus.OK);

    }



}
