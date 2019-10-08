package no.hvl.dat100ptc;

public class TODO {

	public static String method() {
		int test = 0;
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		return "Metoden " + methodName + " er ikke implementert";
	}
	//TEST1
	
	public static String construtor(String className) {
				
	   return "Konstruktøren for klassen " + className + " er ikke implementert";
		
	}

}
