package mock1;

import java.net.URLEncoder;
import java.util.ArrayList;

public class LinkGenerator {

	public static ArrayList<String> getLink(ArrayList<String> inputTickerArray, int batchSize) throws Exception{

		ArrayList<String> output_link = new ArrayList<String>();

		StringBuilder sb = new StringBuilder();
		sb.append("http://finance.google.com/finance/info?client=ig&q=NSE:");

		int ticker_counter = 0;
		int round_counter = 0;

		int round = inputTickerArray.size() / batchSize;

		for (String ticker : inputTickerArray) {

			if (ticker_counter < batchSize && round_counter != round) {
				sb.append(URLEncoder.encode(ticker, "UTF-8") + ",");
				ticker_counter++;
			} else if (round_counter != round) {
				ticker_counter=1;
				round_counter++;
				output_link.add(removeLastChar(sb.toString()));
				sb.setLength(0);
				sb.append("http://finance.google.com/finance/info?client=ig&q=NSE:");
				sb.append(URLEncoder.encode(ticker, "UTF-8") + ",");
			}

			if (round_counter == round) {
				sb.append(URLEncoder.encode(ticker, "UTF-8") + ",");
			}

		}
		
		//make last link of reaming tickers
		output_link.add(removeLastChar(sb.toString()));

		return output_link;

	}

	private static String removeLastChar(String str) {
		return str.substring(0, str.length() - 1);
	}
}
