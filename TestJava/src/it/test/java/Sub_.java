package it.test.java;
class Sub_ extends Super_
{
    public Sub_ (String text)
    {
        super(text);
    	i = 2; 
    } 

    public static void main(String args[])
    {
        Sub_ sub = new Sub_("Hello"); 
        System.out.println(sub.i); 
    } 
}