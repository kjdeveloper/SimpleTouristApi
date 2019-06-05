package jankowiak.kamil.mainService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jankowiak.kamil.exceptions.MyException;
import jankowiak.kamil.model.DestinationCountry;
import jankowiak.kamil.newsModel.NewsApi;
import jankowiak.kamil.newsModel.NewsDetails;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class NewsService {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private Map<String, URL> mapWithInformationDetails;

    private DestinationCountry destinationCountry;

    public NewsService(DestinationCountry destinationCountry) {
        this.destinationCountry = destinationCountry;
        this.mapWithInformationDetails = getMapWithInformationDetails();
    }

    public Map<String, URL> getMapWithInformationDetails() {
        String pathWebNews = "https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/NewsSearchAPI?autoCorrect=true&pageNumber=1&pageSize=10&q=" + destinationCountry.getName() + "&safeSearch=false";

        try {
            HttpResponse<String> newsResponse = getResponse(pathWebNews);
            NewsApi news = gson.fromJson(newsResponse.body(), NewsApi.class);

            mapWithInformationDetails = news.getValue().stream()
                    .collect(Collectors.toMap(
                            NewsDetails::getDescription,
                            NewsDetails::getUrl,
                            (k, v) -> k,
                            LinkedHashMap::new
                    ));
        } catch (Exception e) {
            throw new MyException("Something wrong with informations map");
        }

        return mapWithInformationDetails;
    }

    private static HttpRequest requestGetForRapidApi(final String path) throws URISyntaxException {

        return HttpRequest.newBuilder()
                .uri(new URI(path))
                .header("X-RapidAPI-Key", "c3d04280ddmsh1c2d1143079affcp1be4f5jsn42acd93c4536")
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();
    }

    private static HttpResponse<String> getResponse(final String path) {

        HttpResponse<String> httpResponse;
        try {
            httpResponse = HttpClient
                    .newBuilder()
                    .proxy(ProxySelector.getDefault())
                    .build()
                    .send(requestGetForRapidApi(path), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new MyException("Something wrong with informations response");
        }
        return httpResponse;
    }

    @Override
    public String toString() {
        return mapWithInformationDetails + "\n";
    }
}


