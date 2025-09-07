import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private int publicationyear;
    private double rating;
    private ArrayList<String> reviews = new ArrayList<>();


    public Book(String title, String author, int publicationyear) {
        this.title = title;
        this.author = author;
        this.publicationyear = publicationyear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationyear() {
        return publicationyear;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void addReview(String review) {
        reviews.add(review);
    }
    public ArrayList<String> getReviews() {
        return reviews;
    }


    @Override
    public String toString() {
        return "Title: \"" + title + "\", Author: \"" + author + "\", Year: " + publicationyear + ", Rating: " + rating + ", Reviews: " + reviews.size();
    }
}
