package it.perso.java.upcasting.dynamic_binding;

class Boy extends Human {
	
	public void walk() { // IN THIS CASE method is NOT STATIC, PRIVATE and FINAL
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
		
		obj.walk(); // ==> RESPOSNE ( Output ) : Boy walks

		obj2.walk();  // ==> RESPOSNE ( Output ) : Human walks
		
	}
}

/*
 * 
 * Dynamic Binding or Late Binding
When compiler is not able to resolve the call/binding at compile time, such binding is known as Dynamic or late Binding. 
Method Overriding is a perfect example of dynamic binding as in overriding both parent and child classes have same method 
and in this case the THE TYPE OF OBJECT determines which method is to be executed. 
The type of object is determined at the run time so this is known as dynamic binding.
 *
 */

/*
 This is the same example that we have seen above. 
 The only difference here is that in this example, 
 overriding is actually happening since these methods are NOT STATIC, PRIVATE and FINAL. 
 In case of overriding the call to the overriden method is determined at runtime by the type of object thus late binding happens 
 */
