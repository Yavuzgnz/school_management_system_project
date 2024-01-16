package com.techproeducation.backendproject.initialwork.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;
import javax.persistence.*;
import javax.security.auth.Subject;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "Name", nullable = false)
    @NotNull
    String name;
    @Column(name = "Email", nullable = false)
    @Email
    @NotNull
    String email;
    @Column(name = "Subject", nullable = false)
    @NotNull
    String subject;
    @Column(name = "Message", nullable = false)
    @NotNull
    String message;
    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    @NotNull
    LocalDateTime localDateTime;


    @PrePersist
    protected void onCreate() {
        localDateTime = LocalDateTime.now(ZoneId.of("America/New_York"));
    }
}
