package mock1;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ServiceHandler {

	public static ArrayList<HashMap<String, Object>> getResponse(String url) throws Exception {

		ArrayList<HashMap<String, Object>> arrlist = new ArrayList<HashMap<String, Object>>();

		String string_result = ServiceRequest.get(url);

		Gson gson = new Gson();

		arrlist = gson.fromJson(string_result, new TypeToken<ArrayList<HashMap<String, Object>>>() {
		}.getType());

		return arrlist;

	}

}
