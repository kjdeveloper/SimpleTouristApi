package jankowiak.kamil.currencyModel;

import java.util.Objects;

public class Info {

    private double rate;

    public Info() {
    }

    public Info(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return Double.compare(info.rate, rate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate);
    }

    @Override
    public String toString() {
        return "Info{" +
                "rate=" + rate +
                '}';
    }
}
