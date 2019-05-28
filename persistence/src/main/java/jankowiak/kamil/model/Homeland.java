package jankowiak.kamil.model;

import jankowiak.kamil.enums.Currency;

import java.util.Objects;

public class Homeland {

    private String name;
    private String capital;
    private Currency currency;

    public Homeland() {
    }

    public Homeland(String name, String capital, Currency currency) {
        this.name = name;
        this.capital = capital;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
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
        Homeland homeland = (Homeland) o;
        return Objects.equals(name, homeland.name) &&
                Objects.equals(capital, homeland.capital) &&
                currency == homeland.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital, currency);
    }

    @Override
    public String toString() {
        return "Homeland{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", currency=" + currency +
                '}';
    }
}
