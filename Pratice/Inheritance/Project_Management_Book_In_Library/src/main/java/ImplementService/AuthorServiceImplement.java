package ImplementService;

import InterfaceService.AuthorInterfaceService;
import Model.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorServiceImplement implements AuthorInterfaceService {
    private List<Author> authorList;

    public AuthorServiceImplement(){
        authorList = new ArrayList<>();
    }

    @Override
    public List<Author> getAllAuthors() throws Exception {
        if(authorList.isEmpty()){
            throw new IllegalArgumentException("Author List is empty");
        }
        return authorList;
    }

    @Override
    public Author findAuthorById(String authorId) throws Exception{
        for(Author author : authorList){
            if(author.getAuthorId().equalsIgnoreCase(authorId)){
                return author;
            }
        }
        throw new IllegalArgumentException("Author has this ID does not Exist");
    }

    @Override
    public boolean addAuthor(Author author) throws Exception{
        for(Author author1 : authorList){
            if(author1.getAuthorId().equalsIgnoreCase(author.getAuthorId())){
                System.out.println("AuthorId existed");
                System.out.println("Please input another authorID");
                return false;
            }
        }
        authorList.add(author);
        return true;
    }

    @Override
    public boolean updateAuthorAllField(Author author) throws Exception{
        for(Author author1 : authorList){
            if(author1.getAuthorId().equalsIgnoreCase(author.getAuthorId())){

            }
        }
        return false;
    }

    @Override
    public boolean deleteAuthorById(String authorID) {
        return false;
    }
}
