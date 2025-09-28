package controller;

import model.Currency;
import model.CurrencyModel;
import view.CurrencyConverterView;

public class CurrencyConverter {
    private CurrencyModel model;
    private CurrencyConverterView view;

    public CurrencyConverter(CurrencyConverterView view) {
        this.view = view;
        this.model = new CurrencyModel();
    }

    public CurrencyModel getModel() {
        return model;
    }

    public void convert(String amountText, Currency from, Currency to) {
        try {
            double amount = Double.parseDouble(amountText);
            double result = model.convert(amount, from, to);
            view.showResult(String.valueOf(result));
        } catch (Exception e) {
            view.showError("Invalid input");
        }
    }
}
