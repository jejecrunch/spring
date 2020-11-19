package net.skhu.dto;

import lombok.Data;

@Data
public class Student {
    int id;
    String StudentNumber;
    String name;
    int departmentId;
    int year;
    String departmentName;
}

