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
		char dir2 = 'W';
		char dir3 = 'E';
		
		Assert.assertEquals(true, isValidDirection(dir));
		Assert.assertEquals(true, isValidDirection(dir1));
		Assert.assertEquals(true, isValidDirection(dir2));
		Assert.assertEquals(true, isValidDirection(dir3));
	}
	
	@Test(expected = NullPointerException.class)
	public void checkForInvalidDirections()
	{
		char dir = 'R';
		char dir1 = 'S';
		
		Assert.assertEquals(false, isValidDirection(dir));
		Assert.assertEquals(false, isValidDirection(dir1));
	}
	
	@Test
	public void checkValidityForCommands()
	{
		char command1 = 'r';
		char command2 = 'l';
		char command3 = 'f';
		char command4 = 'b';
		char command5 = 'u';
		char command6 = 'd';
		
		
		Assert.assertEquals(true, isValidCommand(command1));
		Assert.assertEquals(true, isValidCommand(command2));
		Assert.assertEquals(true, isValidCommand(command3));
		Assert.assertEquals(true, isValidCommand(command4));
		Assert.assertEquals(true, isValidCommand(command5));
		Assert.assertEquals(true, isValidCommand(command6));
	}
	
	@Test(expected = NullPointerException.class)
	public void checkForInvalidCommands()
	{
		char command = 0;
		char command2 = 'e';
		char command3 = 's';
		
		Assert.assertEquals(true, isValidCommand(command));
		Assert.assertEquals(true, isValidCommand(command2));
		Assert.assertEquals(true, isValidCommand(command3));
	}
}
