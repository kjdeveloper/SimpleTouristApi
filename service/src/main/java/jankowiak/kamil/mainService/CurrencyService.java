package jankowiak.kamil.mainService;

import jankowiak.kamil.currencyModel.CurrencyConverterResponse;
import jankowiak.kamil.enums.CountryForCurrencyConverter;
import jankowiak.kamil.exceptions.MyException;

import java.math.BigDecimal;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyService implements IResponseForApi {

    @Override
    public HttpRequest requestGetForRapidApi(String path) {
        HttpRequest httpRequest = null;
        try {
            httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(path))
                    .header("X-RapidAPI-Key", "c3d04280ddmsh1c2d1143079affcp1be4f5jsn42acd93c4536")
                    .version(HttpClient.Version.HTTP_2)
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return httpRequest;
    }

    @Override
    public HttpResponse<String> getResponse(String path) {
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

    public CurrencyConverterResponse getCurrencyConverter(CountryForCurrencyConverter from, CountryForCurrencyConverter to, BigDecimal amount){
        String pathForCurrencyConverter = "https://fixer-fixer-currency-v1.p.rapidapi.com/convert?from="+from.name()+"&to="+to.name()+"&amount="+amount;
        CurrencyConverterResponse currencyConvert = null;
        try {
            HttpResponse<String> newsResponse = getResponse(pathForCurrencyConverter);
            currencyConvert = gson.fromJson(newsResponse.body(), CurrencyConverterResponse.class);

        } catch (Exception e) {
            throw new MyException("Something wrong with currency converter");
        }

        return currencyConvert;
    }


}
