package com.example.phone_book.service;

import com.example.phone_book.entity.Contact;
import com.example.phone_book.repository.ContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactServiceImpl implements ContactService{

    private final ContactRepository repository;

    public ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public Contact createContact(Contact contact) {
        contact.setId(0L);
        return repository.save(contact);
    }

    @Override
    public Contact findContact(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    @Override
    public Contact updateContact(Contact contact) {
        return repository.save(contact);
    }

    @Transactional
    @Override
    public Contact deleteContact(Long id) {
        Contact contact = repository.findById(id).get();
        repository.deleteById(id);
        return contact;
    }

}
