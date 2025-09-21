package Model;


// This exception is thrown when we can't find a word in our dictionary.

public class WordNotFoundException extends Exception {

    /**
     * Creates a new exception with a  message.
     */
    public WordNotFoundException(String message) {
        super(message);
    }
}

