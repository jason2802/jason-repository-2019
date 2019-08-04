package it.test.java;
class ABC{ 
	ABC() {		
	}
   private double num = 100;
   private int square(int a){
	return a*a;
   }
   public double getRandom() {
	   return Math.random();
   }
}  
public class Example{
	private Example() {		
	}
	
   public static void main(String args[]){  
	ABC obj = new ABC(); 
	Example example = new Example();
	//System.out.println(obj.num); 
	//System.out.println(obj.square(10));
	System.out.println(obj.getRandom());
   }  
}