package com.techproeducation.backendproject.initialwork.service;

import com.techproeducation.backendproject.initialwork.entity.ContactMessageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ContactMessageService {

    List<ContactMessageEntity> findAll();

    ContactMessageEntity createContactMessage(ContactMessageEntity contactMessageEntity);


    Page<ContactMessageEntity> getAllMessagesPage(int page, int size, String sort, Sort.Direction direction);
}
