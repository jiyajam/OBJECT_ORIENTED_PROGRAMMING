package entity;

public class Currency {

    private int id;
    private String abbreviation;
    private String name;
    private double exchangeRate;

    public Currency(String abbreviation, String name, double exchangeRate) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.exchangeRate = exchangeRate;
    }

    public Currency(int id, String abbreviation, String name, double exchangeRate) {
        this.id = id;
        this.abbreviation = abbreviation;
        this.name = name;
        this.exchangeRate = exchangeRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return abbreviation + " (" + name + ")";
    }
}
