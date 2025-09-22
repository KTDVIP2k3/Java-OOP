package InterfaceService;

import Model.Book;

import java.util.List;

public interface BookInterfaceService {
    public boolean addBookByAuthorId(String authorId, Book book);

    public boolean updateBook();

    public boolean deleteBook();

    public List<Book> getAllBook();
}
