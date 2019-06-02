package jankowiak.kamil.newsModel;

import java.net.URL;
import java.util.Objects;

public class NewsDetails {

    private String title;
    private URL url;
    private String description;

    public NewsDetails() {
    }

    public NewsDetails(String title, URL url, String description) {
        this.title = title;
        this.url = url;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsDetails that = (NewsDetails) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(url, that.url) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, url, description);
    }

    @Override
    public String toString() {
        return "NewsDetails: " +
                "title: " + title +
                "\n url: " + url +
                ", description: " + description;
    }
}
