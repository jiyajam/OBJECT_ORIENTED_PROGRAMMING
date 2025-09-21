package Controller;

import Model.Dictionary;
import Model.WordNotFoundException;
import View.DictionaryView;

public class DictionaryController {
    private Dictionary dictionary;
    private DictionaryView view;

    public DictionaryController(DictionaryView view) {
        this.view = view;
        this.dictionary = new Dictionary();

        // Hardcode words as specified in documentation
        populateDictionary();
    }

    private void populateDictionary() {
        dictionary.addWord("serendipity", "The pleasant surprise of finding something good while looking for something else");
        dictionary.addWord("wanderlust", "A strong desire to travel and explore the world");
        dictionary.addWord("nostalgia", "A sentimental feeling about the past, often with a bit of sadness");
        dictionary.addWord("procrastination", "The habit of putting off important tasks until later");
        dictionary.addWord("java", "A popular programming language, also a type of coffee that keeps programmers awake");
        dictionary.addWord("debugging", "The detective work of finding and fixing problems in computer code");
        dictionary.addWord("algorithm", "A step-by-step recipe that computers follow to solve problems");
        dictionary.addWord("petrichor", "That wonderful smell when it starts raining after a dry period");
        dictionary.addWord("sonder", "The realization that every stranger has a life as complex as your own");
        dictionary.addWord("friend", "Someone who knows all your weird quirks and likes you anyway");

    }

    public void searchWord(String word) {
        try {
            String meaning = dictionary.searchWord(word);
            view.displayResult(meaning);
        } catch (WordNotFoundException e) {
            view.displayError(e.getMessage());
        }
    }
}


