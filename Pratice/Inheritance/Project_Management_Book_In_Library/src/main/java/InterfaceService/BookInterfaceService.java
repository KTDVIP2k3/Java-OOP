package InterfaceService;

import Model.Book;

import java.util.List;

public interface BookInterfaceService {
    public boolean addBookIntoAuthor(String authorId, Book book) throws Exception;

    public boolean updateAllFieldBookIntoAuthor(String authorId, Book book) throws Exception;


    public boolean deleteBookByAuthor(String authorId, String bookId) throws Exception;

    public Book findBookById(String bookId) throws Exception;

    public List<Book> getAllBook() throws Exception;
}
