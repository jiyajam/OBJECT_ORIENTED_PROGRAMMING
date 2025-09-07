import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("library is empty right now.");
        } else {
            System.out.println("Library Catalogue: ");
            int index = 1;
            for (Book book : books) {
                System.out.println(book);
                System.out.println(index + ". Title: \"" + book.getTitle() + "\", Author: \"" + book.getAuthor() + "\", Year: " + book.getPublicationyear());
                index++;
            }
        }
    }

    public void findBooksByAuthor(String author) {
        int count = 0;

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                if (count == 0) {
                    System.out.println("Books by " + author + ":");
                }
                System.out.println(book);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No books found by author: " + author);
        }
    }

    public Book borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                return book;
            }
        }
        return null;
    }


    public void returnBook(Book book) {
        books.add(book);
    }

    public boolean isBookAvailable(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
    public double getAverageBookRating() {
        if (books.isEmpty()) return 0;

        double total = 0;
        int count = 0;

        for (Book book : books) {
            total += book.getRating();
            count++;
        }

        return count == 0 ? 0 : total / count;
    }

    public Book getMostReviewedBook() {
        if (books.isEmpty()) return null;

        Book mostReviewed = books.get(0);

        for (Book book : books) {
            if (book.getReviews().size() > mostReviewed.getReviews().size()) {
                mostReviewed = book;
            }
        }

        return mostReviewed;
    }

     public void addUser(User user) {
        users.add(user);
    }

    public void displayUsers() {
        for (User user : users) {
            System.out.println("User: " + user.getName());
            for (Book book : user.getBorrowedBooks()) {
                System.out.println("  - Borrowed: " + book.getTitle());
            }
        }
    }

}