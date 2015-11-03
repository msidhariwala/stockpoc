package stockTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Test2 {

	private static final String USER_AGENT = "Mozilla/5.0";

	public static void main(String args[]) throws Exception {

		//sendGet("http://live-nse.herokuapp.com/?symbol=ANGIND,CIPLA");
		sendGet("http://www.nseindia.com//live_market/dynaContent/live_watch/get_quote/ajaxGetQuoteJSON.jsp?symbol=ABAN,ACE");
		//sendGet("http://finance.google.com/finance/info?client=ig&q=NSE:INFY,NTPC");
	}

	// HTTP GET request
	public static String sendGet(String url) throws Exception {

		// String url = "http://www.google.com/search?q=developer";

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.01; Windows NT 5.0)");
		request.addHeader("Referer","http://www.nseindia.com/");
		request.addHeader("Accept","*/*");
		//request.addHeader("","");

		HttpResponse response = client.execute(request);

		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());

		String temp1=result.toString();
		
		//System.out.println(temp1.substring(3));
		
		
		return temp1.substring(3);
	}

}
