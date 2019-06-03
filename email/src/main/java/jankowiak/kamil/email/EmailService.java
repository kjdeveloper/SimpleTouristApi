package jankowiak.kamil.email;

import j2html.tags.ContainerTag;
import jankowiak.kamil.enums.CountryForWeather;
import jankowiak.kamil.mainService.NewsService;
import jankowiak.kamil.mainService.WeatherService;
import jankowiak.kamil.model.DestinationCountry;
import jankowiak.kamil.weatherModel.WeatherApi;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import static j2html.TagCreator.*;

public class EmailService {

    private static final String emailAddress = "siwy247@gmail.com";
    private static final String emailPassword = "aneczka247";

    private void send(String to, String title, DestinationCountry destinationCountry) throws MessagingException {
        System.out.println("SENDING EMAIL ...");
        Session session = createSession();
        MimeMessage mimeMessage = new MimeMessage(session);
        prepareEmailMessage(mimeMessage, to, title, createInformationsAboutDestinationCountry(destinationCountry));
        Transport.send(mimeMessage);
        System.out.println("EMAIL SENT");
    }

    private String createInformationsAboutDestinationCountry(DestinationCountry destinationCountry) {
        NewsService newsService = new NewsService();
        WeatherApi weatherService = new WeatherService().getWeatherInformation(CountryForWeather.valueOf(destinationCountry.getName()));

        ContainerTag html = html().attr("lang", "en").with(
                body()
                        .with(
                                header().with(h1(destinationCountry.getName())))
                        .with(
                                header().with(h1("Weather for city: " + weatherService.getData().get(0).getCity_name())))
                        .with(
                                header().with(h3("\n Sunset at: " + weatherService.getData().get(0).getSunset() + " pm.")))
                        .with(
                                header().with(h3("\n Temperature: " + weatherService.getData().get(0).getTemp() + " deg. C")))
                        .with(
                                header().with(h3("\n Pressure: " + weatherService.getData().get(0).getPres() + " hPa")))
                        .with(
                                header().with(h3("\n UV: " + weatherService.getData().get(0).getUv())))
                        .with(
                                header().with(h3("\n " + newsService.getMapWithInformationDetails()
                                        .entrySet()
                                        .stream()
                                        .map(k -> k.getKey() + " =>  " + k.getValue())
                                        .collect(Collectors.toList())))
                        )
        );

        return html.render();
    }

    private void prepareEmailMessage(MimeMessage mimeMessage, String to, String title, String html) throws MessagingException {
        mimeMessage.setContent(html, "text/html; charset=utf-8");
        mimeMessage.setFrom(new InternetAddress(emailAddress));
        mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        mimeMessage.setSubject(title);
    }

    private Session createSession() {

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");


        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailAddress, emailPassword);
            }
        });
    }

    public void sendEmail(String to, DestinationCountry destinationCountry) {

        try {
            send(to, destinationCountry.getName() + " A GREAT PLACE TO TRAVEL :)", destinationCountry);
        } catch (
                MessagingException e) {
            e.printStackTrace();
        }
    }


}
