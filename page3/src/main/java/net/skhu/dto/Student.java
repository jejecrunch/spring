package net.skhu.dto;

import lombok.Data;

@Data
public class Student {
    int id;
    String studentNo;
    String name;
    int departmentId;
    String sex;
    String phone;
    String email;

    String departmentName;
}

