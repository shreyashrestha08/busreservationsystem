// Java Program to Illustrate Creation Of
// Service Interface

package com.blume.busbackend.service;

import com.blume.busbackend.models.EmailDetails;

// Interface
public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
