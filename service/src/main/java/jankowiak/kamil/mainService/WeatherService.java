package jankowiak.kamil.mainService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jankowiak.kamil.enums.CountryForWeather;
import jankowiak.kamil.exceptions.MyException;
import jankowiak.kamil.weatherModel.WeatherApi;

import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class WeatherService {


    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

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
            throw new MyException("Something goes wrong with weather");
        }
        return httpResponse;
    }

    public WeatherApi getWeatherInformation(CountryForWeather countryForWeather) {

        String pathForWeather = "https://weatherbit-v1-mashape.p.rapidapi.com/current?lang=en&lon=" + countryForWeather.getLongitude() + "&lat=" + countryForWeather.getLatitude() + "";
        HttpResponse<String> weather = getResponse(pathForWeather);

        return gson.fromJson(weather.body(), WeatherApi.class);

    }

}
