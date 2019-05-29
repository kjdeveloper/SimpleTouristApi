package jankowiak.kamil.currencyModel;

import java.util.List;
import java.util.Objects;

public class CurrencyApi {

    private List<Query> query;
    private List<Info> info;
    private String result;

    public CurrencyApi() {
    }

    public CurrencyApi(List<Query> query, List<Info> info, String result) {
        this.query = query;
        this.info = info;
        this.result = result;
    }

    public List<Query> getQuery() {
        return query;
    }

    public void setQuery(List<Query> query) {
        this.query = query;
    }

    public List<Info> getInfo() {
        return info;
    }

    public void setInfo(List<Info> info) {
        this.info = info;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyApi that = (CurrencyApi) o;
        return Objects.equals(query, that.query) &&
                Objects.equals(info, that.info) &&
                Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(query, info, result);
    }

    @Override
    public String toString() {
        return "CurrencyApi{" +
                "query=" + query +
                ", info=" + info +
                ", result='" + result + '\'' +
                '}';
    }
}
