package org.raaj.book_store.service.impl;

import java.util.List;

import org.raaj.book_store.dto.BookDetailsResponse;
import org.raaj.book_store.dto.HomePageResponse;
import org.raaj.book_store.model.BookStore;
import org.raaj.book_store.service.BookStoreService;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BookStoreServiceImpl1 implements BookStoreService {
    private JdbcClient jdbcClient;

    @Override
    public void createBook(BookStore bookStore, String filePath) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBook'");
    }

    @Override
    public String findImageById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findImageById'");
    }

    @Override
    public List<HomePageResponse> getBooksNameAndId() {
        String sql = "SELECT book_id, book_name FROM book_store";
        return jdbcClient.sql(sql).query(HomePageResponse.class).list();
    }

    @Override
    public BookDetailsResponse getBook(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBook'");
    }

    @Override
    public void deleteBookBId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBookBId'");
    }

    @Override
    public void updateBook(int bookId, BookStore bookStore) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBook'");
    }

    @Override
    public void updateImage(int bookId, MultipartFile bookImage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateImage'");
    }

}
