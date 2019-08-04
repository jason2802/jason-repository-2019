package it.pizzeria.domain;


public class Pizzaiolo {
    private int pizzaiolo_id;
    private String token;
    private int tempoCottura = 500;
    
    public String getToken() {
		return token;
	}
	public void setToken( String token ) {
		this.token = token;
	}
	
	public int getPizzaiolo_id() {
        return pizzaiolo_id;
    }
    public void setPizzaiolo_id(int pizzaiolo_id) {
        this.pizzaiolo_id = pizzaiolo_id;
    }
    
    synchronized void cottura(String customerId, String pizzaId ) throws InterruptedException {
    	
    	Double doubleValue = ( (double) tempoCottura / 1000 );
    	String message = String.format( "COTTURA : Inizia la cottura della pizza con id: %s . Il customer con id: %s deve aspettare durante: %.2f secondo",  pizzaId, customerId, doubleValue );
       	System.out.println( message );
    	    	
    	Thread.sleep( tempoCottura );
    	
    	System.out.println( String.format( "COTTURA : Finita la cottura della pizza con id: %s ordinata dal customer_id: %s ", pizzaId, customerId ) );    	
    	
    	synchronized ( this ) {
			this.notifyAll();
			System.out.println( String.format( "*** NOTIFY : Pizzalaio  %s notifica al cliente customer_id: %s e a tutti che ha finito la cottura ed è libero  ****", pizzaiolo_id, customerId ) );
		}   	
    	
    }
    
}
			