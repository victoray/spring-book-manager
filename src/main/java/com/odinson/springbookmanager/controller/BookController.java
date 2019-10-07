package com.odinson.springbookmanager.controller;

import com.odinson.springbookmanager.model.Book;
import com.odinson.springbookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    private final String ADDBOOK = "/add_book";
    final String EDIT = "/edit";
    final String HOME = "/index";

    @RequestMapping(ADDBOOK)
    ModelAndView addBook(@RequestBody Book book){
        bookRepository.save(book);
        return new ModelAndView(ADDBOOK);
    }

    @GetMapping("/")
    ModelAndView home(){
        List<Book> books = bookRepository.findAll();
        ModelAndView modelAndView = new ModelAndView(HOME);
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    RedirectView deleteBook(@PathVariable long id){
        Book book = bookRepository.findById(id).orElseThrow(() ->new RuntimeException("Book Not Found"));
        bookRepository.delete(book);
        return new RedirectView("/");
    }

    @RequestMapping(EDIT)
    ModelAndView editBook(){
        return new ModelAndView(EDIT);
    }
}
