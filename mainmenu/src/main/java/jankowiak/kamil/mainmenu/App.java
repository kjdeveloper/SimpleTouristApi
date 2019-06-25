package jankowiak.kamil.mainmenu;

import jankowiak.kamil.enums.CountryForCurrencyConverter;
import jankowiak.kamil.mainmenu.menu.MainMenu;
import jankowiak.kamil.model.DestinationCountry;
import jankowiak.kamil.model.Homeland;


public class App {

    public static void main(String[] args) {

        String customerEmail = "kamiljankowiak247@gmail.com";
        Homeland homeland = new Homeland("POLAND", "Varsaw", CountryForCurrencyConverter.PLN);
        DestinationCountry destinationCountry = new DestinationCountry("UNITED_KINGDOM", "London", CountryForCurrencyConverter.GBP);
        new MainMenu(homeland, destinationCountry, customerEmail);

    }
}
