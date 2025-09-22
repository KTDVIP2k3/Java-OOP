package InterfaceService;

import Model.Author;

import java.util.List;

public interface AuthorInterfaceService {
    public List<Author> getAllAuthors() throws Exception;

    public Author findAuthorById(String authorId) throws Exception;

    public boolean addAuthor(Author author) throws Exception;

    public boolean  updateAuthorAllField(Author author) throws Exception;

    public boolean deleteAuthorById(String authorID) throws Exception;


}
