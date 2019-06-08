package jankowiak.kamil.destinationCountryInfoModel;

public class AltSpellingsItem{
	private String spel;
	private String spel3;
	private String spel2;

	public void setSpel(String spel){
		this.spel = spel;
	}

	public String getSpel(){
		return spel;
	}

	public void setSpel3(String spel3){
		this.spel3 = spel3;
	}

	public String getSpel3(){
		return spel3;
	}

	public void setSpel2(String spel2){
		this.spel2 = spel2;
	}

	public String getSpel2(){
		return spel2;
	}

	@Override
 	public String toString(){
		return 

			spel + '\'' +
			spel3 + '\'' +
			 spel2;
		}
}
