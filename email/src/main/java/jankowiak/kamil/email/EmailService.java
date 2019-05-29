package jankowiak.kamil.email;

import j2html.tags.Tag;
import jankowiak.kamil.enums.CountryForWeather;
import jankowiak.kamil.mainService.NewsService;
import jankowiak.kamil.mainService.WeatherService;
import jankowiak.kamil.model.DestinationCountry;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

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

    private Tag createInformationsAboutDestinationCountry(DestinationCountry destinationCountry) {
        NewsService newsService = new NewsService();
        WeatherService weatherService = new WeatherService();
        return html(
                body(
                        h1("Weather in " + destinationCountry.getName()),
                        p(weatherService.getWeatherInformation(CountryForWeather.valueOf(destinationCountry.getName())).toString()),

                        h1("News in " + destinationCountry.getName()),
                        p(newsService.toString())
                )
        );
    }

    private void prepareEmailMessage(MimeMessage mimeMessage, String to, String title, Tag html) throws MessagingException {
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
            send(to, destinationCountry.getName(), destinationCountry);
        } catch (
                MessagingException e) {
            e.printStackTrace();
        }
    }


}
