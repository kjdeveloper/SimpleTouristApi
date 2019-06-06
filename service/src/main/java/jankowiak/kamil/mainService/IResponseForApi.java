package jankowiak.kamil.mainService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface IResponseForApi {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    HttpRequest requestGetForRapidApi(String path);

    HttpResponse<String> getResponse(String path);
}
