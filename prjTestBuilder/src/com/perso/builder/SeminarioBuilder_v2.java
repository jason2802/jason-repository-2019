package com.perso.builder;

import java.util.Date;

import com.perso.model.Seminario_v2;
import com.perso.model.Seminario_v2.*;

/**
 * 
 * Version 2 : migliore da version 1  in quanto si possono aggiungere regole di validazioni nel builder
 * Pero con questa versione il cliente deve istanziare il builder e usare ogni volta dei Builder.Setters
 * 
 * Il codice client è quindi modificato come segue :
	SeminarioBuilder bestPracticeBuilder = new SeminarioBuilder("Java best practice");
      			bestPracticeBuilder.setLuogo(Seminario.Luogo.SEDE);
      			bestPracticeBuilder.setData(primoOttobre);
    			bestPracticeBuilder.setGiorniPromemoria(10);
    			bestPracticeBuilder.setNumeroPartecipanti(2);
    			bestPracticeBuilder.setDurataInOre(3);
    			bestPracticeBuilder.setNumeroMassimoPartecipanti(3); 
	Seminario bestPractice = bestPracticeBuilder.build();
 * 
 * 
 */

public class SeminarioBuilder_v2 {
 
  private String argomento;
  private Luogo luogo; // obbligatorio
  private Date data; // obbligatorio
  private Integer numeroPartecipanti;
  private Integer giorniPromemoria;
  private Integer durataInOre;
  private Integer numeroMassimoPartecipanti;
 
  public void setLuogo(Luogo luogo) {
    this.luogo = luogo;
  }
 
  public void setData(Date data) {
    this.data = data;
  }
 
  public void setNumeroPartecipanti(Integer numeroPartecipanti) {
    this.numeroPartecipanti = numeroPartecipanti;
  }
 
  public void setGiorniPromemoria(Integer giorniPromemoria) {
    this.giorniPromemoria = giorniPromemoria;
  }
 
  public void setDurataInOre(Integer durataInOre) {
    this.durataInOre = durataInOre;
  }
 
  public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
    this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
  }
 
  public SeminarioBuilder_v2( String argomento ) {
    this.argomento = argomento;
  }
 
  public Seminario_v2 build() {
      if (numeroPartecipanti != null && numeroMassimoPartecipanti != null){
        if (numeroPartecipanti > numeroMassimoPartecipanti)
          throw new IllegalStateException("Il numero di partecipanti eccede lo spazio disponibile");
      }
       
      Seminario_v2 s = new Seminario_v2();
      s.setArgomento ( argomento );
      s.setLuogo ( this.luogo );
      s.setData ( this.data );
      s.setNumeroPartecipanti ( this.numeroPartecipanti );
      s.setDurataInOre ( this.durataInOre );
      s.setNumeroMassimoPartecipanti ( this.numeroMassimoPartecipanti );
      s.setGiorniPromemoria ( this.giorniPromemoria );
      return s;
    }
 
}