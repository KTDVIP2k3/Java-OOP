package Model;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String authorId;
    private String authorName;
    private String birthday;
    private String nationality;
    private String biography;
    private List<Book> bookList;

    public Author(){
        bookList = new ArrayList<>();
    }

    public Author(List<Book> bookList, String biography, String nationality, String birthday, String authorName, String authorId) {
        this.bookList = bookList;
        this.biography = biography;
        this.nationality = nationality;
        this.birthday = birthday;
        this.authorName = authorName;
        this.authorId = authorId;
        bookList = new ArrayList<>();
    }
}
