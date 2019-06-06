package jankowiak.kamil.currencyModel;

public class Info{
	private String rate;
	private String timestamp;

	public void setRate(String rate){
		this.rate = rate;
	}

	public String getRate(){
		return rate;
	}

	public void setTimestamp(String timestamp){
		this.timestamp = timestamp;
	}

	public String getTimestamp(){
		return timestamp;
	}

	@Override
 	public String toString(){
		return 
			"Info{" + 
			"rate = '" + rate + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			"}";
		}
}
