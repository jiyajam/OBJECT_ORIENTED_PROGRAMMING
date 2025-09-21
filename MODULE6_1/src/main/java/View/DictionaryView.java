package View;

import Controller.DictionaryController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {

    private TextField wordInput;
    private TextArea meaningDisplay;
    private DictionaryController controller;

    public void start(Stage stage) {

        wordInput = new TextField();
        Button searchButton = new Button("Search");
        meaningDisplay = new TextArea();


        wordInput.setPromptText("Enter a word");
        meaningDisplay.setEditable(false);
        meaningDisplay.setText("Welcome to my Dictionary! \nPlease enter a word and click Search.");

        FlowPane pane = new FlowPane();
        pane.getChildren().add(wordInput);
        pane.getChildren().add(searchButton);
        pane.getChildren().add(meaningDisplay);

        Scene scene = new Scene(pane,300,210);
        stage.setTitle("Virtual Dictionary");
        stage.setScene(scene);

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String word = wordInput.getText();
                controller.searchWord(word);
            }
        });

        stage.show();
    }

    public void init() {
        controller = new DictionaryController(this);
    }

    public void displayResult(String meaning) {
        meaningDisplay.setText(meaning);
    }

    public void displayError(String errorMessage) {
        meaningDisplay.setText(errorMessage);
        meaningDisplay.setText(errorMessage + "\nHint: Try serendipity, wanderlust,sonder or java");
    }
}


