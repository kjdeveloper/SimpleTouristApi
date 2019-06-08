package jankowiak.kamil.mainService;

import jankowiak.kamil.exceptions.MyException;
import jankowiak.kamil.model.DestinationCountry;

import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DestinationCountryInfoService implements IResponseForApi {

  /*  public String getInfoAboutDestinationCountry(DestinationCountry destinationCountry) {
        String destinationCountryAfterValidation = destinationCountryValidation(destinationCountry.getName());
        String pathForInfo = "https://restcountries-v1.p.rapidapi.com/name/" + destinationCountryAfterValidation;

        HttpResponse<String> infoResponse = getResponse(pathForInfo);
        System.out.println(infoResponse.body());
        return gson.fromJson(infoResponse.body(), );
    }*/

    private String destinationCountryValidation(String destinationCountry) {
        if (destinationCountry.split(" ").length > 1) {
            return destinationCountry.replace(" ", "%20");
        }
        return destinationCountry;
    }

    @Override
    public HttpRequest requestGetForRapidApi(String path) {
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

    @Override
    public HttpResponse<String> getResponse(String path) {
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
