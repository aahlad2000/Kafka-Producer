package com.learnings.KafkaProducer.Controller;

import com.learnings.KafkaProducer.Model.Student;
import com.learnings.KafkaProducer.Service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/kafka/api")
public class KafkaController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("publish")
    public String sendMessageToKafkaTopic(@RequestParam String message){
        producerService.sendMessage(message);
        return "Successfully published Message !";
    }

    @PostMapping("publish")
    public Map<String, Object> sendMessageToKafkaTopic(@RequestBody Student student){
        producerService.sendStudentMessage(student);
        Map<String , Object> map = new HashMap<>();
        map.put("message", "Successfully published Message !");
        map.put("payload", student);
        return map;
    }
}
