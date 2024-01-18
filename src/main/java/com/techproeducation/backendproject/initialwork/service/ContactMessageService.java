package com.techproeducation.backendproject.initialwork.service;

import com.techproeducation.backendproject.initialwork.entity.ContactMessageEntity;

import java.util.List;

public interface ContactMessageService {

    List<ContactMessageEntity> findAll();

    ContactMessageEntity createContactMessage(ContactMessageEntity contactMessageEntity);


}
