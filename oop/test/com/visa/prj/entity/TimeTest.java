package com.visa.prj.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class TimeTest {

	
	@Test
	public void testAddtimeTime() {
		//fail("Not yet implemented");
		Time t1= new Time(4,30);
		Time t2= new Time(3,45);
		Time t3=t1.addtime(t2);
		Time t4=new Time(8,15);
		assertSame(t4,t3);
		
	}

	@Test
	public void testAddtimeTimeTime() {
		//fail("Not yet implemented");
		
		Time t1= new Time(4,30);
		Time t2= new Time(3,45);
		Time t3=Time.addtime(t1, t2);
		Time t4=new Time(8,15);
		//assertSame(t4,t3);
		//Assert.AreEqual(t4,t3);
	}

}
