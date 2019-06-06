package jankowiak.kamil.model;

import jankowiak.kamil.enums.CountryForCurrencyConverter;

import java.util.Objects;

public class Homeland {

    private String name;
    private String capital;
    private CountryForCurrencyConverter countryForCurrencyConverter;

    public Homeland() {
    }

    public Homeland(String name, String capital, CountryForCurrencyConverter countryForCurrencyConverter) {
        this.name = name;
        this.capital = capital;
        this.countryForCurrencyConverter = countryForCurrencyConverter;
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

    public CountryForCurrencyConverter getCountryForCurrencyConverter() {
        return countryForCurrencyConverter;
    }

    public void setCountryForCurrencyConverter(CountryForCurrencyConverter countryForCurrencyConverter) {
        this.countryForCurrencyConverter = countryForCurrencyConverter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Homeland homeland = (Homeland) o;
        return Objects.equals(name, homeland.name) &&
                Objects.equals(capital, homeland.capital) &&
                countryForCurrencyConverter == homeland.countryForCurrencyConverter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital, countryForCurrencyConverter);
    }

    @Override
    public String toString() {
        return "Homeland{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", countryForCurrencyConverter=" + countryForCurrencyConverter +
                '}';
    }
}
