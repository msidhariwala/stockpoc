package mock1;

public class Security {

	String Ticker;
	Double MarketValue;

	public String getTicker() {
		return Ticker;
	}

	public void setTicker(String ticker) {
		Ticker = ticker;
	}

	public Double getMarketValue() {
		return MarketValue;
	}

	public void setMarketValue(Double marketValue) {
		MarketValue = marketValue;
	}

	public Security(String ticker, Double marketValue) {
		super();
		Ticker = ticker;
		MarketValue = marketValue;
	}

}
