package jankowiak.kamil.mainService;

import jankowiak.kamil.enums.CountryForWeather;
import jankowiak.kamil.model.DestinationCountry;
import jankowiak.kamil.model.Homeland;
import jankowiak.kamil.weatherModel.WeatherApi;

import java.net.URL;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class MainService {

    private static NewsService newsService = new NewsService();
    private static WeatherService weatherService = new WeatherService();
    private static Scanner sc = new Scanner(System.in);

    private Homeland homeland;
    private DestinationCountry destinationCountry;

    public MainService(Homeland homeland, DestinationCountry destinationCountry) {
        this.homeland = homeland;
        this.destinationCountry = destinationCountry;
    }

    /*  //https://rapidapi.com/fixer/api/fixer-currency?endpoint=5c119732e4b09c6b17cfa312
    private CurMain getCurrencyConverter(final BigDecimal amount){
        HttpResponse<String> currencyConverter;
        try {
            String pathForCurrencyConverter = "https://fixer-fixer-currency-v1.p.rapidapi.com/convert?from="+destinationCountry.getCurrency()+"&to="+homeland.getCurrency()+"&amount="+amount;
            currencyConverter = getResponse(pathForCurrencyConverter);
        }catch (Exception e){
            throw new MyException("Something wrong with currency converter");
        }
        return gson.fromJson(currencyConverter.body(), CurMain.class);
    }

    private static boolean testForCurrencyConverter() {
        System.out.println("\nWould you like to see the current exchange rate? [yes/no]");
        String answer = sc.next();
        if (answer.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }*/

    private static boolean testForSendingEmail() {
        System.out.println("\nWould you like to get an e-mail with the information you have just read? [yes/no]");
        String answer = sc.next();
        if (answer.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }


    public void getAllInformationAboutDestinationCountry() {


        WeatherApi weatherMain = weatherService.getWeatherInformation(CountryForWeather.valueOf(destinationCountry.getName()));
        System.out.println(weatherMain);

       /* boolean testForCurrency = testForCurrencyConverter();
        if (testForCurrency) {
            System.out.println("\nWhat amount do you want to convert?");
            BigDecimal amount = sc.nextBigDecimal();
            CurMain currencyApi = getCurrencyConverter(amount);
            System.out.println(currencyApi);
        }*/

        System.out.println("\nInformation from " + destinationCountry.getName() + " " + LocalDate.now() + "\n");
        Map<String, URL> map = newsService.getMapWithInformationDetails();
        map.forEach((k,v) -> System.out.println(k + "\n" + v));

        /*System.out.println("Do you want to receive email with informations which you just read?");
        if (testForSendingEmail()){
            System.out.println("Please give me your emaila adress");

        }*/
    }
}
