package cucumberTestNG;

import cucumber.api.java.After;
import cucumber.api.java.Before;



public class HooksTest {
	
	
	 
	@Before
	public void init(){
		
//		System.out.println("init");
		
	}
	
	@After
	public void tearDown(){
		
//		System.out.println("tearDown");
		
	}
}
