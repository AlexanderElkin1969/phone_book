package com.example.phone_book.service;

import com.example.phone_book.entity.Contact;

import java.util.List;

public interface ContactService {

    Contact createContact(Contact contact);
    Contact findContact(Long id);
    Contact updateContact(Contact contact);
    Contact deleteContact(Long id);
    List<Contact> getAll();
    List<Contact> getAllByLastName(String lastName);

}
