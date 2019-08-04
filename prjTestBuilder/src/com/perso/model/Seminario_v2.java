package com.perso.model;

import java.text.DateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


/**
 * Versione 2 : senza costruttore  
 * 
 */
@Getter
@Setter
public class Seminario_v2 {
 
  public enum Luogo {
    SEDE, CLIENTE
  }
 
  private static DateFormat dt = DateFormat.getDateInstance();
 
  String argomento; // obbligatorio
  Luogo luogo;
  Date data;
  Integer numeroPartecipanti;
  Integer giorniPromemoria;
  Integer durataInOre;
  Integer numeroMassimoPartecipanti;
 
  public String toString() {
    return "Il seminario è intitolato '" + argomento + "" + data != null ? "' si tiene in data  " + dt.format(data) : "";
  }
 
}