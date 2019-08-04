package it.pizzeria.enums;

public enum Ingredient {
  
  TOMATO("tomato"),  
  MOZZARELLA("mozzarella)"),
  ARTICHOKES("artichokes"),
  MUSHROOMS("mushrooms"),  
  HAM("ham"),
  ANCHOVIES("anchovies");
       
  private String value;

  Ingredient(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }


  public static Ingredient fromValue(String text) {
    for (Ingredient b : Ingredient.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
  
}