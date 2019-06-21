package jankowiak.kamil.mainService.interfacesForMainService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public interface IResponseForApi {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

}
