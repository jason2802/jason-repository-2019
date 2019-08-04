package com.perso.builder;

import java.util.Date;

import com.perso.model.Seminario_v1;
import com.perso.model.Seminario_v1.Luogo;

/**
 * 
 * Version : BASE cioè non la migliore possible 
 * 
 * Un’alternativa può essere quella di trasformare Seminario in un JavaBean con un construttore senza parametri 
 * e un setter per ciascun parametro obbligatorio o opzionale, lasciando massima flessibilità di costruzione al codice client. 
 * Nulla però assicura che il bean venga utilizzato quando tutti i parametri obbligatori sono stati settati o 
 * quando lo stato interno del bean è coerente, cosa che invece si può fare facilmente utilizzando un costruttore parametrico.

 * Fatte queste considerazioni, è presentata l’applicazione del Builder Pattern al caso di esempio, con l’introduzione 
 * della classe SeminarioBuilder che si occuperà della costruzione dell’oggetto di base Seminario.
 *
 */

public class SeminarioBuilder_v1 {
 
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
 
  public SeminarioBuilder_v1( String argomento ) {
    this.argomento = argomento;
  }
 
  public Seminario_v1 build() {
    Seminario_v1 s = new Seminario_v1( argomento ); // unico campo obbligatorio in quanto per istanziare un oggetto Semirario si richiede almeno quello
    //s.setArgomento ( argomento );
    s.setLuogo ( this.luogo );
    s.setData ( this.data );
    s.setNumeroPartecipanti ( this.numeroPartecipanti );
    s.setDurataInOre ( this.durataInOre );
    s.setNumeroMassimoPartecipanti ( this.numeroMassimoPartecipanti );
    s.setGiorniPromemoria ( this.giorniPromemoria );
    return s;
  }
 
}