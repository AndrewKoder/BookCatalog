package com.example.bookcatalog.controller;

import com.example.bookcatalog.model.Book;
import com.example.bookcatalog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) { this.bookService = bookService; }

    // получение страницы со списком всех книг
    @GetMapping("/")
    public String showAllBooks(Model model) {
        List<Book> bookList = bookService.allBooks();
        model.addAttribute("bookList", bookList);
        return "book-list";
    }
    // получение формы для добавления книги
    @GetMapping("/add-book")
    public String newBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book-create";
    }

    // обработчик для сохранения данных о книге
    @PostMapping("/add-book")
    public String saveNewBook(Book book, RedirectAttributes redirectAttributes) {
        // сохраняем новую книгу в базе данных
        Book saved = bookService.saveBook(book);
        // сообщение, что студент добавлен
        redirectAttributes.addFlashAttribute("message", "Книга \"" + saved.getBookTitle() + "\" успешно добавлена!");
        return "redirect:/";
    }

    // обработчик для удаления книги
    @GetMapping("/books/delete/{idBook}")
    public String deleteBook(@PathVariable("idBook") Integer id, RedirectAttributes redirectAttributes) {
        bookService.deleteBookById(id);
        redirectAttributes.addFlashAttribute("message", "Книга под номером " + id + " удалена!");
        return "redirect:/";
    }

    // обработчик для вывода информации о книге
    @GetMapping("/book/{idBook}")
    public String readBook(@PathVariable("idBook") Integer id, Model model) {
        Book bookInfo = bookService.getBookById(id);
        model.addAttribute("bookInfo", bookInfo);
        return "book-info";
    }

    // получение формы и данных для редактирования выбранной книги
    @GetMapping("/book-update/{idBook}")
    public String editBook(@PathVariable("idBook") Integer id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("updateBook", book);
        return "book-update";
    }

    // обработчик для изменения данных о книге
    @PostMapping("/book-update")
    public String saveCurrentStudent(Book book, RedirectAttributes redirectAttributes) {
        // сохраняем данные новой книги в базе данных
        Book currentBook = bookService.saveBook(book);
        // сообщение, что книга добавлена
        redirectAttributes.addFlashAttribute("message", "Данные книги с номером " + currentBook.getIdBook() + " изменены!");
        return "redirect:/";
    }

}
