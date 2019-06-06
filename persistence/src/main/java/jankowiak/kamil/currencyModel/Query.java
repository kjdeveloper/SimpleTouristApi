package jankowiak.kamil.currencyModel;

public class Query{
	private String amount;
	private String from;
	private String to;

	public void setAmount(String amount){
		this.amount = amount;
	}

	public String getAmount(){
		return amount;
	}

	public void setFrom(String from){
		this.from = from;
	}

	public String getFrom(){
		return from;
	}

	public void setTo(String to){
		this.to = to;
	}

	public String getTo(){
		return to;
	}

	@Override
 	public String toString(){
		return 
			"Query{" + 
			"amount = '" + amount + '\'' + 
			",from = '" + from + '\'' + 
			",to = '" + to + '\'' + 
			"}";
		}
}
