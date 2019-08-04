package it.perso.java.upcasting.static_binding;

class Boy extends Human {
	
	public static void walk() {
		System.out.println( "Boy walks" );
	}

	public static void main( String args[] ) {
		/*
		 * Reference is of Human type and object is Boy type
		 */
		Human obj = new Boy();
		/*
		 * Reference is of HUman type and object is of Human type.
		 */
		Human obj2 = new Human();
		
		obj.walk(); // ==> RESPOSNE ( Output ) : Human walks

		obj2.walk();  // ==> RESPOSNE ( Output ) : Human walks
		
	}
}

/*
 * 
 * Static binding example
 * 
Here we have two classes Human and Boy. 
Both the classes have same method walk() but the method is static, 
which means it cannot be overriden so even though I have used the object of Boy class while creating object obj, 
the parent class method is called by it. Because the reference is of Human type (parent class). 
So whenever a binding of STATIC, PRIVATE and FINAL methods happen, 
type of the class is determined by the compiler at compile time and the binding happens then and there.
 */
