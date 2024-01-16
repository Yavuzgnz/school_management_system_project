package com.techproeducation.backendproject.initialwork.controller;

import com.techproeducation.backendproject.initialwork.dto.ContactMessageDto;
import com.techproeducation.backendproject.initialwork.entity.ContactMessage;
import com.techproeducation.backendproject.initialwork.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactMessage")
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    @Autowired
    public ContactMessageController(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }


    @PostMapping
    public ResponseEntity<ContactMessageDto> createContactMessage(@RequestBody ContactMessageDto contactMessageDto) {
        ContactMessageDto createdContactMessageDto = contactMessageService.createContactMessage(contactMessageDto);
        return ResponseEntity.ok(createdContactMessageDto);
    }

}
