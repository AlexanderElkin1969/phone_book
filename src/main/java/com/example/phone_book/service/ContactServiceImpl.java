package com.example.phone_book.service;

import com.example.phone_book.entity.Contact;
import com.example.phone_book.repository.ContactRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    private final ContactRepository repository;

    public ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public Contact createContact(Contact contact) {
        Contact newContact = new Contact();
        newContact.setId(0L);
        newContact.setLastName(checkCorrectName(contact.getLastName().trim()));
        newContact.setFirstName(checkCorrectName(contact.getFirstName().trim()));
        newContact.setMiddleName(checkCorrectName(contact.getMiddleName().trim()));
        newContact.setPhone(checkCorrectNumber(contact.getPhone().trim()));
        List<Contact> list = getAllByLastName(newContact.getLastName());
        for (Contact c : list) {
            if (c.equals(newContact)) return c;
        }
        return repository.save(newContact);
    }

    @Override
    public Contact findContact(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    @Override
    public Contact updateContact(Contact contact) {
        Contact updateContact = new Contact();
        updateContact.setId(contact.getId());
        updateContact.setFirstName(checkCorrectName(contact.getFirstName().trim()));
        updateContact.setLastName(checkCorrectName(contact.getLastName().trim()));
        updateContact.setMiddleName(checkCorrectName(contact.getMiddleName().trim()));
        updateContact.setPhone(checkCorrectNumber(contact.getPhone().trim()));
        return repository.save(updateContact);
    }

    @Transactional
    @Override
    public Contact deleteContact(Long id) {
        Contact contact = repository.findById(id).get();
        repository.deleteById(id);
        return contact;
    }

    public List<Contact> getAllByLastName(String lastName){
        return repository.findAllByLastName(lastName);
    }

    @Override
    public List<Contact> getAll() {
        return repository.findAll();
    }

    // Для упрощения задачи нет проверки на NULL в имени и фамилии и длину не менее 2 букв
    private String checkCorrectName(String name) throws IllegalArgumentException {
        if (StringUtils.isAlpha(name)) {
            return StringUtils.capitalize(name.toLowerCase());
        } else {
            throw new IllegalArgumentException("Фамилия, имя и отчество должны содержать только буквы.");
        }
    }

    // Для упрощения задачи нет проверки на NULL, удаления скобок и + или -, а также замены первой цифры 7 на 8
    private String checkCorrectNumber(String phone) throws IllegalArgumentException {
        if (StringUtils.isNumeric(phone)) {
            return phone;
        } else {
            throw new IllegalArgumentException("Номер телефона должн содержать только цифры.");
        }
    }

}
