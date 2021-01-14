package net.skhu.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserRegistration {

    @NotEmpty @NotBlank
    @Size(min=3, max=12)
    String userid;

    @NotEmpty
    @Size(min=6, max=12)
    String passwd1;

    String passwd2;

    @NotEmpty @NotBlank
    @Size(min=2, max=30)
    String name;

    @NotEmpty
    @Email
    String email;

    Integer departmentId;
}

