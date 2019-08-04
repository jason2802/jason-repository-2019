package com.perso.MyCustomAnnotation;

import com.perso.interfaces.MyAnnotation;

@MyAnnotation(value=10)  
public class Hello {
    int a=1;
    public void sayHello () {
	System.out.println ( "hello annotation" );
    }
}
