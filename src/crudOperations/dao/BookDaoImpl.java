package crudOperations.dao;

import crudOperations.config.DBHelper;
import crudOperations.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    @Override
    public List<Book> getBooks() throws SQLException {
        String sql = "select*from books where active=1";
        List<Book> books = new ArrayList<>();
        try {
            connection = DBHelper.connect();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setNameOfBook(resultSet.getString("name_of_book"));
                book.setAuthorOfBook(resultSet.getString("author_of_book"));
                book.setLanguageId(resultSet.getInt("language_id"));
                book.setActive(resultSet.getInt("active"));
                books.add(book);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }
        return books;
    }

    @Override
    public Book getBook(int id) throws SQLException {
        String sql = "select*from books where active=1 and id=?";
        Book book = new Book();

        try {
            connection = DBHelper.connect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book.setId(resultSet.getInt("id"));
                book.setNameOfBook(resultSet.getString("name_of_book"));
                book.setAuthorOfBook(resultSet.getString("author_of_book"));
                book.setLanguageId(resultSet.getInt("language_id"));
                book.setActive(resultSet.getInt("active"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }
        return book;

    }

    @Override
    public void addBook(Book book) throws SQLException {
        String sql = "insert into books values (book_seq.nextval,?,?,?)";
        try {
            connection = DBHelper.connect();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, book.getNameOfBook());
                preparedStatement.setString(2, book.getAuthorOfBook());
                preparedStatement.setInt(3,book.getLanguageId());

          preparedStatement.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.disconnect(connection, preparedStatement, resultSet);
        }

    }
}
