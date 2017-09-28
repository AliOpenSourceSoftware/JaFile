package com.ali.java.jaFile;

import java.io.File;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;  

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
     
    public void testFileCreation() { 
      FileReader.CreateFile("test.txt");
      File file = new File("test.txt");
      assertEquals(true ,file.exists());

    }
    
    public void testfileoverwrite() { 
        FileReader.CreateFile("test.txt");
        File file = new File("test.txt");
        assertEquals(true ,file.exists());

      }
     
}
