module persistence {

    exports jankowiak.kamil.enums;
    exports jankowiak.kamil.model;
    exports jankowiak.kamil.newsModel;
    exports jankowiak.kamil.weatherModel;
    exports jankowiak.kamil.currencyModel;

    opens jankowiak.kamil.model;
    opens jankowiak.kamil.newsModel;
    opens jankowiak.kamil.weatherModel;
    opens jankowiak.kamil.currencyModel;


}