package edu.ucsb.cs56.pconrad.springboot.hello;
  
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.Before;

public class PostingTest{
@Test
public void test_getIdandsetId(){
        Posting p=new Posting("biolante","boss of this gym", "markwolff@gmail.com", "8101919");
	p.setId("153");
        assertEquals("153", p.getId());

}
}
