package jankowiak.kamil.newsModel;

import java.util.List;
import java.util.Objects;

public class NewsApi {

    private List<NewsDetails> value;

    public NewsApi() {
    }

    public NewsApi(List<NewsDetails> value) {
        this.value = value;
    }

    public List<NewsDetails> getValue() {
        return value;
    }

    public void setValue(List<NewsDetails> value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsApi newsApi = (NewsApi) o;
        return Objects.equals(value, newsApi.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "NewsApi => " + value;
    }
}
