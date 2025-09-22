package Model;

import java.util.ArrayList;
import java.util.EmptyStackException;
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

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography){
        this.biography = biography;
    }

    public List<Book> getBookListByAuthor() throws  Exception{
        if(bookList.isEmpty()){
            throw new IllegalArgumentException("BookList is empty");
        }
        return  bookList;
    }

    public boolean addBoo(Book book) throws Exception{
        bookList.add(book);
        return true;
    }

    public Book findBookByIdByAuthor(String bookID) throws  Exception{
        for(Book book : bookList){
            if(book.getBookId().equalsIgnoreCase(bookID)){
                return book;
            }
        }
        throw new IllegalArgumentException("BookId does not exist")
    }

    public boolean updateBookAllFieldByBookId(Book book) throws Exception{
        for(Book book1 : bookList){
            if(book1.getBookId().equalsIgnoreCase(book.getBookId())){
                book1.setTitle(book.getTitle());
                book1.setDescription(book.getDescription());
                book1.setPrice(book.getPrice());
                book1.setPublishedYear(book.getPublishedYear());
                return true;
            }
        }
        return false;
    }

    public boolean updateBookTitleByBookId(String bookId, String bookTitle) throws Exception{
        for(Book book : bookList){
            if(book.getBookId().equalsIgnoreCase(bookId)){
                book.setTitle(bookTitle);
                return true;
            }
        }
        return false;
    }

    public boolean updateBookDescriptionByBookId(String bookId, String description) throws  Exception{
        for(Book book : bookList){
            if(book.getBookId().equalsIgnoreCase(bookId)){
                book.setDescription(description);
                return true;
            }
        }
        return false;
    }

    public boolean updateBookPriceByBookId(String bookId, double price) throws Exception{
        for(Book book : bookList){
            if(book.getBookId().equalsIgnoreCase(bookId)){
                book.setPrice(price);
                return true;
            }
        }
        return false;
    }

    public boolean updateBookPublishedYearByBookId(String bookId, String publishedYear) throws Exception{
        for(Book book : bookList){
            if(book.getBookId().equalsIgnoreCase(bookId)){
                book.setPublishedYear(publishedYear);
                return true;
            }
        }
        return false;
    }

    public boolean deleteBookByBookId(String bookID) throws Exception{
        for(Book book : bookList){
            if(book.getBookId().equalsIgnoreCase(bookID)){
                bookList.remove(book);
                return true;
            }
        }
        return false;
    }


}
