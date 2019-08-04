package com.perso.MyCustomAnnotation;

import com.perso.interfaces.TesterInfo;
import com.perso.interfaces.TesterInfo.Priority;

@TesterInfo(
	priority = Priority.HIGH, 
	createdBy = "mkyong.com",  
	tags = {"sales","test" }
)
public class TestExample {
    
    @Test
    void testA() {
	 if (true)
		throw new RuntimeException("This test always failed");
    }
    
    @Test(enabled = false)
    void testB() {
	  if (false)
		throw new RuntimeException("This test always passed");
    }
    
    @Test(enabled = true)
    void testC() {
	  if (10 > 1) {
		// do nothing, this test always passed.
	  }
    }
    
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
