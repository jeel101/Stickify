package com.eazybytes.eazystore.service.impl;

import com.eazybytes.eazystore.constants.ApplicationConstants;
import com.eazybytes.eazystore.dto.ContactRequestDto;
import com.eazybytes.eazystore.dto.ContactResponseDto;
import com.eazybytes.eazystore.entity.Contact;
import com.eazybytes.eazystore.repository.ContactRepository;
import com.eazybytes.eazystore.service.IContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.time.Instant;
//we are injecting something like this
//Controller → Service → Repository

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {
    private final ContactRepository contactRepository;

    @Override
    public boolean saveContact(ContactRequestDto contactRequestDto) {
            Contact contact = transformtoEntity(contactRequestDto);
            contact.setStatus(ApplicationConstants.CONTACT_STATUS_OPEN);
            contactRepository.save(contact);
            return true;
    }

    private Contact transformtoEntity (ContactRequestDto contactRequestDto) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDto, contact);
        return contact;
    }

    public ContactResponseDto tranformToDto(Contact contact) {
        ContactResponseDto contactResponseDto = new ContactResponseDto(
                contact.getId(), contact.getName(), contact.getEmail(), contact.getMobileNumber(),
                contact.getMessage(), contact.getStatus()
        );
        return contactResponseDto;
    }
}
