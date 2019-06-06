package jankowiak.kamil.model;


import jankowiak.kamil.enums.CountryForCurrencyConverter;

import java.util.Objects;

public class DestinationCountry {

    private String name;
    private String city;
    private CountryForCurrencyConverter countryForCurrencyConverter;

    public DestinationCountry() {
    }

    public DestinationCountry(String name, String city, CountryForCurrencyConverter countryForCurrencyConverter) {
        this.name = name;
        this.city = city;
        this.countryForCurrencyConverter = countryForCurrencyConverter;
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
        DestinationCountry that = (DestinationCountry) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(city, that.city) &&
                countryForCurrencyConverter == that.countryForCurrencyConverter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, countryForCurrencyConverter);
    }

    @Override
    public String toString() {
        return "DestinationCountry{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", countryForCurrencyConverter=" + countryForCurrencyConverter +
                '}';
    }
}
