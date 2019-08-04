package com.perso.builder;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.perso.model.Seminario_v2;
import com.perso.model.Seminario_v2.Luogo;

/**
 * 
 * Version 2 : MIGLIORE  
 * In quanto stavolta si restituisce un oggetto builder in ogni setter 
 * cosi facendo il client non avra piu bisogno di specificare il setter come nella versione precedente
 * 
 * SeminarioBuilder bestPracticeBuilder = new SeminarioBuilder("Java best practice")
  .setLuogo(Seminario.Luogo.SEDE)
  .setData(primoOttobre)
  .setGiorniPromemoria(10)
  .setPartecipanti(2)
  .setNumeroMassimoPartecipanti(3)
  .setDurataInOre(3)
  .build();
 * 
 * In piu si aggiunge ua regola di validazione per i campi obbligatori dentro il builder
 * 
 * 
 */

public class SeminarioBuilder_v3 {
 
  private String argomento;
  private Luogo luogo; // obbligatorio
  private Date data; // obbligatorio
  private Integer numeroPartecipanti;
  private Integer giorniPromemoria;
  private Integer durataInOre;
  private Integer numeroMassimoPartecipanti;
 
  public SeminarioBuilder_v3 setArgomento(String argomento) {
    this.argomento = argomento;
    return this;
}

public SeminarioBuilder_v3 setLuogo(Luogo luogo) {
    this.luogo = luogo;
    return this;
  }
 
  public SeminarioBuilder_v3 setData(Date data) {
    this.data = data;
    return this;
  }
 
  public SeminarioBuilder_v3 setNumeroPartecipanti(Integer numeroPartecipanti) {
    this.numeroPartecipanti = numeroPartecipanti;
    return this;
  }
 
  public SeminarioBuilder_v3 setGiorniPromemoria(Integer giorniPromemoria) {
    this.giorniPromemoria = giorniPromemoria;
    return this;
  }
 
  public SeminarioBuilder_v3 setDurataInOre(Integer durataInOre) {
    this.durataInOre = durataInOre;
    return this;
  }
 
  public SeminarioBuilder_v3 setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
    this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    return this;
  }
 
  public SeminarioBuilder_v3( ) {
    
  }
 
  public Seminario_v2 build() {
      if ( StringUtils.isBlank( argomento ) ){
	     throw new IllegalStateException("Il campo argomento non può essere vuoto ");
      }
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