package Model;

import java.util.HashMap;

/**
 * A simple dictionary that stores words and their meanings.
 * Think of this as your personal vocabulary book!
 */
public class Dictionary {
    // Our word storage - like a filing cabinet for words
    private HashMap<String, String> myWordCollection;

    /**
     * Creates a new empty dictionary.
     * Ready to learn some new words!
     */
    public Dictionary() {
        this.myWordCollection = new HashMap<>();
    }

    /**
     * Adds a new word to our dictionary.
     * Like writing a new entry in your vocabulary notebook.
     */
    public void addWord(String word, String meaning) {
        // We store everything in lowercase to make searching easier
        myWordCollection.put(word.toLowerCase(), meaning);
    }

    /**
     * Looks up a word in our dictionary.
     * Just like flipping through pages to find what you're looking for!
     */
    public String searchWord(String word) throws WordNotFoundException {
        // First, let's check if the person actually typed something
        if (word == null || word.trim().isEmpty()) {
            throw new WordNotFoundException("Oops! You forgot to type a word. Please enter something to search for.");
        }

        // Clean up the word (remove extra spaces, make lowercase)
        String cleanWord = word.toLowerCase().trim();
        String foundMeaning = myWordCollection.get(cleanWord);

        // Did we find it in our collection?
        if (foundMeaning == null) {
            throw new WordNotFoundException("Sorry , the word is not available '" + word + "' in my dictionary. Maybe try a different word?");
        }

        return foundMeaning;
    }

}
