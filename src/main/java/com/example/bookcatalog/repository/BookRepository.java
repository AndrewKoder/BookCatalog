package com.example.bookcatalog.repository;

import com.example.bookcatalog.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
