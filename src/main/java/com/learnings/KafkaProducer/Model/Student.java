package com.learnings.KafkaProducer.Model;

enum SECTION  {
    A,
    B,
    C,
    D
}

public class Student {
    private static int studentId;
    private String name;
    private String grade;
    private SECTION section;
}
