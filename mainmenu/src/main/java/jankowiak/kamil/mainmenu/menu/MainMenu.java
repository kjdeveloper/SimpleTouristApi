package jankowiak.kamil.mainmenu.menu;

import jankowiak.kamil.email.EmailService;
import jankowiak.kamil.mainService.MainService;
import jankowiak.kamil.model.DestinationCountry;
import jankowiak.kamil.model.Homeland;

import java.util.Scanner;

public class MainMenu {

    private static Scanner sc = new Scanner(System.in);
    private EmailService emailService = new EmailService();
    private Homeland homeland;
    private DestinationCountry destinationCountry;
    private String emailAdress;

    public MainMenu(Homeland homeland, DestinationCountry destinationCountry, String emailAdress) {
        this.emailAdress = emailAdress;
        this.homeland = homeland;
        this.destinationCountry = destinationCountry;

        MainService mainService = new MainService(homeland, destinationCountry);
        mainService.getAllInformationAboutDestinationCountry();

        boolean testForEmail = testForSendingEmail();
        if (testForEmail){
            emailService.sendEmail(emailAdress, destinationCountry);
        }

    }

    private static boolean testForSendingEmail() {
        System.out.println("\nWould you like to get an e-mail with the information you have just read? [yes/no]");
        String answer = sc.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }

}
