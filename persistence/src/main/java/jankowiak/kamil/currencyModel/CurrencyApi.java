package jankowiak.kamil.currencyModel;

import java.util.Objects;

public class CurrencyApi {

    private CurrencyDetails info;

    public CurrencyApi() {
    }

    public CurrencyApi(CurrencyDetails info) {
        this.info = info;
    }

    public CurrencyDetails getInfo() {
        return info;
    }

    public void setInfo(CurrencyDetails info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyApi currencyApi = (CurrencyApi) o;
        return Objects.equals(info, currencyApi.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info);
    }

    @Override
    public String toString() {
        return "CurrencyApi{" +
                "info=" + info +
                '}';
    }
}
