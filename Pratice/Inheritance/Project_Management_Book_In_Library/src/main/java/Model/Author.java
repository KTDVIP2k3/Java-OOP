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

    public Author(String id, String name, String birthday, String nationality, String biography) {
        this.authorId = id;
        this.authorName = name;
        this.birthday = birthday;
        this.nationality = nationality;
        this.biography = biography;
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

    public boolean addBooK(Book book) throws Exception{
        for(Book book1 : bookList){
            if(book1.getBookId().equalsIgnoreCase(book.getBookId())){
                throw new IllegalArgumentException("Book Id does not exist");
            }
        }
        if(book.getTitle().isBlank()){
            throw new IllegalArgumentException("Book title should not be blank");
        }
        if(book.getDescription().isBlank()){
            throw new IllegalArgumentException("Description should not be blank!!!");
        }

        if(book.getPrice() <= 0){
            throw new IllegalArgumentException("Price should not be <= 0");
        }

        if(book.getPublishedYear().isBlank()){
            throw new IllegalArgumentException("Published year should not be blank");
        }
        bookList.add(book);
        return true;
    }

    public Book findBookByIdByAuthor(String bookID) throws  Exception{
        for(Book book : bookList){
            if(book.getBookId().equalsIgnoreCase(bookID)){
                return book;
            }
        }
        return null;
    }

    public boolean updateBookAllFieldByBookId(Book book) throws Exception{
        for(Book book1 : bookList){
            if(book1.getBookId().equalsIgnoreCase(book.getBookId())){
                if(book.getTitle().isBlank()){
                    throw new IllegalArgumentException("Book title should not be blank");
                }
                if(book.getDescription().isBlank()){
                    throw new IllegalArgumentException("Description should not be blank!!!");
                }

                if(book.getPrice() <= 0){
                    throw new IllegalArgumentException("Price should not be <= 0");
                }

                if(book.getPublishedYear().isBlank()){
                    throw new IllegalArgumentException("Published year should not be blank");
                }

                book1.setTitle(book.getTitle());
                book1.setDescription(book.getDescription());
                book1.setPrice(book.getPrice());
                book1.setPublishedYear(book.getPublishedYear());
                return true;
            }
        }
        throw new IllegalArgumentException("Book Id does not exist");
    }

    public boolean updateBookTitleByBookId(String bookId, String bookTitle) throws Exception{
        for(Book book : bookList){
            if(book.getBookId().equalsIgnoreCase(bookId)){
                if(bookTitle.isBlank()){
                    throw new IllegalArgumentException("Book title should not be blank");
                }
                book.setTitle(bookTitle);
                return true;
            }
        }
        throw new IllegalArgumentException("Book Id does not exist");
    }

    public boolean updateBookDescriptionByBookId(String bookId, String description) throws  Exception{
        for(Book book : bookList){
            if(book.getBookId().equalsIgnoreCase(bookId)){
                if(description.isBlank()){
                    throw new IllegalArgumentException("Description should not be blank!!!");
                }
                book.setDescription(description);
                return true;
            }
        }
        throw new IllegalArgumentException("Book Id does not exist");
    }

    public boolean updateBookPriceByBookId(String bookId, String price) throws Exception{
        try{
            double price1 = Double.parseDouble(price);
            for(Book book : bookList){
                if(book.getBookId().equalsIgnoreCase(bookId)){
                    if(price1 <= 0){
                        throw new IllegalArgumentException("Price should not be <= 0");
                    }
                    book.setPrice(price1);
                    return true;
                }
            }
            throw new IllegalArgumentException("Book Id does not exist");
        }catch (NumberFormatException numberFormatException){
            throw new NumberFormatException("Price should be digit");
        }
    }

    public boolean updateBookPublishedYearByBookId(String bookId, String publishedYear) throws Exception{
        for(Book book : bookList){
            if(book.getBookId().equalsIgnoreCase(bookId)){
                if(publishedYear.isBlank()){
                    throw new IllegalArgumentException("Published year should not be blank");
                }
                book.setPublishedYear(publishedYear);
                return true;
            }
        }
        throw new IllegalArgumentException("Book Id does not exist");
    }

    public boolean deleteBookByBookId(String bookID) throws Exception{
        for(Book book : bookList){
            if(book.getBookId().equalsIgnoreCase(bookID)){
                bookList.remove(book);
                return true;
            }
        }
        throw new IllegalArgumentException("Book Id does not exist");
    }


}
