package jankowiak.kamil.currencyModel;

import java.util.Objects;

public class CurMain {

    private CurrencyApi info;

    public CurMain() {
    }

    public CurMain(CurrencyApi info) {
        this.info = info;
    }

    public CurrencyApi getInfo() {
        return info;
    }

    public void setInfo(CurrencyApi info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurMain curMain = (CurMain) o;
        return Objects.equals(info, curMain.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info);
    }

    @Override
    public String toString() {
        return "CurMain{" +
                "info=" + info +
                '}';
    }
}
