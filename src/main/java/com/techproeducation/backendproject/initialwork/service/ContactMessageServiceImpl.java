package com.techproeducation.backendproject.initialwork.service;

import com.techproeducation.backendproject.initialwork.dto.ContactMessageDto;
import com.techproeducation.backendproject.initialwork.entity.ContactMessageEntity;
import com.techproeducation.backendproject.initialwork.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactMessageServiceImpl extends ContactMessageService {

    @Autowired
    private final ContactMessageRepository contactMessageRepository;


    @Autowired
    public ContactMessageServiceImpl(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    public ContactMessageEntity createContactMessage(ContactMessageEntity contactMessageEntity) {
        return contactMessageRepository.save(contactMessageEntity);


    // manual DTO but I used ModelMapper
    /*@Override
    public ContactMessageDto createContactMessage(ContactMessageDto contactMessageDto) {
        ContactMessageEntity contactMessageEntity = convertToEntity(contactMessageDto);
        contactMessageEntity = contactMessageRepository.save(contactMessageEntity);
        return convertToDto(contactMessageEntity);
    }

    private ContactMessageEntity convertToEntity(ContactMessageDto contactMessageDto) {
        ContactMessageEntity contactMessageEntity = new ContactMessageEntity();
        contactMessageEntity.setName(contactMessageDto.getName());
        contactMessageEntity.setEmail(contactMessageDto.getEmail());
        contactMessageEntity.setSubject(contactMessageDto.getSubject());
        contactMessageEntity.setMessage(contactMessageDto.getMessage());
        // Set other fields if necessary
        return contactMessageEntity;
    }

    private ContactMessageDto convertToDto(ContactMessageEntity contactMessageEntity) {
        ContactMessageDto contactMessageDto = new ContactMessageDto();
        contactMessageDto.setId(contactMessageEntity.getId());
        contactMessageDto.setName(contactMessageEntity.getName());
        contactMessageDto.setEmail(contactMessageEntity.getEmail());
        contactMessageDto.setSubject(contactMessageEntity.getSubject());
        contactMessageDto.setMessage(contactMessageEntity.getMessage());
        // Map other fields if necessary
        return contactMessageDto;
    }*/
}
