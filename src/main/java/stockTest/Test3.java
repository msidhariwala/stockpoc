package stockTest;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Test3 {

	public static void main(PrintWriter p) throws Exception {

		// String str = Test2.sendGet(
		// "http://www.nseindia.com//live_market/dynaContent/live_watch/get_quote/ajaxGetQuoteJSON.jsp?symbol=INFY");

		String str = Test2.sendGet("http://finance.google.com/finance/info?client=ig&q=NSE:INFY");

		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> data = new HashMap<String, String>();

		Gson gson = new Gson();

		map = gson.fromJson(str, new TypeToken<HashMap<String, Object>>() {
		}.getType());

		// System.out.println(map);

		Object checkthis = map.get("data");

		List<Object> s = new ArrayList<Object>();
		s = (List<Object>) checkthis;

		for (Object o : s) {
			// System.out.println(o);
			Map<String, String> mmm = new HashMap<String, String>();
			mmm = (Map<String, String>) o;
			// System.out.println(mmm);
			System.out.println(mmm.get("lastPrice"));
			p.println(mmm.get("lastPrice"));
		}

	}

}
