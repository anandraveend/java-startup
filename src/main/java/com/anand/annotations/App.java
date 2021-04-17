package com.anand.annotations;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    @Version(major=1, minor=1)
    public void testMethod() {
    	
    }
}
