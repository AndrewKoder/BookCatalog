package com.example.bookcatalog.service;

import com.example.bookcatalog.model.Book;
import com.example.bookcatalog.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) { this.bookRepository = bookRepository; }

    // получение списка всех книг
    public List<Book> allBooks() { return (List<Book>) bookRepository.findAll(); }

    // сохранение книги в базе данных
    public Book saveBook(Book book) { return bookRepository.save(book); }

    // получение книги по id
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    // удаление книги по id
    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }
}
