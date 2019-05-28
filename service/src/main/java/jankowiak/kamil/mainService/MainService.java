package jankowiak.kamil.mainService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import java.util.*;
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

    private Map<String, URL> getDailyInformationAboutDestinationCountry() {
        try {
            String pathWebNews = "https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/NewsSearchAPI?autoCorrect=true&pageNumber=1&pageSize=10&q=" + destinationCountry.getName() + "&safeSearch=false";

            HttpResponse<String> newsWeb = getResponse(pathWebNews);
            NewsApi newsWebSearch = gson.fromJson(newsWeb.body(), NewsApi.class);


            return newsWebSearch.getNewsDetails().stream()
                    .collect(Collectors.toMap(
                            NewsDetails::getDescription,
                            NewsDetails::getUrl,
                            (k, v) -> k,
                            LinkedHashMap::new
                    ));
        }catch (Exception e){
            throw new MyException(e.getMessage() + e.getStackTrace());
        }
    }

    private List<String> currencyConverter(BigDecimal amount)  {
        try {
            String pathForCurrencyConverter = "https://currency-converter5.p.rapidapi.com/currency/convert?from=" + homeland.getCurrency() + "&format=json&amount=" + amount + "&to=" + destinationCountry.getCurrency();

            HttpResponse<String> curr = getResponse(pathForCurrencyConverter);

            return Arrays.stream(curr.body().split(",")).collect(Collectors.toList());
        } catch (Exception e) {
            throw new MyException(e.getMessage() + e.getStackTrace());
        }
    }

    private WeatherApi getWeatherInformation(CountryForWeather countryForWeather) {
        HttpResponse<String> weather;
        try {
            String pathForWeather = "https://weatherbit-v1-mashape.p.rapidapi.com/current?lang=en&lon=" + countryForWeather.getLongitude() + "&lat=" + countryForWeather.getLatitude() + "";
            weather = getResponse(pathForWeather);
        }catch (Exception e){
            throw new MyException("blabla");
        }
        return gson.fromJson(weather.body(), WeatherApi.class);

    }

    private static boolean testForCurrencyConverter() {
        System.out.println("\nWould you like to see the current exchange rate? [yes/no]");
        String answer = sc.next();
        if (answer.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }

    public void getAllInformationAboutDestinationCountry() {

            WeatherApi weatherMain = getWeatherInformation(CountryForWeather.valueOf(destinationCountry.getName()));
            System.out.println(weatherMain);

            boolean testForCurrency = testForCurrencyConverter();
            if (testForCurrency) {
                System.out.println("\nWhat amount do you want to convert?");
                BigDecimal amount = sc.nextBigDecimal();

                List<String> currencyConverter = currencyConverter(amount);
                System.out.println("Tak w oryginale =>>>>>>> " + currencyConverter);
                System.out.println("From: " + currencyConverter.get(1).substring(22, 25));
                System.out.println("To: " + currencyConverter.get(3).substring(33, 36));
                System.out.println("Actual rate: " + currencyConverter.get(5).substring(8, 13));
                System.out.println("Actually for " + amount + " " + currencyConverter.get(1).substring(22,25) + " you get " + currencyConverter.get(6).substring(19, 26) + " " + currencyConverter.get(3).substring(33, 36));
            }

            System.out.println("\nInformation from " + destinationCountry.getName() + " " + LocalDate.now() + "\n");

            Map<String, URL> mapWithInformationAndTheirURL = getDailyInformationAboutDestinationCountry();
            mapWithInformationAndTheirURL.forEach((k, v) -> System.out.println(k + " FOR MORE INFORMATION CLICK => " + v));

    }
}
