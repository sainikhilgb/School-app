package org.Java.Project.School.app.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Contacts extends BaseEntity {

    private int contactId;

    @NotBlank(message = "Name must not be blank")
    @Size(min=3, message = "Name must be atleast 3 letters ")
    private String name;

    @NotBlank(message = "Mobile Number must not be blank")
    @Pattern(regexp = "(^$ | [0-9]{10})",message = "Mobile number must be 10 digits")
    private String mobileNum;

    @NotBlank(message = "email must not be blank")
    @Email
    private String email;

    @NotBlank(message = "Subject must not be blank")
    @Size(max=100, message = "Subject must be maximum 500 letters ")
    private String subject;

    @NotBlank(message = "Message must not be blank")
    @Size(max=500, message = "Message must be maximum 500 letters ")
    private String message;


    private String status;
}
