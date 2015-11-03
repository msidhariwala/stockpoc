package stockTest;

import java.io.PrintWriter;

public class Test4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		PrintWriter p = new PrintWriter("/Users/salmandhariwala/stockpoc/result.txt");
		
		Test5 t3=new Test5();
		
		for(int i=0;i<1000;i++){
			
			t3.main(p);
		}
		
		p.close();
		
		
		
		
	}

}
