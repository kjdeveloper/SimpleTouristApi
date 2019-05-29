package jankowiak.kamil.currencyModel;

import java.util.Objects;

public class CurrencyApi {

    private boolean success;
    private Query query;
    private Info info;
    private String result;

    public CurrencyApi() {
    }

    public CurrencyApi(boolean success, Query query, Info info, String result) {
        this.success = success;
        this.query = query;
        this.info = info;
        this.result = result;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyApi that = (CurrencyApi) o;
        return success == that.success &&
                Objects.equals(query, that.query) &&
                Objects.equals(info, that.info) &&
                Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, query, info, result);
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
