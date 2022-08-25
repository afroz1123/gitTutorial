package com.example.demo.controller;

import com.example.demo.Entity.EmailDetails;
import com.example.demo.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    /**
     * added email controller
     * @param emailDetails
     * @return
     */

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody EmailDetails emailDetails)
    {
        return emailService.simpleMail(emailDetails);
    }
}
