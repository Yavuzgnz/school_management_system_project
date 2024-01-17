package com.techproeducation.backendproject.initialwork.controller;

import com.techproeducation.backendproject.initialwork.dto.ContactMessageDto;
import com.techproeducation.backendproject.initialwork.entity.ContactMessageEntity;
import com.techproeducation.backendproject.initialwork.mapper.Mapper;
import com.techproeducation.backendproject.initialwork.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contactMessage")
public class ContactMessageController {

    private final ContactMessageService contactMessageService;
    private Mapper<ContactMessageEntity, ContactMessageDto> contactMessageMapper;

    @Autowired
    public ContactMessageController(ContactMessageService contactMessageService,
                                    Mapper<ContactMessageEntity, ContactMessageDto> contactMessageMapper) {
        this.contactMessageService = contactMessageService;
        this.contactMessageMapper = contactMessageMapper;
    }


    @PostMapping
    public ResponseEntity<ContactMessageDto> createContactMessage(@RequestBody ContactMessageDto contactMessageDto) {
        ContactMessageEntity contactMessageEntity = contactMessageMapper.mapFrom(contactMessageDto);
        ContactMessageEntity savedContactMessageEntity = contactMessageService.createContactMessage(contactMessageEntity);
        return ResponseEntity.ok(contactMessageMapper.mapTo(savedContactMessageEntity));
    }

}
