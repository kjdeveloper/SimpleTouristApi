package jankowiak.kamil.currencyModel;

public class CurrencyConverterApi {
	private String date;
	private String result;
	private String success;
	private Query query;
	private Info info;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	public void setSuccess(String success){
		this.success = success;
	}

	public String getSuccess(){
		return success;
	}

	public void setQuery(Query query){
		this.query = query;
	}

	public Query getQuery(){
		return query;
	}

	public void setInfo(Info info){
		this.info = info;
	}

	public Info getInfo(){
		return info;
	}

	@Override
 	public String toString(){
		return
			"Date: " + date +
			"\nYou have to paid " + result + " " + query.getTo() +
			" for " + query.getAmount() + " " + query.getFrom() +
			"\nRate today " + info.getRate();
		}
}
