package jankowiak.kamil.mainService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jankowiak.kamil.currencyModel.CurrencyApi;
import jankowiak.kamil.enums.CountryForWeather;
import jankowiak.kamil.exceptions.MyException;
import jankowiak.kamil.model.DestinationCountry;
import jankowiak.kamil.model.Homeland;
import jankowiak.kamil.newsModel.NewsApi;
import jankowiak.kamil.newsModel.NewsDetails;
import jankowiak.kamil.weatherModel.WeatherApi;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainService {

    private Homeland homeland;
    private DestinationCountry destinationCountry;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Scanner sc = new Scanner(System.in);

    public MainService() {
    }

    public MainService(Homeland homeland, DestinationCountry destinationCountry) {
        this.homeland = homeland;
        this.destinationCountry = destinationCountry;
    }

    private static HttpRequest requestGetForRapidApi(final String path) throws URISyntaxException {

        return HttpRequest.newBuilder()
                .uri(new URI(path))
                .header("X-RapidAPI-Key", "c3d04280ddmsh1c2d1143079affcp1be4f5jsn42acd93c4536")
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();
    }

    private static HttpResponse<String> getResponse(final String path) throws URISyntaxException, IOException, InterruptedException {

        return HttpClient
                .newBuilder()
                .proxy(ProxySelector.getDefault())
                .build()
                .send(requestGetForRapidApi(path), HttpResponse.BodyHandlers.ofString());
    }

    private WeatherApi getWeatherInformation(CountryForWeather countryForWeather) {
        HttpResponse<String> weather;

        try {
            String pathForWeather = "https://weatherbit-v1-mashape.p.rapidapi.com/current?lang=en&lon=" + countryForWeather.getLongitude() + "&lat=" + countryForWeather.getLatitude() + "";
            weather = getResponse(pathForWeather);
        } catch (Exception e) {
            throw new MyException("Something going wrong with weather api");
        }
        return gson.fromJson(weather.body(), WeatherApi.class);

    }

    //https://rapidapi.com/fixer/api/fixer-currency?endpoint=5c119732e4b09c6b17cfa312
    private CurrencyApi getCurrencyConverter(final BigDecimal amount){
        HttpResponse<String> currencyConverter;
        try {
            String pathForCurrencyConverter = "https://fixer-fixer-currency-v1.p.rapidapi.com/convert?from="+destinationCountry.getCurrency()+"&to="+homeland.getCurrency()+"&amount="+amount;
            currencyConverter = getResponse(pathForCurrencyConverter);
        }catch (Exception e){
            throw new MyException("Something wrong with currency converter");
        }
        return gson.fromJson(currencyConverter.body(), CurrencyApi.class);
    }

    private static boolean testForCurrencyConverter() {
        System.out.println("\nWould you like to see the current exchange rate? [yes/no]");
        String answer = sc.next();
        if (answer.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }

    private Map<String, URL> getDailyInformationAboutDestinationCountry() {
        Map<String, URL> mapWithInformationsDetails;
        String pathWebNews = "https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/NewsSearchAPI?autoCorrect=true&pageNumber=1&pageSize=10&q=" + destinationCountry.getName() + "&safeSearch=false";

        try {
            HttpResponse<String> newsResponse = getResponse(pathWebNews);
            NewsApi news = gson.fromJson(newsResponse.body(), NewsApi.class);
            System.out.println(newsResponse.body());
            mapWithInformationsDetails = news.getValue().stream()
                    .collect(Collectors.toMap(
                            NewsDetails::getDescription,
                            NewsDetails::getUrl,
                            (k, v) -> k,
                            LinkedHashMap::new
                    ));
        } catch (Exception e) {
            throw new MyException("Something wrong with informations");
        }

        return mapWithInformationsDetails;
    }

    public void getAllInformationAboutDestinationCountry() {


        WeatherApi weatherMain = getWeatherInformation(CountryForWeather.valueOf(destinationCountry.getName()));
        System.out.println(weatherMain);

        boolean testForCurrency = testForCurrencyConverter();
        if (testForCurrency) {
            System.out.println("\nWhat amount do you want to convert?");
            BigDecimal amount = sc.nextBigDecimal();
            CurrencyApi currencyApi = getCurrencyConverter(amount);
            System.out.println(currencyApi);
        }

        System.out.println("\nInformation from " + destinationCountry.getName() + " " + LocalDate.now() + "\n");

        Map<String, URL> mapWithInformationAndTheirURL = getDailyInformationAboutDestinationCountry();
        mapWithInformationAndTheirURL.forEach((k, v) -> System.out.println(k + " FOR MORE INFORMATION CLICK => " + v));

    }
}
