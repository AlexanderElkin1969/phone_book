package com.example.phone_book.service;

import com.example.phone_book.entity.Contact;

public interface ContactService {

    Contact createContact(Contact contact);
    Contact findContact(Long id);
    Contact updateContact(Contact contact);
    Contact deleteContact(Long id);

}
