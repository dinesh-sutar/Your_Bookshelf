package org.raaj.book_store.service;

import java.util.List;

import org.raaj.book_store.dto.BookDetailsResponse;
import org.raaj.book_store.dto.HomePageResponse;
import org.raaj.book_store.model.BookStore;
import org.springframework.web.multipart.MultipartFile;

public interface BookStoreService {
    /**
     * <h1>Create Book
     * </h1>
     */
    void createBook(BookStore bookStore, String filePath);

    String findImageById(int id);

    List<HomePageResponse> getBooksNameAndId();

    BookDetailsResponse getBook(int id);

    void deleteBookBId(int id);

    void updateBook(int bookId, BookStore bookStore);

    void updateImage(int bookId, MultipartFile bookImage);
}
