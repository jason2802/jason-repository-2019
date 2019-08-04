package prjTestEnum.Test;

public class EquensMsgConstants {
	public static final String RECORD_DELIMITER = "\n";
		
	public enum SegmentHeaderCodeSuffix {
	  IP,  //per interrogazione
	  AP,  //per setup
	  MP   //per update
	}
	
    public enum CodeSuffix {
	  MESSAGE_HEADER("_GM"),	    
	  SEGMENT_DATA_HEADER("_KS");

	  private String value;
	    
	  CodeSuffix(String value) {
	    this.value = value;
	  }
	    
	  public String toString() {
	    return String.valueOf(value);
	  }
	    
	  public static CodeSuffix fromValue(String text) {
	    for (CodeSuffix b : CodeSuffix.values()) {
	      if (String.valueOf(b.value).equals(text)) {
	        return b;
	      }
	     }
	     return null;
	   }
	 }
    
}
