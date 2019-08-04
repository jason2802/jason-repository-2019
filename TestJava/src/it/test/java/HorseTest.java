package it.test.java;
public class HorseTest 
{
    public static void main (String [] args) 
    {
        class Horse 
        {
            public String name; /* Line 7 */
            public Horse(String s) 
            {
                name = s;
            }
        } /* class Horse ends */
        
        Object obj = new Horse("Zippo"); /* Line 13 */
        Horse h = (Horse) obj; /* Line 14 */
        System.out.println(h.name);
    }
}