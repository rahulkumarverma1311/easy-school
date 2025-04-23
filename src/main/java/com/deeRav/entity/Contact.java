package com.deeRav.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Contact {
    @NotBlank(message = "NAme must not be blank")
    @Size(min = 3,message = "name must have at least have 3 characters")
    private String name;
    @NotBlank(message = "Mobile number must not be blank")
    @Size(max = 10,message = "mobile number must have 10 digits")
    private String mobileNum;
    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please enter you email id so tha we can contact with you via email")
    private String email;
    @NotBlank(message = "Message can not be blank")
    @Size(min=5,message = "message size must be greater than 4")
    private String subject;
    @NotBlank
    private String message;
}
