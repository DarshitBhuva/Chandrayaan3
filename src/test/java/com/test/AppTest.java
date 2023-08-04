package com.test;

import static com.crafts.App.*;

import org.junit.Assert;
import org.junit.Test;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
	@Test
	public void checkValidityForDirections()
	{
		char dir = 'N';
		char dir1 = 'S';
		char dir2 = 'R';
		char dir3 = 'E';
		
		Assert.assertEquals(true, isValidDirection(dir));
		Assert.assertEquals(true, isValidDirection(dir1));
		Assert.assertEquals(false, isValidDirection(dir2));
		Assert.assertEquals(true, isValidDirection(dir3));
	}
	
	@Test
	public void checkValidityForCommands()
	{
		char command = 'r';
		
		Assert.assertEquals(true, isValidCommand(command));
	}
}
