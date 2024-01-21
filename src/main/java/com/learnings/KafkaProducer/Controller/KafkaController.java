package com.learnings.KafkaProducer.Controller;

import com.learnings.KafkaProducer.Model.Student;
import com.learnings.KafkaProducer.Service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/kafka/api")
public class KafkaController {

    Logger logger = LoggerFactory.getLogger(KafkaController.class);
    @Autowired
    private ProducerService producerService;

    @GetMapping("publish")
    public String sendMessageToKafkaTopic(@RequestParam String message){
        logger.info("publishing message: " + message + "to topic : message-topic");
        producerService.sendMessage(message);
        return "Successfully published Message !";
    }

    @PostMapping("publish")
    public Map<String, Object> sendMessageToKafkaTopic(@RequestBody Student student){
        logger.info("publishing message: " + student + "to topic : student-topic" );
        producerService.sendStudentMessage(student);
        Map<String , Object> map = new HashMap<>();
        map.put("message", "Successfully published Message !");
        map.put("payload", student);
        return map;
    }
}
