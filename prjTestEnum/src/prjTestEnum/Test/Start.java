package prjTestEnum.Test;

import prjTestEnum.Test.EquensMsgConstants.CodeSuffix;

public class Start {

	 public static void main(String[] args)	  {
	       
		String test = null;
		String test2 = "bio";
		
		boolean result = test2.equalsIgnoreCase(test);
				 
	    System.out.println("--------------- " );
	    System.out.println("MESSAGE_HEADER =  " + EquensMsgConstants.CodeSuffix.MESSAGE_HEADER.toString());
	    System.out.println("--------------- " );
	    System.out.println("SEGMENT_DATA_HEADER = " + EquensMsgConstants.CodeSuffix.SEGMENT_DATA_HEADER.toString());
	    
	    System.out.println("  " );
	    System.out.println("  " );
	    System.out.println("MESSAGE_HEADER ( 2 ) :   " + CodeSuffix.MESSAGE_HEADER.toString());
	    System.out.println(" - " );
	    System.out.println("SEGMENT_DATA_HEADER ( 2 ) : " + CodeSuffix.SEGMENT_DATA_HEADER.toString());
	    
	    
	  }
	 
}
