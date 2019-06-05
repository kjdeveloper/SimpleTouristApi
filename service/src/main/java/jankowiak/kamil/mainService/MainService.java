package jankowiak.kamil.mainService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jankowiak.kamil.currencyModel.CurrencyApi;
import jankowiak.kamil.exceptions.MyException;
import jankowiak.kamil.model.DestinationCountry;
import jankowiak.kamil.model.Homeland;

import java.math.BigDecimal;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainService {

    private static NewsService newsService;
    private static WeatherService weatherService = new WeatherService();
    private static Scanner sc = new Scanner(System.in);

    private Homeland homeland;
    private DestinationCountry destinationCountry;

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

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


    private static boolean testForSendingEmail() {
        System.out.println("\nWould you like to get an e-mail with the information you have just read? [yes/no]");
        String answer = sc.next();
        if (answer.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }

    public void getAllInformationAboutDestinationCountry() {

        System.out.println("\nWhat amount you want to convert?");
        BigDecimal amount = sc.nextBigDecimal();
        CurrencyApi currencyApi = getCurrencyConverter(amount);
        System.out.println(currencyApi);


    }

   /* public void getAllInformationAboutDestinationCountry() {


        WeatherApi weatherMain = weatherService.getWeatherInformation(CountryForWeather.valueOf(destinationCountry.getName()));
        System.out.println(weatherMain);



        System.out.println("\nInformation from " + destinationCountry.getName() + " " + LocalDate.now() + "\n");
        Map<String, URL> map = newsService.getMapWithInformationDetails();
        map.forEach((k,v) -> System.out.println(k + "\n" + v));

        *//*System.out.println("Do you want to receive email with informations which you just read?");
        if (testForSendingEmail()){
            System.out.println("Please give me your emaila adress");

        }*/
    }

