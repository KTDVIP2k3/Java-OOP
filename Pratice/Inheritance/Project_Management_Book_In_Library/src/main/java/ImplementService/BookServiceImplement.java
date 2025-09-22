package ImplementService;

import InterfaceService.AuthorInterfaceService;
import InterfaceService.BookInterfaceService;
import Model.Author;
import Model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImplement implements BookInterfaceService {
    private final AuthorInterfaceService authorInterfaceService;
    private final List<Author> authorList;
    private final List<Book> bookList = new ArrayList<>();


    public BookServiceImplement(AuthorInterfaceService authorInterfaceService) throws Exception{
        this.authorInterfaceService = authorInterfaceService;
        authorList = authorInterfaceService.getAllAuthors();
    }


    @Override
    public boolean addBookIntoAuthor(String authorId, Book book) throws Exception{
        for(Author author : authorList){
            if(author.getAuthorId().equalsIgnoreCase(authorId)){
                author.addBooK(book);
                bookList.add(book);
            }
        }
        throw new IllegalArgumentException("AuthorID does not exist");
    }

    @Override
    public boolean updateAllFieldBookIntoAuthor(String authorId, Book book) throws Exception{
        for(Author author : authorList){
            if(author.getAuthorId().equalsIgnoreCase(authorId)){
                if(author.updateBookAllFieldByBookId(book)){
                    return true;
                }
            }
        }
        throw new IllegalArgumentException("AuthorID does not exist");
    }

    @Override
    public boolean deleteBookByAuthor(String authorId, String bookId) throws Exception{
        for(Author author : authorList){
            if(author.getAuthorId().equalsIgnoreCase(authorId)){
                for(Book book : author.getBookListByAuthor()){
                    if(book.getBookId().equalsIgnoreCase(bookId)){
                        bookList.remove(book);
                       if(author.deleteBookByBookId(bookId)){
                           return author.deleteBookByBookId(bookId);
                       }
                    }
                }
            }
        }
        throw new IllegalArgumentException("AuthorID does not exist");
    }

    @Override
    public Book findBookById(String bookId) throws Exception{
        for(Book book : bookList){
            if(book.getBookId().equalsIgnoreCase(bookId)){
                return book;
            }
        }
        throw new IllegalArgumentException("Book Id does not exist");
    }

    @Override
    public List<Book> getAllBook() throws Exception {
        if(bookList.isEmpty()){
            throw new Exception("Book List is empty!!!");
        }
        return bookList;
    }
}
