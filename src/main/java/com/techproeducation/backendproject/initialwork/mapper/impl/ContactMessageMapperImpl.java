package com.techproeducation.backendproject.initialwork.mapper.impl;

import com.techproeducation.backendproject.initialwork.dto.ContactMessageDto;
import com.techproeducation.backendproject.initialwork.entity.ContactMessageEntity;
import com.techproeducation.backendproject.initialwork.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ContactMessageMapperImpl implements Mapper<ContactMessageEntity, ContactMessageDto> {

    private ModelMapper modelMapper;

    public ContactMessageMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ContactMessageDto mapTo(ContactMessageEntity contactMessageEntity) {
        return modelMapper.map(contactMessageEntity, ContactMessageDto.class);
    }

    @Override
    public ContactMessageEntity mapFrom(ContactMessageDto contactMessageDto) {
        return modelMapper.map(contactMessageDto, ContactMessageEntity.class);
    }
}
