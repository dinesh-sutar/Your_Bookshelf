package org.raaj.book_store.dto;

import java.time.LocalDate;
import java.util.List;

import org.raaj.book_store.model.BookFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDetailsResponse {
        private int bookId;
        private String bookName;
        private String authorName;
        private int totalPage;
        private String category;
        private LocalDate publicationDate;
        private BookFormat bookFormat;
        private List<String> availability;
        private String description;
}