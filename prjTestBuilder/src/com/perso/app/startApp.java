package com.perso.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.perso.builder.SeminarioBuilder_v3;
import com.perso.builder.TaskBuilder;
import com.perso.model.Seminario_v2;
import com.perso.model.Task;

public class startApp {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	     String dateString = format.format( new Date()   );
	     Date date = null;
	    try {
		date = format.parse ( "2009-12-31" );
	    } catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    } 
	     
	Task task1 = new TaskBuilder()
		     .assignedTo("Josue")
		     .description("Task_Description")
		     .done(false)			      
		     .dueDate( date )
		     .reportedBy("G")
		     .summary("Task_1")
		     .build();
	
	System.out.println(" task1 : " + task1.toString() );
	System.out.println(" ----------------- ");
	
	
	Calendar gc = GregorianCalendar.getInstance();
	gc.set(2011, Calendar.OCTOBER, 1);
	Date primoOttobre = gc.getTime();
	gc.set(Calendar.MONTH, Calendar.DECEMBER);
	gc.set(Calendar.DAY_OF_MONTH,12);
	Date primoDicembre = gc.getTime();
	Seminario_v2 bestPracticeBuilder = new SeminarioBuilder_v3()
		  .setArgomento("Seminario formativo su CARTE PREPAGATE")
		  .setLuogo(Seminario_v2.Luogo.SEDE)
		  .setData(primoOttobre)
		  .setGiorniPromemoria(10)
		  .setNumeroPartecipanti(2)
		  .setNumeroMassimoPartecipanti(3)
		  .setDurataInOre(3)
		  .build();
	System.out.println(" bestPracticeBuilder : " + bestPracticeBuilder.toString() );
	
	System.out.println(" ----------------- ");	
	
	Seminario_v2 bestPracticeBuilder2 = new SeminarioBuilder_v3()
		  .setArgomento("Seminario formativo su DIGITAL")
		  .setLuogo(Seminario_v2.Luogo.SEDE)
		  .setData(primoOttobre)
		  .setGiorniPromemoria(10)
		  .setNumeroPartecipanti(4)
		  .setNumeroMassimoPartecipanti(3)
		  .setDurataInOre(3)
		  .build();
	System.out.println(" bestPracticeBuilder : " + bestPracticeBuilder2.toString() );

    }

}
