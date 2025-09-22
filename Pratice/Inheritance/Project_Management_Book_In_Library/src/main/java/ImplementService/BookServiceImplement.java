package ImplementService;

import InterfaceService.AuthorInterfaceService;
import Model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImplement {
    private final AuthorInterfaceService authorInterfaceService;
    private List<Book> bookList;


    public BookServiceImplement(AuthorInterfaceService authorInterfaceService){
        this.authorInterfaceService = authorInterfaceService;
        bookList = new ArrayList<>();
    }


}
