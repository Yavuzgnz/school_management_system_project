package com.techproeducation.backendproject.initialwork.controller;

import com.techproeducation.backendproject.initialwork.dto.ContactMessageDto;
import com.techproeducation.backendproject.initialwork.entity.ContactMessageEntity;
import com.techproeducation.backendproject.initialwork.mapper.Mapper;
import com.techproeducation.backendproject.initialwork.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public List<ContactMessageDto> getAllContactMessage() {
        List<ContactMessageEntity> allContactMessage = contactMessageService.findAll();
        return allContactMessage.stream().map(contactMessageMapper::mapTo).collect(Collectors.toList());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ContactMessageDto>> getAllMessages(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sort") String sort,
            @RequestParam("direction")Sort.Direction direction) {
        Page<ContactMessageEntity> contactMessageEntities = contactMessageService.getAllMessagesPage(page, size, sort, direction);
        Page<ContactMessageDto> contactMessageDtos = contactMessageEntities.map(contactMessageMapper::mapTo); // convert entities to DTOs
        return ResponseEntity.ok(contactMessageDtos);
    }

}
