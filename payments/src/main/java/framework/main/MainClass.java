package framework.main;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class MainClass {
	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testNG = new TestNG();	
		List<String> suites = Lists.newArrayList();
		suites.add("payments/testng.xml");
		
		testNG.setTestSuites(suites);
		testNG.run();
		
	}
}
