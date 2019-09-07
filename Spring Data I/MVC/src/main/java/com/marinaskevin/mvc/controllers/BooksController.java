package com.marinaskevin.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marinaskevin.mvc.models.Book;
import com.marinaskevin.mvc.services.BookService;

@Controller
public class BooksController {
    private final BookService bookService;
    private final BooksApi booksApi;
    
    public BooksController(BookService bookService, BooksApi booksApi) {
        this.bookService = bookService;
        this.booksApi = booksApi;
    }
    
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }
    
    @RequestMapping("/books/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Book book = booksApi.show(id);
    	model.addAttribute("book", book);
    	return "/books/show.jsp";
    }
    
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }

    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
}