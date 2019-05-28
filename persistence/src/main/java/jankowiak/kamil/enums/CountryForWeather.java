package jankowiak.kamil.enums;

public enum CountryForWeather {
    ALBANIA(41, 20),
    ANDORA(42.54, 1.57),
    ARMENIA(40.76, 44.67),
    AUSTRIA(47.2, 13.20),
    AZERBAIJAN(40.4, 47.8),
    BELARUS(53.43, 27.7),
    BELGIUM(50.64, 4.6),
    BOSNIA_AND_HERZEGOVINA(44.31, 17.6),
    BULGARIA(42.61, 25.49),
    CROATIA(45.57, 17),
    CYPRUS(35, 33.15),
    CZECH_REPUBLIC(50, 15.5),
    DENMARK(55.9, 9.3),
    ESTONIA(59, 25.3),
    FINLAND(60.8, 25),
    FRANCE(48.5, 2.5),
    GEORGIA(41.7, 44),
    GERMANY(52.6, 12.78),
    GREECE(39.25, 21.9),
    HUNGARY(47.18, 19.51),
    ICELAND(64.31, -21.3),
    IRELAND(53.42, -6.5),
    ITALY(42.64, 12.7),
    KAZAKHSTAN(47.23, 65.21),
    KOSOVO(42.6, 21),
    LATVIA(57, 25),
    LIECHTENSTEIN(47, 9.6),
    LITHUANIA(55.4, 23.7),
    LUXEMBOURG(50, 6.1),
    MALTA(35.9, 14.5),
    MOLDAVA(47.1, 28.9),
    MONACO(43.73, 7.42),
    MONTENEGRO(42.8, 19.2),
    NETHERLANDS(52.3, 4.9),
    NORWAY(60.13, 10.7),
    POLAND(52.2, 17.2),
    PORTUGAL(38.9, -9.16),
    ROMANIA(46, 24.7),
    SAN_MARINO(44, 12.5),
    SERBIA(44.15, 20.6),
    SLOVAKIA(49, 19.4),
    SLOVENIA(45.8, 14.5),
    SPAIN(41.6, 1.83),
    SWEDEN(59, 16.7),
    SWITZERLAND(47, 8.4),
    TURKEY(39, 35),
    UKRAINE(50, 31.2),
    UNITED_KINGDOM(53.1, -1.8),
    VATICAN_CITY(41.90, 12.45);

    private double latitude;
    private double longitude;

    CountryForWeather(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "CountryForWeather: " +
                "latitude: " + latitude +
                "longitude: " + longitude;
    }
}

