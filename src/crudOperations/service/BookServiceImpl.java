package crudOperations.service;

import crudOperations.dao.BookDao;
import crudOperations.model.Book;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService{
private BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {

        this.bookDao = bookDao;
    }


    @Override
    public List<Book> getBooks() throws SQLException {
        return bookDao.getBooks();
    }

    @Override
    public Book getBook(int id) throws SQLException {
        return bookDao.getBook(id);
    }

    @Override
    public void addBook(Book book) throws SQLException {
        bookDao.addBook(book);
    }
}
