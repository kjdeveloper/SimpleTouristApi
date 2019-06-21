package jankowiak.kamil.mainService.interfacesForMainService;

import jankowiak.kamil.exceptions.MyException;
import jankowiak.kamil.jokeModel.JokeApi;

import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface JokeService extends IResponseForApi {


    static JokeApi getJoke() {
        String pathForJoke = "https://jokeapi.p.rapidapi.com/category/Any?format=json4";

        HttpResponse<String> jokeResponse = getResponse(pathForJoke);
        return gson.fromJson(jokeResponse.body(), JokeApi.class);
    }


    static HttpRequest requestGetForRapidApi(String path) {
        HttpRequest httpRequest = null;
        try {
            httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(path))
                    .header("X-RapidAPI-Key", "c3d04280ddmsh1c2d1143079affcp1be4f5jsn42acd93c4536")
                    .version(HttpClient.Version.HTTP_2)
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return httpRequest;
    }

    static HttpResponse<String> getResponse(String path) {
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
}
