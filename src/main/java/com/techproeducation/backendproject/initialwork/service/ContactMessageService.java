package com.techproeducation.backendproject.initialwork.service;

import com.techproeducation.backendproject.initialwork.dto.ContactMessageDto;
import com.techproeducation.backendproject.initialwork.entity.ContactMessage;
import com.techproeducation.backendproject.initialwork.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public abstract class ContactMessageService {

    @Autowired
    private ContactMessageRepository repository;
    public ContactMessage createContactMessage(ContactMessage contactMessage) {
        return repository.save(contactMessage);
    }

    public abstract ContactMessageDto createContactMessage(ContactMessageDto contactMessageDto);
}
