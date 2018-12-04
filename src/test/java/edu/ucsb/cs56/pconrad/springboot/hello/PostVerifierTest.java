package edu.ucsb.cs56.pconrad.springboot.hello;
  
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.Before;

public class PostVerifierTest{

@Test
public void test_isValid1(){
        Posting p=new Posting("title","description", "", "number");
        assertEquals(false, PostVerifier.isValid(p));

}

@Test
public void test_isValid2(){
        Posting p=new Posting("","description", "email", "number");
        assertEquals(false, PostVerifier.isValid(p));

}
}
