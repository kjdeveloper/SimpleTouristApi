package jankowiak.kamil.mainmenu;

import jankowiak.kamil.enums.CountryForCurrencyConverter;
import jankowiak.kamil.mainService.MainService;
import jankowiak.kamil.model.DestinationCountry;
import jankowiak.kamil.model.Homeland;


public class App {

    public static void main(String[] args) {

        Homeland homeland = new Homeland("POLAND", "Varsaw", CountryForCurrencyConverter.PLN);
        DestinationCountry destinationCountry = new DestinationCountry("UNITED_KINGDOM", "London", CountryForCurrencyConverter.GBP);
        MainService mainService = new MainService(homeland, destinationCountry);

        mainService.getAllInformationAboutDestinationCountry();

    }
}
