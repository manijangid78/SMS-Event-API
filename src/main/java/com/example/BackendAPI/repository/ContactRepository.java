package com.example.BackendAPI.repository;

import com.example.BackendAPI.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface ContactRepository extends JpaRepository<Contact,Integer> {

    @Transactional
    long deleteByEventId(String eventId);

}
