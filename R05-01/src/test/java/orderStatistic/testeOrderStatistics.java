package orderStatistic;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class testeOrderStatistics {

	public KLargestOrderStatisticsImpl<Integer> oi;

	@Before
	public void inicializa(){
		oi = new KLargestOrderStatisticsImpl<Integer>();
	}
	
	@Test
	public void test1(){
		Integer[] array = (new Integer[]  {10,3,2,4,1,0});
		Integer[] esperado = (new Integer[] {10,4,3});
		assertEquals((Integer)4,oi.orderStatistics(array,2));
		assertArrayEquals(esperado, oi.getKLargest(array,3));
	}

	@Test
	public void test2(){
		Integer[] array = (new Integer[]  {10,10,10,10});
		Integer[] esperado = (new Integer[] {10,10,10});
		assertEquals((Integer)10,oi.orderStatistics(array,2));
		assertArrayEquals(esperado, oi.getKLargest(array,3));
	}

	@Test
	public void test3(){
		Integer[] array = (new Integer[]  {});
		Integer[] esperado = (new Integer[] {});
		assertEquals(null,oi.orderStatistics(array,3));
		assertArrayEquals(esperado, oi.getKLargest(array,3));
	}

}