package com.techproeducation.backendproject.initialwork.service;

import com.techproeducation.backendproject.initialwork.dto.ContactMessageDto;
import com.techproeducation.backendproject.initialwork.entity.ContactMessage;
import com.techproeducation.backendproject.initialwork.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactMessageServiceImpl extends ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    @Autowired
    public ContactMessageServiceImpl(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    @Override
    public ContactMessageDto createContactMessage(ContactMessageDto contactMessageDto) {
        ContactMessage contactMessageEntity = convertToEntity(contactMessageDto);
        contactMessageEntity = contactMessageRepository.save(contactMessageEntity);
        return convertToDto(contactMessageEntity);
    }

    private ContactMessage convertToEntity(ContactMessageDto contactMessageDto) {
        ContactMessage contactMessage = new ContactMessage();
        contactMessage.setName(contactMessageDto.getName());
        contactMessage.setEmail(contactMessageDto.getEmail());
        contactMessage.setSubject(contactMessageDto.getSubject());
        contactMessage.setMessage(contactMessageDto.getMessage());
        // Set other fields if necessary
        return contactMessage;
    }

    private ContactMessageDto convertToDto(ContactMessage contactMessage) {
        ContactMessageDto contactMessageDto = new ContactMessageDto();
        contactMessageDto.setId(contactMessage.getId());
        contactMessageDto.setName(contactMessage.getName());
        contactMessageDto.setEmail(contactMessage.getEmail());
        contactMessageDto.setSubject(contactMessage.getSubject());
        contactMessageDto.setMessage(contactMessage.getMessage());
        // Map other fields if necessary
        return contactMessageDto;
    }
}
