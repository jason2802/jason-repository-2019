package it.pizzeria.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuBase {
    
    private List<Pizza> pizze = new ArrayList<Pizza>();

    public MenuBase() {	
    }

    public List<Pizza> getPizze() {
        return pizze;
    }
    
    public void setPizze(List<Pizza> pizze) {
        this.pizze = pizze;
    }
 
}
