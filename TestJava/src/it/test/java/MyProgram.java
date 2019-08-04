package it.test.java;
public class MyProgram 
{
    public static void throwit() 
    {
        throw new RuntimeException();
    }
    public static void main(String args[])
    {
    	try 
    	{
    		Object o = new String[] {"1","2"};
    		
    		for ( String s: (String[]) o ) {
				System.out.println( s );
			}
    	    Float f1 = new Float("3.0");
    	    int x = f1.intValue();
    	    byte b = f1.byteValue();
    	    double d = f1.doubleValue();
    	    System.out.println(x + b + d);
    	}
    	catch (NumberFormatException e) /* Line 9 */
    	{
    	    System.out.println("bad number"); /* Line 11 */
    	}
    	
    	try 
        {
            System.out.println("Hello world ");
            throwit();
            System.out.println("Done with try block ");
        }
        finally 
        {
            System.out.println("Finally executing ");
        }
    }
}