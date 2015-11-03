package stockTest;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Test1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		List<String> symbollist=new ArrayList<String>();
		
		CSVReader reader = new CSVReader(new FileReader("/users/salmandhariwala/stockpoc/list.csv"));
		String[] nextLine;
		reader.readNext();
		while ((nextLine = reader.readNext()) != null) {
			// nextLine[] is an array of values from the line
			
			symbollist.add(nextLine[0]);
		}
		
		int counter=0;
		StringBuffer s=new StringBuffer();
	
		//s.append("http://live-nse.herokuapp.com/?symbol=");
//s.append("http://www.nseindia.com//live_market/dynaContent/live_watch/get_quote/ajaxGetQuoteJSON.jsp?symbol=");
		s.append("http://finance.google.com/finance/info?client=ig&q=NSE:");
		
		for(String str:symbollist){
			s.append(str+",");
			counter++;
			if(counter>200)
				break;
		}
		
		System.out.println(s.toString());
		
		Test2.sendGet(removeLastChar(s.toString()));
	
		// closing alll
		reader.close();
	}
	
	private static String removeLastChar(String str) {
        return str.substring(0,str.length()-1);
    }

}
