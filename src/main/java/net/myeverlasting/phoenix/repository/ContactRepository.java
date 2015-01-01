package net.myeverlasting.phoenix.repository;

import net.myeverlasting.phoenix.model.Contact;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Integer> {
    Page<Contact> findByNameLike(Pageable pageable, String name);
}
