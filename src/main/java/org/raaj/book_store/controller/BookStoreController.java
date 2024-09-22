package org.raaj.book_store.controller;

import java.io.IOException;

import org.raaj.book_store.dto.BookDetailsResponse;
import org.raaj.book_store.model.BookStore;
import org.raaj.book_store.service.BookStoreService;
import org.raaj.book_store.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// import org.springframework.web.bind.annotation.RequestParam;
import lombok.RequiredArgsConstructor;

// import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class BookStoreController {

    private final BookStoreService service;

    private final FileService fileService;

    @GetMapping({ "/home", "/" })
    public String home(Model model) {
        model.addAttribute("books", service.getBooksNameAndId());
        return "home";
    }

    // @GetMapping("/create-book") for Get Method form submission
    @PostMapping("/create-update-book")
    public String addBook(@ModelAttribute BookStore bookStore, @RequestParam int bookId) throws IOException {
        // public String addBook(HttpServletRequest request) {
        // String name = request.getParameter("bookName");
        // String author = request.getParameter("authorName");
        // String totalPage = request.getParameter("totalPage");
        // int pages = Integer.parseInt(totalPage);
        // we must not use servlet concept in Spring
        // System.out.println(bookStore);
        if (bookId == 0) {
            String path = fileService.uploadImage(bookStore.getBookImage());
            service.createBook(bookStore, path);
        } else {
            service.updateBook(bookId, bookStore);
            service.updateImage(bookId, bookStore.getBookImage());
        }
        // return "new-book";
        return "redirect:/home";
    }

    @GetMapping("/new-book")
    public String newBook(Model model) {
        model.addAttribute("book", new BookDetailsResponse());
        return "new-book";
    }

    @GetMapping("/details")
    public String details(@RequestParam int id, Model model) {
        var book = service.getBook(id);
        model.addAttribute("book", book);
        return "book-details";
    }

    @GetMapping(path = "/image/{id}", produces = { "image/jpeg", "image/jpg", "image/png" })
    @ResponseBody
    public byte[] getImage(@PathVariable int id) throws IOException {
        String imageName = service.findImageById(id);
        byte[] image = fileService.getImage(imageName);
        return image;
    }

    @GetMapping("/remove-book")
    public String removeBook(@RequestParam int id) {
        service.deleteBookBId(id);
        return "redirect:/home";
    }

    @GetMapping("/update-book")
    public String updateBook(@RequestParam int id, Model model) {
        var book = service.getBook(id);
        model.addAttribute("book", book);
        return "new-book";
    }

}
