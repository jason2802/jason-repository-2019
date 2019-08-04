package com.perso.model;

import java.text.DateFormat;
import java.util.Date;

import lombok.Setter;


/**
 * 
 * https://codingjam.it/dai-costruttori-al-builder-pattern-in-java/
 * 
 * Il codice presentato è il plausibile risultato di veloci rimaneggiamenti causati dall’aggiunta di informazioni 
 * non previste dall’analisi iniziale del progetto. Si può pensare che, per ogni change request, 
 * sia stato aggiunto un nuovo costruttore incrementando il costruttore più “esteso” con dei parametri opzionali; 
 * questa tecnica viene definita telescoping. Osservando il codice, si può dedurre che l’unico parametro obbligatorio 
 * per poter definire un seminario sia l’argomento.

 * Al fine di non complicare la classe oltre lo scopo di questo post, è stato implementato solo un “grezzo” metodo toString. 
 * Interessa, infatti, solo ragionare sulla costruzione dell’oggetto e non sulle logiche che esso implementa.
 * 
 * */
@Setter
public class Seminario_v1 {
 
  public enum Luogo {
    SEDE, CLIENTE
  }
 
  private static DateFormat dt = DateFormat.getDateInstance();
 
  private String argomento;
  private Luogo luogo;  
  private Date data; 
  private Integer numeroPartecipanti; 
  private Integer giorniPromemoria;
  private Integer durataInOre;
  private Integer numeroMassimoPartecipanti;
   
  public Seminario_v1(String argomento){ // costruttore con minimo params quindi il campo argomento diventa obbligatorio
    this.argomento = argomento;
  }
      
  public Seminario_v1(String argomento, Luogo luogo, Date data) {
    this(argomento);
    this.luogo = luogo;
    this.data = data;
  }
 
  public Seminario_v1(String argomento, Luogo luogo, Date data, Integer giorniPromemoria) {
    this(argomento, luogo, data);
    this.giorniPromemoria = giorniPromemoria;
  }
   
  public Seminario_v1(String argomento, Luogo luogo, Date data, Integer giorniPromemoria, Integer numeroPartecipanti) {
    this(argomento);
    this.data = data;
    this.giorniPromemoria = giorniPromemoria;
    this.numeroPartecipanti = numeroPartecipanti;
  }
   
  public Seminario_v1(String argomento, Luogo luogo, Date data, Integer giorniPromemoria, Integer numeroPartecipanti, Integer durataInOre) {
    this(argomento, luogo, data);
    this.giorniPromemoria = giorniPromemoria;
    this.numeroPartecipanti = numeroPartecipanti;
    this.durataInOre = durataInOre;
  }
   
 
  public Seminario_v1(String argomento, Luogo luogo, Date data, Integer giorniPromemoria, Integer numeroPartecipanti, Integer durataInOre, Integer numeroMassimoPartecipanti) {
    this(argomento, luogo, data, giorniPromemoria,numeroPartecipanti, durataInOre);
    this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
  }
   
   
    public String toString() {
    return "Il seminario è intitolato '" +  argomento + "" + data != null ? "' si tiene in data  " + dt.format(data) : "";
  }
 
}