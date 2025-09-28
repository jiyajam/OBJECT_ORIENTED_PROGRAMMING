package model;

import java.util.ArrayList;
import java.util.List;

public class CurrencyModel {
    private List<Currency> currencies;

    public CurrencyModel() {
        currencies = new ArrayList<>();
        currencies.add(new Currency("EUR(Euro)", 1.0));
        currencies.add(new Currency("JPY(Japanese yen)", 174.24));
        currencies.add(new Currency("GBP(British pound)", 0.87));
        currencies.add(new Currency("KWD(Kuwaiti dinar)", 0.36));
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public double convert(double amount, Currency from, Currency to) {
        return (amount / from.getRate()) * to.getRate();
    }
}

