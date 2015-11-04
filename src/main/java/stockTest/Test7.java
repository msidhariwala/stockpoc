package stockTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class Test7 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		String str = "http://finance.google.com/finance/info?client=ig&q=NSE:"+URLEncoder.encode("APOLSINHOT", "UTF-8");
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(str);

		
		
		HttpResponse response = client.execute(request);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result);
	}

}
