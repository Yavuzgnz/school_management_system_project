package com.techproeducation.backendproject.initialwork.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "Name", nullable = false)
    @NotNull(message = "Name cannot be empty")
    String name;
    @Column(name = "Email", nullable = false)
    @Email
    @NotNull(message = "Email cannot be empty")
    String email;
    @Column(name = "Subject", nullable = false)
    @NotNull(message = "Subject cannot be empty")
    String subject;
    @Column(name = "Message", nullable = false)
    @NotNull(message = "Message cannot be empty")
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
