package jankowiak.kamil.modelForNewsApi;

import java.util.List;
import java.util.Objects;

public class NewsApi {

    private List<NewsDetails> newsDetails;

    public NewsApi() {
    }

    public NewsApi(List<NewsDetails> newsDetails) {
        this.newsDetails = newsDetails;
    }

    public List<NewsDetails> getNewsDetails() {
        return newsDetails;
    }

    public void setNewsDetails(List<NewsDetails> newsDetails) {
        this.newsDetails = newsDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsApi newsApi = (NewsApi) o;
        return Objects.equals(newsDetails, newsApi.newsDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsDetails);
    }

    @Override
    public String toString() {
        return "NewsApi => " + newsDetails;
    }
}
