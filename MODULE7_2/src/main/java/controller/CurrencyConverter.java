package controller;

import entity.Currency;
import dao.CurrencyDao;
import view.CurrencyConverterView;
import java.util.List;
import java.util.ArrayList;

public class CurrencyConverter {

    private CurrencyDao currencyDao;
    private CurrencyConverterView view;

    public CurrencyConverter(CurrencyConverterView view) {
        this.view = view;
        this.currencyDao = new CurrencyDao();
    }

    public List<Currency> getCurrencies() {
        try {
            return currencyDao.getAllCurrencies();
        } catch (Exception e) {
            view.showError("Database connection error. Please check your connection.");
            return new ArrayList<>();
        }
    }

    public void convert(String amountText, Currency from, Currency to) {
        try {
            double amount = Double.parseDouble(amountText);

            // Get exchange rates from database
            double fromRate = currencyDao.getExchangeRate(from.getAbbreviation());
            double toRate = currencyDao.getExchangeRate(to.getAbbreviation());

            // Convert: amount in source currency -> USD -> target currency
            double result = (amount / fromRate) * toRate;

            view.showResult(String.format("%.2f", result));

        } catch (NumberFormatException e) {
            view.showError("Invalid amount. Please enter a valid number.");
        } catch (RuntimeException e) {
            view.showError("Database error: " + e.getMessage());
        } catch (Exception e) {
            view.showError("An error occurred during conversion.");
        }
    }
}

