package it.test.java;
public class Test_Floor { 

   public static void main(String args[]) {
      double d = -100.675;
      float f = -90;
     
      System.out.println(Math.floor(d));
      System.out.println(Math.floor(f)); 

      System.out.println(Math.ceil(d));
      System.out.println(Math.ceil(f));
      
      double d1 = Math.random();
      System.out.println("d1 : " +  d1 );
      double d2 = d1 * 8;
      System.out.println("d2 : " +  d2 );
      double d3 =  Math.floor( d2 );
      System.out.println("d3 : " +  d3 );
      int i4 = (int)( d3 );
      System.out.println("i4 : " +  i4 );
      int res = i4 + 2;
      System.out.println("res : " +  res );
      
   }
}