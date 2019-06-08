package jankowiak.kamil.mainService;

import jankowiak.kamil.currencyModel.CurrencyConverterApi;
import jankowiak.kamil.enums.CountryForWeather;
import jankowiak.kamil.jokeModel.Category;
import jankowiak.kamil.jokeModel.JokeApi;
import jankowiak.kamil.model.DestinationCountry;
import jankowiak.kamil.model.Homeland;
import jankowiak.kamil.weatherModel.WeatherApi;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class MainService {

    private static NewsService newsService = new NewsService();
    private static WeatherService weatherService = new WeatherService();
    private static CurrencyService currencyConverterService = new CurrencyService();
    private static JokeService jokeService = new JokeService();
    private static Scanner sc = new Scanner(System.in);

    private Homeland homeland;
    private DestinationCountry destinationCountry;

    public MainService() {
    }

    public MainService(Homeland homeland, DestinationCountry destinationCountry) {
        this.homeland = homeland;
        this.destinationCountry = destinationCountry;
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

        WeatherApi weatherApi = weatherService.getWeatherInformation(CountryForWeather.valueOf(destinationCountry.getName()));
        System.out.println(weatherApi.getData());

        System.out.println("\nWhat amount do you want to convert?");
        BigDecimal amount = sc.nextBigDecimal();
        CurrencyConverterApi currencyApi = currencyConverterService.getCurrencyConverter(homeland.getCountryForCurrencyConverter(), destinationCountry.getCountryForCurrencyConverter(), amount);
        System.out.println(currencyApi);


        System.out.println("\nInformation from " + destinationCountry.getName() + " " + LocalDate.now() + "\n");
        Map<String, URL> map = newsService.getMapWithInformationDetails(destinationCountry);
        map.forEach((k, v) -> System.out.println(k + "\n" + v));

        System.out.println("\nJoke for today :)");
        JokeApi joke = jokeService.getJoke();
        System.out.println(joke);

        /*System.out.println("Do you want to receive email with informations which you just read?");
        if (testForSendingEmail()){
            System.out.println("Please give me your email adress");

        }*/
    }
}

