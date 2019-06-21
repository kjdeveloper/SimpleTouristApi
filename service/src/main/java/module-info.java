module service {
    exports jankowiak.kamil.mainService;
    exports jankowiak.kamil.mainService.interfacesForMainService;

    requires persistence;
    requires gson;
    requires java.sql;
    requires java.net.http;
    requires exceptions;

}