package crudOperations.main;

import crudOperations.dao.BookDao;
import crudOperations.dao.BookDaoImpl;
import crudOperations.model.Book;
import crudOperations.service.BookService;
import crudOperations.service.BookServiceImpl;
import java.util.List;
import java.util.Scanner;


public class Runner {
    public static void main(String[] args) throws Exception {
        //    DBHelper.connect();
        Scanner sc = new Scanner(System.in);
        BookDao bookDao = new BookDaoImpl();
        BookService bookService = new BookServiceImpl(bookDao);
        System.out.println("Please enter operation type");
        String type = sc.next();
        try {
            while (!type.equalsIgnoreCase("exit")) {

                switch (type) {
                    case "select":
                        List<Book> books = bookService.getBooks();
                        for (Book book : books) {
                            System.out.println(book);
                        }
                        break;

                    case "selectone":

                        System.out.println("Please enter book id");
                        int id = sc.nextInt();
                        Book book = bookService.getBook(id);
                        System.out.println(book);
                        break;
                    case "insert":
                        Scanner scan = new Scanner(System.in);

                        System.out.print("Please enter name_of_book: ");
                        String nameOfBook = scan.next();
                        System.out.print("Please enter author_of_book");
                        String authorOfBook = scan.next();
                        System.out.print("Please enter language_id");
                        int languageId = scan.nextInt();

                        Book book1 = new Book();
                        book1.setNameOfBook(nameOfBook);
                        book1.setAuthorOfBook(authorOfBook);
                        book1.setLanguageId(languageId);
                        bookService.addBook(book1);
                        System.out.println("Book added successful");
                        break;
                    case "update":
                        break;
                    case "delete":
                        break;
                    default:
                        System.out.println("Incorrect operation type!");
                }
                System.out.println("Please enter new operations type");
                System.out.println("If you want exit program,please enter 'exit'");
                type = sc.next();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}