package it.test.java;
class Base2
{ 
    Base2()
    {
        System.out.print("Base2");
    }
} 
public class Alpha extends Base2
{ 
	Alpha(){}
	
    public static void main(String[] args)
    { 
        new Alpha(); /* Line 12 */
        new Base2(); /* Line 13 */
    } 
}