package edu.ucsb.cs56.pconrad.springboot.hello;
  
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.Before;

public class PostTest{

@Test
public void test_isValid1(){
    Posting p=new Posting("title","description", "", "number","id");
        assertEquals(false, PostVerifier.isValid(p));

}

@Test
public void test_isValid2(){
    Posting p=new Posting("","description", "email", "number","id");
        assertEquals(false, PostVerifier.isValid(p));

}
@Test
public void test_isValid3(){
    Posting p=new Posting("title","", "email", "number","id");
        assertEquals(false, PostVerifier.isValid(p));

}
@Test
public void test_isValid4(){
    Posting p=new Posting("title","description", "email", "","id");
        assertEquals(false, PostVerifier.isValid(p));

}
@Test
public void test_isValid5(){
    Posting p=new Posting("van darkholme","a performance artist", "deepdarkfantasies", "8101919","id");
        assertEquals(true, PostVerifier.isValid(p));

}
}
