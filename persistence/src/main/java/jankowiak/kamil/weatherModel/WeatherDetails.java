package jankowiak.kamil.weatherModel;

import java.util.Objects;

public class WeatherDetails {

    private String city_name;
    private String ob_time;
    private String uv;
    private double pres;
    private String sunset;
    private double temp;

    public WeatherDetails() {
    }

    public WeatherDetails(String city_name, String ob_time, String uv, double pres, String sunset, double temp) {
        this.city_name = city_name;
        this.ob_time = ob_time;
        this.uv = uv;
        this.pres = pres;
        this.sunset = sunset;
        this.temp = temp;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getOb_time() {
        return ob_time;
    }

    public void setOb_time(String ob_time) {
        this.ob_time = ob_time;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public double getPres() {
        return pres;
    }

    public void setPres(double pres) {
        this.pres = pres;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherDetails that = (WeatherDetails) o;
        return Double.compare(that.pres, pres) == 0 &&
                Double.compare(that.temp, temp) == 0 &&
                Objects.equals(city_name, that.city_name) &&
                Objects.equals(ob_time, that.ob_time) &&
                Objects.equals(uv, that.uv) &&
                Objects.equals(sunset, that.sunset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city_name, ob_time, uv, pres, sunset, temp);
    }

    @Override
    public String toString() {
        return "Weather details: " +
                "city name: " + city_name +
                ", ob time: " + ob_time +
                ", uv: " + uv +
                ", pressure: " + pres +
                ", sunset: " + sunset +
                ", temp: " + temp;
    }
}
