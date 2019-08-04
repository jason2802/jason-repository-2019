package it.pizzeria.start;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.pizzeria.domain.Customer;
import it.pizzeria.domain.Menu;
import it.pizzeria.domain.MenuBase;
import it.pizzeria.domain.Pizza;
import it.pizzeria.domain.Price;
import it.pizzeria.enums.Ingredient;

public class Pizzeria implements Runnable{

    private static final String EUR = "EURO";
    static String token="";
    
    public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int number_of_pizzaiolo = Integer.parseInt(args[0]);
		int number_of_place_in_the_pizzeria = Integer.parseInt(args[1]);
		int number_of_order_for_margherita = Integer.parseInt(args[2]);
		int number_of_order_for_capriciosa = Integer.parseInt(args[3]);
		int number_of_order_for_quatro_stagioni = Integer.parseInt(args[4]);
	
		Pizza margherita = new Pizza();
		margherita.setKind_of_pizza("margherita");
		List <String> ingredientsMarg = new ArrayList<>();
		ingredientsMarg.add( Ingredient.TOMATO.toString() );
		ingredientsMarg.add( Ingredient.MOZZARELLA.toString() );
		margherita.setIngredients( ingredientsMarg );
		margherita.setPrice( new Price ( EUR, 8.50 ) );
	
		Pizza capriciosa = new Pizza();
		capriciosa.setKind_of_pizza("capriciosa");
		List <String> ingredientsCap = new ArrayList<>();
		ingredientsCap.add( Ingredient.TOMATO.toString() );
		ingredientsCap.add( Ingredient.MOZZARELLA.toString() );
		ingredientsCap.add( Ingredient.HAM.toString() );
		ingredientsCap.add( Ingredient.ARTICHOKES.toString() );
		ingredientsCap.add( Ingredient.MUSHROOMS.toString() );
		capriciosa.setIngredients( ingredientsCap );
		capriciosa.setPrice( new Price ( EUR, 11.50 ) );
	
		Pizza quatroStagioni = new Pizza();
		quatroStagioni.setKind_of_pizza("capriciosa");
		List <String> ingredientsQua = new ArrayList<>();
		ingredientsQua.add( Ingredient.TOMATO.toString() );
		ingredientsQua.add( Ingredient.MOZZARELLA.toString() );
		ingredientsQua.add( Ingredient.HAM.toString() );
		ingredientsQua.add( Ingredient.MUSHROOMS.toString() );
		ingredientsQua.add( Ingredient.ARTICHOKES.toString() );
		ingredientsQua.add( Ingredient.ANCHOVIES.toString() );
		quatroStagioni.setIngredients( ingredientsQua );	
		quatroStagioni.setPrice( new Price ( EUR, 11.50 ) );
	
		MenuBase menuBase = new MenuBase();
		menuBase.getPizze().add(margherita);
		menuBase.getPizze().add(capriciosa);
		menuBase.getPizze().add(quatroStagioni);
	
		char userChoice;
		Scanner scanner = new Scanner(System.in);
		     
	    Menu m = new Menu();
	     //  m.getPizze().add( addPizzaInMenu() );

		Pizzeria pizzeria = new Pizzeria();
		for ( int i=0, customerId=0, pizzaId=0 ; i < 10; i++, customerId++, pizzaId++  ) {
			Customer threadCustomer = new Customer( customerId, pizzaId, pizzeria, i );
			
			threadCustomer.start();			
		}
		
		if (number_of_place_in_the_pizzeria==10) {
			token = "F";
			
			synchronized ( pizzeria ) {
				pizzeria.wait();
			}
			
			pizzeria.run();
		}
		
			
    }


	@Override
	public void run() {
		
		System.out.println( "Pizzeria" );
		
		if ( token.equalsIgnoreCase( "F" ) ){
			System.out.println( "!!! The Pizzeria is full" );
		} 
		
	}

    private static Pizza addPizzaInMenu() {
	
	Scanner scanner = new Scanner(System.in);
	char userChoice;
	String kindOfPizza;
	Price price;
	List <String> ingredients = new ArrayList<>();
	
    	 do
    	 {
    	     System.out.println("Saissez le type ou nom de la pizza : ");
    	     kindOfPizza = scanner.next();
    		     		 
    	      System.out.print("Saissez le prix de la pizza: ");
    	      Double valeur = scanner.nextDouble();
    	      price = new Price(EUR, valeur);
    	         
              ingredients = getNewIngredients();
    		 
    	      System.out.print("Voulez vous recommencer a inserer une nouvelle pizza ( Enter Y for yes or N for no:) ? : ");
    	      userChoice = scanner.next().charAt(0);
    	  } while ((userChoice == 'y') || (userChoice == 'Y'));	
    	 
    	 Pizza p = new Pizza();
    	 p.setIngredients( ingredients );
    	 p.setKind_of_pizza( kindOfPizza );
    	 p.setPrice( price );
    	 return p;
    }
    
    private static List<String> getNewIngredients() {   	
    	List<String> ingredients = new ArrayList<>();
    	char userChoice;
    	Scanner scanner = new Scanner(System.in);
    	 do
    	 {
    	    System.out.println("Saissez le nom de l'ingredient : ");
    	    String newIngredient = scanner.next();
    		
    	    if ( isValidIngredient(ingredients, newIngredient) ) {
    	    	ingredients.add( newIngredient );
    	    } else {
    	    	System.out.println("Desolé, ingredient dejà existant : "); 
    	    }
    	      
    	    System.out.print("Voulez vous recommencer ( Enter Y for yes or N for no:) ? : ");
    	    userChoice = scanner.next().charAt(0);
    	    
    	  } while ((userChoice == 'y') || (userChoice == 'Y'));
	
    	 return ingredients;	
    	
    }
    
    private static boolean isValidIngredient( List<String> ingredients, String newIngredient) {   
    	return (Ingredient.fromValue(newIngredient) == null) && (!ingredients.contains( newIngredient ));
    }


}
