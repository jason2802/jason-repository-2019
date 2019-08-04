package it.pizzeria.domain;

public class Price {
    private String devise;
    private Double valeur;
    
    public Price(String devise, Double valeur) {
	super();
	this.devise = devise;
	this.valeur = valeur;
    }
    public String getDevise() {
        return devise;
    }
    public void setDevise(String devise) {
        this.devise = devise;
    }
    public Double getValeur() {
        return valeur;
    }
    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }
    
}
