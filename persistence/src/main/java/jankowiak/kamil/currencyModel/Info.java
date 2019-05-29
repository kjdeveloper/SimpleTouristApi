package jankowiak.kamil.currencyModel;

import java.util.Objects;

public class Info {

    private String rate;

    public Info() {
    }

    public Info(String rate) {
        this.rate = rate;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return Objects.equals(rate, info.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate);
    }

    @Override
    public String toString() {
        return "Info{" +
                "rate='" + rate + '\'' +
                '}';
    }
}
