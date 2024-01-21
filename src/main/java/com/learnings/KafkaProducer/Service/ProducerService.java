package com.learnings.KafkaProducer.Service;

import com.learnings.KafkaProducer.Controller.KafkaController;
import com.learnings.KafkaProducer.Model.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class ProducerService {
    Logger logger = LoggerFactory.getLogger(ProducerService.class);
    @Value("spring.kafka.topic")
    String topic;


    @Value("spring.kafka.student-topic")
    String studentTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Student> kafkaStudentTemplate;

    public void sendMessage(String message){
        logger.info("Publishing message -> {message}");
        kafkaTemplate.send(topic,message);
    }

    public void sendStudentMessage(Student studentObject){
        logger.info("Publishing message -> {message}");
        kafkaStudentTemplate.send(studentTopic, studentObject);
    }
}
