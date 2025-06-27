package org.example.BookMagementService;

import org.example.Models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookManagement {
    //This is new data structure of array
    //It is different normal  array because data structure is built and organized into a class or interface
    //The advantage of this structure is when u create this array you don't need to manage or declare how
    //number element in your array the (GC) garbage collector of JVM will manage for you
    //It also provides some basic function then you can inherit lai CRUD
    private List<Book> bookList;

    public BookManagement(){
        bookList = new ArrayList<>();
    }

    public void showAllBook(){
        if(bookList.isEmpty()){
            System.out.println("List of book is blank!!!");
            return;
        }

        //this is another type of for
        // This book is one of element in this array then will go through on in this array
        for(Book book: bookList){
            book.showInforBook();
        }

    }

    public boolean findBookByBookId(String bookId){
        for(Book book : bookList){
            if(book.getBookId().equalsIgnoreCase(bookId)){
                return true;
            }
        }
        return false;
    }

    public void showInfoBookByBookId(String bookId){
        boolean flag = false;
        for(Book book : bookList){
            if(book.getBookId().equalsIgnoreCase(bookId)){
                book.showInforBook();
                flag = true;
                break;
            }
        }

        if(!flag){
            System.out.println("Book have this id dose not exist!!");
        }
    }


    public boolean addBook(Book book){
        if(bookList.add(book)){
            return true;
        }
        return false;
    }

    public boolean updateBookTitleByBookId(String bookId, String title){
        for(Book book : bookList){
            if(book.getBookId().equalsIgnoreCase(bookId)){
                book.setTilte(title);
                return true;
            }
        }

        return false;
    }

    public boolean deleteBookByBookID(String bookId){
        boolean flag = false;
        for(Book book: bookList){
            if(book.getBookId().equalsIgnoreCase(bookId)){
                if(bookList.remove(book)){
                    flag = true;
                    return true;
                }else{
                    return false;
                }
            }
        }

       if(!flag){
           System.out.println("This book ID does not exist");
       }
        return false;
    }
}
