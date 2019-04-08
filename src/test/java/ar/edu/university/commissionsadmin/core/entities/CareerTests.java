package ar.edu.university.commissionsadmin.core.entities;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CareerTests {
	@Test
	public void setCareerName(){
		Career c = new Career();
		c.setName("Algebra");
		assertTrue(c.getName().compareTo("Algebra")==0);		
	}
}
