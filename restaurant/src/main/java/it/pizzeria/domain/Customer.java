package it.pizzeria.domain;

import it.pizzeria.start.Pizzeria;

public class Customer extends Thread {
	private int customer_id;
	private int pizzaId;
	private Pizzeria pizzeria;
	private int numeroClientiCheHannoOrdinato;
   	
    public Customer( int customer_id, int pizzaId, Pizzeria pizzeria, int numeroClientiCheHannoOrdinato) {
		super();
		this.customer_id = customer_id;
		this.pizzaId = pizzaId;
		this.pizzeria = pizzeria;
		this.numeroClientiCheHannoOrdinato = numeroClientiCheHannoOrdinato;
	}
    
	public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    	
    @Override
	public void run() {
		
		this.customer_id = (int) this.getId();		
		
		System.out.println( "CUSTOMER thread con id : " + customer_id );
		System.out.println( "numeroClientiCheHannoOrdinato : " + numeroClientiCheHannoOrdinato );
		
		Pizzaiolo pizzaiolo = new Pizzaiolo();
		
		try {
			
			pizzaiolo.cottura( String.valueOf( customer_id) , String.valueOf( pizzaId ) );
			
			if (numeroClientiCheHannoOrdinato >= 9 ) { // se ci sono già 10 clienti che hanno ordinato allora la Pizzeria ha raggiunto il suo maximum di clienti
				
				synchronized ( pizzeria ) {
					System.out.println( " +++++ Atteint 10 clients +++++++" );
					pizzeria.notifyAll();
				}
				
			}
			
			/*
			synchronized ( pizzaiolo ) { // Bisogna aspettare che la cottura finisce prima che il pizzalaio annuncia al cliente che la sua pizza è pronta
				pizzaiolo.wait();
			}
			*/
		} catch ( InterruptedException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println( String.format( " pizza_id: %s  prepared by pizzaiolo_id  for customer con id: %s  is ready to eat",  pizzaId, customer_id ) );
		
		try {
			System.out.println( String.format( "--- Sono customer_id: %s : inizio a mangiare ---", customer_id ));
			Thread.sleep( 1000 );
			System.out.println( String.format( "*** Sono customer_id: %s - E ho finito di mangiare *** ", customer_id ) );
		} catch ( InterruptedException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getNumeroClientiCheHannoOrdinato() {
		return numeroClientiCheHannoOrdinato;
	}

	public void setNumeroClientiCheHannoOrdinato( int numeroClientiCheHannoOrdinato ) {
		this.numeroClientiCheHannoOrdinato = numeroClientiCheHannoOrdinato;
	}
  
}
