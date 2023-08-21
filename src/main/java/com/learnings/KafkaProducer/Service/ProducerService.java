package com.learnings.KafkaProducer.Service;

import com.learnings.KafkaProducer.Model.Student;
import io.micrometer.common.util.internal.logging.Slf4JLoggerFactory;
import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ProducerService {
    private final Logger logger = (Logger) LoggerFactory.getLogger(Slf4JLoggerFactory.class);

    @Value("${spring.kafka.topic}")
    private String topic;

    @Value("${spring.kafka.student-topic}")
    private String studentTopic;

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
