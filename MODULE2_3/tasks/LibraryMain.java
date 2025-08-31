public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book("The Witches", "Roald Dahl", 2016);
        Book b2 = new Book("Divergent", "Veronica Rath", 2012);
        Book b3 = new Book("Wimpy kid", "Greg Heffley", 2009);

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        library.displayBooks();
        System.out.println();

        library.findBooksByAuthor("Veronica Rath");
        System.out.println();

    }
}
