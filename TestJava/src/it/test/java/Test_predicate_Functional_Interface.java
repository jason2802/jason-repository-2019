package it.test.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Test_predicate_Functional_Interface {
	
	// https://www.geeksforgeeks.org/functional-interfaces-java/
	public static void main(String args[]) 
    { 
  
        // create a list of strings 
        List<String> names = 
            Arrays.asList("Geek","GeeksQuiz","g1","QA","Geek2"); 
  
        // declare the predicate type as string and use 
        // lambda expression to create object 
        Predicate<String> p = (s)->s.startsWith("G"); 
  
        // Iterate through the list 
        for (String st:names) 
        { 
            // call the test method 
            if (p.test(st)) 
                System.out.println(st); 
        }
    } 
}
