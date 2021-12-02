package executor;

import java.io.File;

import utility.PropertiesReader;

public class Main {
	
	public static String PROJECT_PATH, URL;
	public static PropertiesReader propReader = PropertiesReader.getInstance();
	
	public static void main(String[] args) throws Exception {
		
		PROJECT_PATH = new File("").getAbsolutePath();
		
		URL = "https://www.practo.com/";
		
		System.out.println("TEST CASE DESCRIPTION");
		System.out.println("Verifying the login functionality");
		
		TestExecutor execute = new TestExecutor();
		execute.startTest();
	}

}
