package Model;

public class Book {
    private String bookId;
    private String title;
    private String description;
    private String publishedYear;
    private double price;
    private Author author;
    public Book(){

    }

    public Book(String bookId, String title, String description, String publishedYear, double price, Author author){
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.publishedYear = publishedYear;
        this.price = price;
        this.author = author;
    }

    public Book(String bookId, String title, String description, String publishedYear, double price){
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.publishedYear = publishedYear;
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "BookId: " + bookId + " - " + "Title: " + title +
                " - " + "Description: " + description + " - " +
                "Published year: " + publishedYear + " - " +
                "Price: " + price + " - " + "Author name :" + author.getAuthorName();
    }

}
