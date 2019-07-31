package com.visa.prj.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayUtilTest {

	@Test
	public void testGetSum() {
	    int[] data= {5,6,4};
	    assertEquals(15,ArrayUtil.getSum(data));
	    int[] elems= {-1,0,1};
	    assertEquals(0,ArrayUtil.getSum(elems));
	}

	@Test
	public void testGetCount() {
		//fail("Not yet implemented");
		int[] elems = {53,67,2,67,74,67};
		assertEquals(3,ArrayUtil.getCount(elems, 67));
		
	}

	@Test
	public void testSort() {
		//fail("Not yet implemented");
		int[] elems = {53,67,2,67,74,67};
		ArrayUtil.sort(elems);
		int[] expected= {2,53,67,67,67,74};
		assertArrayEquals(expected,elems);
	}

}
