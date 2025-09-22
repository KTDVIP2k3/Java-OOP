package ImplementService;

import InterfaceService.AuthorInterfaceService;
import InterfaceService.BookInterfaceService;
import Model.Author;
import Model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImplement implements BookInterfaceService {
    private final AuthorInterfaceService authorInterfaceService;
    private final List<Book> bookList = new ArrayList<>();

    public BookServiceImplement(AuthorInterfaceService authorInterfaceService) {
        this.authorInterfaceService = authorInterfaceService;
    }

    @Override
    public boolean addBookIntoAuthor(String authorId, Book book) throws Exception {
        // Lấy danh sách tác giả ngay trước khi cần sử dụng
        List<Author> authorList = authorInterfaceService.getAllAuthors();

        for(Author author : authorList){
            if(author.getAuthorId().equalsIgnoreCase(authorId)){
                author.addBooK(book);
                bookList.add(book);
                return true; // Thoát ngay sau khi thêm sách thành công
            }
        }
        // Nếu vòng lặp kết thúc mà không tìm thấy tác giả, ném lỗi
        throw new IllegalArgumentException("AuthorID does not exist");
    }

    @Override
    public boolean updateAllFieldBookIntoAuthor(String authorId, Book book) throws Exception{
        List<Author> authorList = authorInterfaceService.getAllAuthors();

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
        List<Author> authorList = authorInterfaceService.getAllAuthors();

        for(Author author : authorList){
            if(author.getAuthorId().equalsIgnoreCase(authorId)){
                // Gọi phương thức xóa sách từ lớp Author
                if(author.deleteBookByBookId(bookId)){
                    // Nếu xóa thành công, cũng xóa khỏi danh sách bookList chung
                    // Tìm kiếm và xóa sách khỏi danh sách bookList
                    bookList.removeIf(book -> book.getBookId().equalsIgnoreCase(bookId));
                    return true;
                }
            }
        }
        throw new IllegalArgumentException("AuthorID or BookID does not exist");
    }

    @Override
    public Book findBookById(String bookId) {
        for(Book book : bookList){
            if(book.getBookId().equalsIgnoreCase(bookId)){
                return book;
            }
        }
        throw new IllegalArgumentException("Book Id does not exist");
    }

    @Override
    public List<Book> getAllBook() {
        if(bookList.isEmpty()){
            throw new IllegalArgumentException("Book List is empty!!!");
        }
        return bookList;
    }
}