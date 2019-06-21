package jankowiak.kamil.mainService.interfacesForMainService;

import jankowiak.kamil.enums.CountryForWeather;
import jankowiak.kamil.exceptions.MyException;
import jankowiak.kamil.weatherModel.WeatherApi;

import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface WeatherService extends IResponseForApi {

    static WeatherApi getWeatherInformation(CountryForWeather countryForWeather) {

        String pathForWeather = "https://weatherbit-v1-mashape.p.rapidapi.com/current?lang=en&lon=" + countryForWeather.getLongitude() + "&lat=" + countryForWeather.getLatitude() + "";
        HttpResponse<String> weather = getResponse(pathForWeather);

        return gson.fromJson(weather.body(), WeatherApi.class);

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
            throw new MyException("Something wrong with weather response");
        }
        return httpResponse;
    }
}
