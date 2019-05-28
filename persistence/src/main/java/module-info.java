module persistence {

    exports jankowiak.kamil.model;
    exports jankowiak.kamil.enums;
    exports jankowiak.kamil.modelForNewsApi;
    exports jankowiak.kamil.modelForWeatherApi;

    opens jankowiak.kamil.model;
    opens jankowiak.kamil.modelForNewsApi;
    opens jankowiak.kamil.modelForWeatherApi;

}