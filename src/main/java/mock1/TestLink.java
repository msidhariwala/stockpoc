package mock1;

import java.util.ArrayList;

public class TestLink {

	public static void main(String args[]) throws Exception {

		System.out.println("check");
		ArrayList<String> ticker=new ArrayList<String>();
		
		for(int i=0;i<1597;i++){
			ticker.add("INFY"+(i+1));
		}
		
		ArrayList<String> links=new ArrayList<String>();
		
		links=LinkGenerator.getLink(ticker, 200);
		
		for(String str:links){
			System.out.println(str);
		}
	}
}
