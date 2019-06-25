package jankowiak.kamil.mainService;

import jankowiak.kamil.currencyModel.CurrencyConverterApi;
import jankowiak.kamil.enums.CountryForWeather;
import jankowiak.kamil.jokeModel.JokeApi;
import jankowiak.kamil.mainService.interfacesForMainService.*;
import jankowiak.kamil.model.DestinationCountry;
import jankowiak.kamil.model.Homeland;
import jankowiak.kamil.weatherModel.WeatherApi;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class MainService {

    private static Scanner sc = new Scanner(System.in);

    private Homeland homeland;
    private DestinationCountry destinationCountry;

    public MainService() {
    }

    public MainService(Homeland homeland, DestinationCountry destinationCountry) {
        this.homeland = homeland;
        this.destinationCountry = destinationCountry;
    }

    private WeatherApi getWeather(){
        System.out.println("Weather in " + destinationCountry.getName());
        return WeatherService.getWeatherInformation(CountryForWeather.valueOf(destinationCountry.getName()));
    }

    private CurrencyConverterApi getCurrencyConverter(final BigDecimal amount){
        if (amount == null){
            amount.equals(BigDecimal.ONE);
        }
        return CurrencyService.getCurrencyConverter(homeland.getCountryForCurrencyConverter(), destinationCountry.getCountryForCurrencyConverter(), amount);
    }

    private Map<String, URL> getNewsAboutDestinationCountry(){
        System.out.println("\nInformation from " + destinationCountry.getName() + " " + LocalDate.now() + "\n");
        return NewsService.getMapWithInformationDetails(destinationCountry);
    }

    private JokeApi getJoke(){
        System.out.println("\nJoke for today :)");
        return JokeService.getJoke();
    }

    public void getAllInformationAboutDestinationCountry() {


        WeatherApi weatherApi = getWeather();
        System.out.println(weatherApi.getData());

        System.out.println("\nWhat amount do you want to convert?");
        BigDecimal amount = sc.nextBigDecimal();
        CurrencyConverterApi currencyApi = getCurrencyConverter(amount);
        System.out.println(currencyApi);

        Map<String, URL> map = getNewsAboutDestinationCountry();
        map.forEach((k, v) -> System.out.println(k + "\n" + v));

        JokeApi joke = getJoke();
        System.out.println(joke);

    }
}

