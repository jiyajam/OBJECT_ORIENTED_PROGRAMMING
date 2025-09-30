package view;

import controller.CurrencyConverter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import entity.Currency;

public class CurrencyConverterView extends Application {

    private TextField amountField;
    private TextField resultField;
    private ComboBox<Currency> fromBox;
    private ComboBox<Currency> toBox;
    private CurrencyConverter controller;

    @Override
    public void start(Stage stage) {

        Label instruction = new Label("Enter amount and select currencies");
        Label amountLabel = new Label("Amount:");
        amountField = new TextField();

        Label fromLabel = new Label("From Currency:");
        fromBox = new ComboBox<>();

        Label toLabel = new Label("To Currency:");
        toBox = new ComboBox<>();

        Button convertButton = new Button("Convert");
        Label resultLabel = new Label("Result:");
        resultField = new TextField();
        resultField.setEditable(false);

        VBox layout = new VBox();
        layout.getChildren().addAll(instruction, amountLabel, amountField,
                fromLabel, fromBox, toLabel, toBox, convertButton, resultLabel, resultField);

        Scene scene = new Scene(layout, 300, 400);
        stage.setTitle("Currency Converter");
        stage.setScene(scene);

        convertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.convert(amountField.getText(), fromBox.getValue(), toBox.getValue());
            }
        });

        controller = new CurrencyConverter(this);

        // Load currencies from database
        try {
            for (Currency currency : controller.getCurrencies()) {
                fromBox.getItems().add(currency);
                toBox.getItems().add(currency);
            }
        } catch (Exception e) {
            showError("Failed to load currencies from database. Please check your connection.");
        }

        stage.show();
    }

    public void showResult(String result) {
        resultField.setText(result);
        resultField.setStyle("-fx-text-fill: black;");
    }

    public void showError(String error) {
        resultField.setText(error);
        resultField.setStyle("-fx-text-fill: red;");
    }
}
