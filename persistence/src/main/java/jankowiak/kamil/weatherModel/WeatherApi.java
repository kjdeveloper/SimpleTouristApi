package jankowiak.kamil.weatherModel;

import java.util.List;
import java.util.Objects;

public class WeatherApi {

    private List<WeatherDetails> data;

    public WeatherApi() {
    }

    public WeatherApi(List<WeatherDetails> data) {
        this.data = data;
    }

    public List<WeatherDetails> getData() {
        return data;
    }

    public void setData(List<WeatherDetails> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherApi that = (WeatherApi) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "Ob Time" + data.get(0).getCity_name() +
         "UV" + data.get(0).getUv()  +
         "Pressure" + data.get(0).getPres()  +
         "Sunset" + data.get(0).getSunset() +
         "Temperature" + data.get(0).getTemp() + ".";
    }
}
