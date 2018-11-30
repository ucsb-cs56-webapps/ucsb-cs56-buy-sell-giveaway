package edu.ucsb.cs56.pconrad.springboot.hello;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.Before;



public class DBControllerTest{
	private DBController dbc =new DBController();
	



	@Test
	public void test_connect(){
	Object o=dbc.connect();
	assertNotNull(o);
	}

	@Test
	public void test_insertANDselect(){
		Posting pi= new Posting("Test Title 1","DescriptionTest", "testMyDB@testies.test","1-800-555-Test");
		dbc.insert(pi);
		Posting pf =dbc.select(pi.getID());
		assertEquals("Test Title 1", pf.getTitle());
		assertEquals("DescriptionTest", pf.getDescription());
		assertEquals("1-800-555-Test", pf.getNumber());
		assertEquals("testMyDB@testies.test", pf.getEmail());
	}
	
	@Test
	public void test_delete(){
		Posting pi= new Posting("Test Title 1","DescriptionTest", "1-800-555-Test", "testMyDB@testies.test");
                dbc.insert(pi);
		int testID = pi.getID();
		dbc.delete(testID);
		assertNull(dbc.select(testID));

	}
	@Test
	public void test_deleteAll_and_selectAll(){
		dbc.deleteAll();
		assertEquals(0,dbc.selectAll().size());
	}

}
