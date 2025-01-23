package ge.tbc.testautomation.data.models.BookStore;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BookResponse {

    @JsonProperty("books")
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
