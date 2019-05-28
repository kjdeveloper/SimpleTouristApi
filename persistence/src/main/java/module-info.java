module persistence {

    exports jankowiak.kamil.model;
    exports jankowiak.kamil.enums;
    exports jankowiak.kamil.newsModel;
    exports jankowiak.kamil.weatherModel;

    opens jankowiak.kamil.model;
    opens jankowiak.kamil.newsModel;
    opens jankowiak.kamil.weatherModel;

}