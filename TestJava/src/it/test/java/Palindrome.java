package it.test.java;

import java.math.BigDecimal;

public class Palindrome {
	
		/*
	    public static boolean isPalindrome(String word) {
	    	String words = word.toLowerCase();
	    	int len = words.length()-1;
	    	boolean isPalindrome = true;
	    	for (int i=0; i<(len/2); i++) {
	    		System.out.println( " word.charAt(" + i + " ) " + word.charAt( i ) );
	    		System.out.println( " word.charAt(" + len + " ) " + word.charAt( len ) );	    		
	    		if ( word.charAt( i ). word.charAt( len )) {
	    			isPalindrome = false;
	    			break;
	    		}
	    		len--;
	    	}
	    	return isPalindrome;
	    	
	    }
	    */
	    
     public static void main(String args[])
     {
    	 int I = 0;
    	    outer:
    	    while (true) 
    	    {
    	        I++;
    	        inner:
    	        for (int j = 0; j < 10; j++) 
    	        {
    	            I += j;
    	            if (j == 3)
    	                continue inner;
    	            break outer;
    	        }
    	        continue outer;
    	    }
    	System.out.println(I);

     }
     
     
     
}