package org.raaj.book_store.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
// the lombook provide the default parameters to get called by the object
public class BookStore {
    private String bookName;
    private String authorName;
    private int totalPage;
    private LocalDate publicationDate;
    private BookFormat bookFormat;
    private String category;
    private List<String> availability;
    private String description;
    private MultipartFile bookImage;
}
