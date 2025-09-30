package dao;

import entity.Currency;
import datasource.MariadbConnect;
import java.sql.*;
import java.util.*;

public class CurrencyDao {

    public List<Currency> getAllCurrencies() {
        Connection conn = MariadbConnect.getConnection();
        String sql = "SELECT id, abbreviation, name, exchange_rate FROM currency ORDER BY abbreviation";
        List<Currency> currencies = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String abbreviation = rs.getString(2);
                String name = rs.getString(3);
                double exchangeRate = rs.getDouble(4);
                Currency currency = new Currency(id, abbreviation, name, exchangeRate);
                currencies.add(currency);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currencies;
    }

    public double getExchangeRate(String abbreviation) {
        Connection conn = MariadbConnect.getConnection();
        String sql = "SELECT exchange_rate FROM currency WHERE abbreviation = ?";
        double exchangeRate = 0.0;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, abbreviation);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                exchangeRate = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error: Unable to fetch exchange rate for " + abbreviation);
        }

        return exchangeRate;
    }

    public Currency getCurrency(String abbreviation) {
        Connection conn = MariadbConnect.getConnection();
        String sql = "SELECT id, abbreviation, name, exchange_rate FROM currency WHERE abbreviation = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, abbreviation);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt(1);
                String abbrev = rs.getString(2);
                String name = rs.getString(3);
                double exchangeRate = rs.getDouble(4);
                return new Currency(id, abbrev, name, exchangeRate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

