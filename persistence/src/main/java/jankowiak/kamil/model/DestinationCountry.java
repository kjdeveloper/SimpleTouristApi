package jankowiak.kamil.model;


import jankowiak.kamil.enums.Currency;

import java.util.Objects;

public class DestinationCountry {

    private String name;
    private String city;
    private Currency currency;

    public DestinationCountry() {
    }

    public DestinationCountry(String name, String city, Currency currency) {
        this.name = name;
        this.city = city;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DestinationCountry that = (DestinationCountry) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(city, that.city) &&
                currency == that.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, currency);
    }

    @Override
    public String toString() {
        return "DestinationCountry{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", currency=" + currency +
                '}';
    }
}
