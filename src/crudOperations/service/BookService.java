package crudOperations.service;

import crudOperations.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookService {
    List<Book> getBooks() throws SQLException;

    Book getBook(int  id)throws SQLException;

    void addBook(Book book1) throws SQLException;
}
