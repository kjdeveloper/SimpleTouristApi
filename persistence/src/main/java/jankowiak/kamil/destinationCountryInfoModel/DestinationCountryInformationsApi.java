package jankowiak.kamil.destinationCountryInfoModel;

import java.util.List;
import java.util.Objects;

public class DestinationCountryInformationsApi {

	private String name;
	private String capital;
	private List<AltSpellingsItem> altSpellings;
	private String region;
	private String subregion;
	private int population;
	private String demonym;
	private int area;
	private double gini;
	private List<TimezonesItem> timezones;
	private List<BordersItem> borders;
	private String nativeName;
	private String numericCode;
	private List<LanguagesItem> languages;

	public DestinationCountryInformationsApi() {
	}

	private List<CurrenciesItem> currencies;

	public void setArea(int area){
		this.area = area;
	}

	public int getArea(){
		return area;
	}

	public void setNativeName(String nativeName){
		this.nativeName = nativeName;
	}

	public String getNativeName(){
		return nativeName;
	}

	public void setCapital(String capital){
		this.capital = capital;
	}

	public String getCapital(){
		return capital;
	}

	public void setDemonym(String demonym){
		this.demonym = demonym;
	}

	public String getDemonym(){
		return demonym;
	}

	public void setLanguages(List<LanguagesItem> languages){
		this.languages = languages;
	}

	public List<LanguagesItem> getLanguages(){
		return languages;
	}

	public void setBorders(List<BordersItem> borders){
		this.borders = borders;
	}

	public List<BordersItem> getBorders(){
		return borders;
	}

	public void setSubregion(String subregion){
		this.subregion = subregion;
	}

	public String getSubregion(){
		return subregion;
	}

	public void setGini(double gini){
		this.gini = gini;
	}

	public double getGini(){
		return gini;
	}

	public void setPopulation(int population){
		this.population = population;
	}

	public int getPopulation(){
		return population;
	}

	public void setNumericCode(String numericCode){
		this.numericCode = numericCode;
	}

	public String getNumericCode(){
		return numericCode;
	}

	public void setTimezones(List<TimezonesItem> timezones){
		this.timezones = timezones;
	}

	public List<TimezonesItem> getTimezones(){
		return timezones;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAltSpellings(List<AltSpellingsItem> altSpellings){
		this.altSpellings = altSpellings;
	}

	public List<AltSpellingsItem> getAltSpellings(){
		return altSpellings;
	}

	public void setRegion(String region){
		this.region = region;
	}

	public String getRegion(){
		return region;
	}

	public void setCurrencies(List<CurrenciesItem> currencies){
		this.currencies = currencies;
	}

	public List<CurrenciesItem> getCurrencies(){
		return currencies;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DestinationCountryInformationsApi that = (DestinationCountryInformationsApi) o;
		return population == that.population &&
				area == that.area &&
				Double.compare(that.gini, gini) == 0 &&
				Objects.equals(name, that.name) &&
				Objects.equals(capital, that.capital) &&
				Objects.equals(altSpellings, that.altSpellings) &&
				Objects.equals(region, that.region) &&
				Objects.equals(subregion, that.subregion) &&
				Objects.equals(demonym, that.demonym) &&
				Objects.equals(timezones, that.timezones) &&
				Objects.equals(borders, that.borders) &&
				Objects.equals(nativeName, that.nativeName) &&
				Objects.equals(numericCode, that.numericCode) &&
				Objects.equals(languages, that.languages) &&
				Objects.equals(currencies, that.currencies);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, capital, altSpellings, region, subregion, population, demonym, area, gini, timezones, borders, nativeName, numericCode, languages, currencies);
	}

	@Override
 	public String toString(){
		return 
			"DestinationCountryInformationsApi{" +
			"area = '" + area + '\'' + 
			",nativeName = '" + nativeName + '\'' + 
			",capital = '" + capital + '\'' + 
			",demonym = '" + demonym + '\'' + 
			",languages = '" + languages + '\'' + 
			",borders = '" + borders + '\'' + 
			",subregion = '" + subregion + '\'' + 
			",gini = '" + gini + '\'' + 
			",population = '" + population + '\'' + 
			",numericCode = '" + numericCode + '\'' + 
			",timezones = '" + timezones + '\'' + 
			",name = '" + name + '\'' + 
			",altSpellings = '" + altSpellings + '\'' + 
			",region = '" + region + '\'' + 
			" currency " + currencies;
		}
}