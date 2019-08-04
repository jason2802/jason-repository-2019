package com.perso.MyCustomAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented()
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)  //can use in method only.
@interface Test {
  //should ignore this test?
  	public boolean enabled() default true;
}
