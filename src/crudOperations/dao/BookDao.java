package crudOperations.dao;

import crudOperations.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    List<Book> getBooks() throws SQLException;

    Book getBook(int id) throws SQLException;

    void addBook(Book book)throws  SQLException;
}
