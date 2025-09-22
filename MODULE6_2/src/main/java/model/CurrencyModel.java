package model;

import java.util.ArrayList;
import java.util.List;

public class CurrencyModel {
    private List<Currency> currencies;

    public CurrencyModel() {
        currencies = new ArrayList<>();
        currencies.add(new Currency("EUR", 1.0));
        currencies.add(new Currency("JPY", 174.24));
        currencies.add(new Currency("GBP", 0.87));
        currencies.add(new Currency("KWD", 0.36));
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public double convert(double amount, Currency from, Currency to) {
        return (amount / from.getRate()) * to.getRate();
    }
}

