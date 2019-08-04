package it.perso.java.upcasting;

public class Starter {
	public static void main( String[] args ) {

		Animal animal = new Cat();
		System.out.println( "------------" );
		animal.show();

		System.out.println( "------------" );
		Dog dog = new Dog();
		
		// Casting from a subclass to a superclass is called upcasting
		// implicit upcasting takes place
		animal = dog;
		System.out.println( "------------" );
		animal.show();
		
		System.out.println( "++++++++++++" );

		System.out.println( "Hello, World !!!" );
		
		
			          
				int i = 0;
				boolean t = true;
				boolean f = false, b;
				b = (t || ((i++) == 0));
				System.out.println(i);	
				b = (f || ((i+=2) > 0));
				System.out.println(i);		
			
		
		
	}
}
