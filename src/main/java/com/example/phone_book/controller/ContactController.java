package com.example.phone_book.controller;

import com.example.phone_book.entity.Contact;
import com.example.phone_book.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private  final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        return ResponseEntity.ok(service.createContact(contact));
    }

    @GetMapping("{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {
        return ResponseEntity.ok(service.findContact(id));
    }

    @PutMapping
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) {
        return ResponseEntity.ok(service.updateContact(contact));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Contact> deleteContact(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteContact(id));
    }

}
