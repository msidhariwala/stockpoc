package mock1;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import au.com.bytecode.opencsv.CSVReader;

public class TestLink {

	public static void main(String args[]) throws Exception {

		int couner=0;
		PrintWriter p = new PrintWriter("/Users/salmandhariwala/stockpoc/result.txt");
		ArrayList<String> ticker=new ArrayList<String>();
		
		CSVReader reader = new CSVReader(new FileReader("/users/salmandhariwala/stockpoc/list.csv"));
		String[] nextLine;
		reader.readNext();
		
		for(int i=0;i<560;i++){
			reader.readNext();
		}
		while ((nextLine = reader.readNext()) != null) {
			// nextLine[] is an array of values from the line
			
			ticker.add(nextLine[0]);
		}
		
		ArrayList<String> links=new ArrayList<String>();
		links=LinkGenerator.getLink(ticker, 1);
		
		for(String str:links){
			
			System.out.println(str);
			ArrayList<HashMap<String, Object>> result=ServiceHandler.getResponse(str);
			
			for(HashMap<String, Object> kmap :result){
				System.out.println("ticker :"+kmap.get("t"));
				System.out.println("ticker :"+kmap.get("l"));
				System.out.println("*********");
				p.println("ticker :"+kmap.get("t"));
				System.out.println(couner++);
			}
		}
		reader.close();
		p.close();
	}
}
