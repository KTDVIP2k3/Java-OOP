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
                throw new IllegalArgumentException("AuthorId existed!!!!");
            }
        }
        authorList.add(author);
        return true;
    }

    @Override
    public boolean updateAuthorAllField(Author author) throws Exception{
        for(Author author1 : authorList){
            if(author1.getAuthorId().equalsIgnoreCase(author.getAuthorId())){
                if(author.getAuthorId().isBlank()){
                    throw new IllegalArgumentException("Author should not be blank");
                }
                if(author.getAuthorName().isBlank()){
                    throw new IllegalArgumentException("Author name should not be blank");
                }
                if(author.getBiography().isBlank()){
                    throw new IllegalArgumentException("Author biography should not be blank");
                }
                if(author.getBirthday().isBlank()){
                    throw new IllegalArgumentException("Author birthday should not be blank");
                }
                if(author.getNationality().isBlank()){
                    throw new IllegalArgumentException("Author nationality should not be blank");
                }
                author1.setAuthorName(author.getAuthorName());
                author1.setBiography(author.getBiography());
                author1.setBirthday(author.getBirthday());
                author1.setNationality(author.getNationality());
                return true;
            }
        }
        throw new IllegalArgumentException("AuthorId does not exist");
    }

    @Override
    public boolean deleteAuthorById(String authorID) {
        for(Author author : authorList){
            if(author.getAuthorId().equalsIgnoreCase(authorID)){
                authorList.remove(author);
                return true;
            }
        }
        throw new IllegalArgumentException("AuthorId dose not exist!!!!");
    }
}
