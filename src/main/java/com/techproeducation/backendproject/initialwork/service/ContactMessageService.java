package com.techproeducation.backendproject.initialwork.service;

import com.techproeducation.backendproject.initialwork.dto.ContactMessageDto;
import com.techproeducation.backendproject.initialwork.entity.ContactMessageEntity;
import com.techproeducation.backendproject.initialwork.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public abstract class ContactMessageService {

    @Autowired
    private ContactMessageRepository repository;

    public ContactMessageEntity createContactMessage(ContactMessageEntity contactMessageEntity) {
        return repository.save(contactMessageEntity);
    }
}
