import library.model.Book;
import library.model.LibraryMember;
import library.system.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("The girl", "Blama ", "23456788765");
        Book book2 = new Book("Divergent", "Donald Lee", "43245684321");

        LibraryMember member1 = new LibraryMember("Reena", 1);
        LibraryMember member2 = new LibraryMember("Sloan", 2);

        library.addBook(book1);
        library.addBook(book2);

        library.addMember(member1);
        library.addMember(member2);

        library.borrowBook(member1, book1);
        library.borrowBook(member2, book1);

        library.reserveBook(member1, book1);

        library.returnBook(member1, book1);

        library.displayReservedBooks(member1);


    }
}