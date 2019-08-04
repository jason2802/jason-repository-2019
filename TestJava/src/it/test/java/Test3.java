package it.test.java;
public class Test3 
{
    public int aMethod()
    {
        int i = 0;
        i++;
        return i;
    }
    public static void main(String args[])
    {
        Test3 test3 = new Test3();
        test3.aMethod();
        int j = test3.aMethod();
        System.out.println(j);
    }
}