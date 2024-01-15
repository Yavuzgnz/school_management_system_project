package com.techproeducation.backendproject.initialwork.entity;

import lombok.Data;

import javax.naming.Name;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.security.auth.Subject;
import javax.validation.constraints.Email;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity
@Data
public class ContactMessage {

    @Id
    Long id;
    @Column (name = "Name", nullable = false)
    String name;
    @Column (name = "Email", nullable = false)
    @Email
    String email;
    @Column (name = "Subject", nullable = false)
    String subject;
    @Column (name = "Message", nullable = false)
    String message;

   /* DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm", Locale.US);
    String dateAndTime;
    ZonedDateTime formattedDateAndTime = ZonedDateTime()*/


}
