package org.example.UI;

import org.example.BookMagementService.BookManagement;
import org.example.Models.Book;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookManagement bookManagement = new BookManagement();
        int choice = 0;
        do{
            System.out.println("==============Book Management=======");
            System.out.println("1.Show all Book");
            System.out.println("2. Show book information by book Id");
            System.out.println("3. Add new book");
            System.out.println("4. Update book title by book Id");
            System.out.println("5.Delete book by book Id");
            System.out.println("6.Exist");
            System.out.print("Please enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Book List");
                    bookManagement.showAllBook();
                    break;
                case 2:
                    System.out.print("Please enter bookId: ");
                    bookManagement.showInfoBookByBookId(sc.nextLine());
                    break;
                case 3:
                    Book book = new Book();
                    System.out.print("Please enter bookId: ");
                    book.setBookId(sc.nextLine());
                    System.out.print("Please enter book title: ");
                    book.setTilte(sc.nextLine());
                    System.out.print("Please enter book author: ");
                    book.setAuthor(sc.nextLine());
                    System.out.print("Please enter book description: ");
                    book.setDescription(sc.nextLine());
                    System.out.print("Please enter book quantity: ");
                    book.setQuantity(Integer.parseInt(sc.nextLine()));
                    System.out.print("Please enter book price: ");
                    book.setPrice(Double.parseDouble(sc.nextLine()));
                    book.setAvailabe(true);
                    if(bookManagement.addBook(book)){
                        System.out.println("Add book successfully");
                    }else{
                        System.out.println("Add book failed");
                    }
                    break;
                case 4:
                    String bookId, title;
                    System.out.print("Please enter bookId: ");
                    bookId = sc.nextLine();
                    if(!bookManagement.findBookByBookId(bookId)){
                        System.out.println("Book have this bookId does not exist!!!");
                    }else{
                        System.out.print("Please enter book title: ");
                        title = sc.nextLine();
                        if(bookManagement.updateBookTitleByBookId(bookId, title)){
                            System.out.println("Update book title succesfully");
                        }else{
                            System.out.println("Update book failed");
                        }
                    }
                    break;
                case 5:
                    System.out.print("Please enter book Id: ");
                    bookId = sc.nextLine();
                    if(!bookManagement.findBookByBookId(bookId)){
                        System.out.println("Book have this bookId does not exist!!!");
                    }else{
                        if(bookManagement.deleteBookByBookID(sc.nextLine())){
                            System.out.println("Delete book title succesfully");
                        }else{
                            System.out.println("Delete book failed");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Good bye!!");
                    break;
                default:
                    System.out.println("Invalid choice!!!");
                    break;
            }

        }while(choice != 6);

    }
}