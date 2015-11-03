package stockTest;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Test5 {

	public static void main(PrintWriter p) throws Exception {

		String str = Test2.sendGet("http://finance.google.com/finance/info?client=ig&q=NSE:INFY");

		Gson gson = new Gson();

		ArrayList<HashMap<String, Object>> arrlist = new ArrayList<HashMap<String, Object>>();

		arrlist = gson.fromJson(str, new TypeToken<ArrayList<HashMap<String, Object>>>() {
		}.getType());

		for (HashMap<String, Object> kmap : arrlist) {
			System.out.println(kmap.get("l"));
			p.println(kmap.get("l"));
		}

	}

}
