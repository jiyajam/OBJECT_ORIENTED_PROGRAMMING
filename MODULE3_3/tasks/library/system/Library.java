package library.system;

import library.model.Book;
import library.model.LibraryMember;
import java.util.*;

public class Library {
    private List<Book> books;
    private List<LibraryMember> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void addMember(LibraryMember member) {
        members.add(member);
        System.out.println("Member added: " + member);
    }

    public void borrowBook(LibraryMember member, Book book) {
        if (books.contains(book)) {
            if (book.isReserved() && !member.hasReservedBook(book)) {
                System.out.println("Book is reserved by another member: " + book.getTitle());
                return;
            }

            books.remove(book);
            member.borrowBook(book);

            // Remove reservation if this member reserved the book
            if (member.hasReservedBook(book)) {
                member.removeReservedBook(book);
                book.setReserved(false);
            }

            System.out.println(member.getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Book not available in the library: " + book.getTitle());
        }
    }

    public void returnBook(LibraryMember member, Book book) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            books.add(book);
            System.out.println(member.getName() + " returned " + book.getTitle());
        } else {
            System.out.println(member.getName() + " does not have " + book.getTitle());
        }
    }
    public void reserveBook(LibraryMember member, Book book) {
        if (!book.isReserved() && books.contains(book)) {
            book.setReserved(true);
            member.addReservedBook(book);
            System.out.println(member.getName() + " reserved " + book.getTitle());
        } else {
            System.out.println("Book is already reserved or not available: " + book.getTitle());
        }
    }
    public void cancelReservation(LibraryMember member, Book book) {
        if (book.isReserved() && member.hasReservedBook(book)) {
            book.setReserved(false);
            member.removeReservedBook(book);
            System.out.println(member.getName() + " canceled reservation for " + book.getTitle());
        } else {
            System.out.println("Book was not reserved by " + member.getName());
        }
    }

    public void displayReservedBooks(LibraryMember member) {
        System.out.println("Reserved books for " + member.getName() + ":");
        if (member.getReservedBooks().isEmpty()) {
            System.out.println("No reserved books.");
        } else {
            for (Book book : member.getReservedBooks()) {
                System.out.println("- " + book.getTitle());
            }
        }
    }

}