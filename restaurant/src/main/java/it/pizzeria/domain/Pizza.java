package it.pizzeria.domain;

import java.util.List;

public class Pizza {
    private String kind_of_pizza;
    private Price price;
    private List<String> ingredients;
     
    public Price getPrice() {
        return price;
    }
    public void setPrice(Price price) {
        this.price = price;
    }
    public List<String> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
    public String getKind_of_pizza() {
        return kind_of_pizza;
    }
    public void setKind_of_pizza(String kind_of_pizza) {
        this.kind_of_pizza = kind_of_pizza;
    }
 
 
}
