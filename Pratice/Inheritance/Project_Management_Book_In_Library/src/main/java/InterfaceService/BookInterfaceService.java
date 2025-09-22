package InterfaceService;

import Model.Book;

import java.util.List;

public interface BookInterfaceService {
    public boolean addBook();

    public boolean updateBook();

    public boolean deleteBook();

    public List<Book> getAllBook();
}
