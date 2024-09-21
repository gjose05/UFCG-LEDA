package adt.heap;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.OrderStatisticsHeapImpl;

public class OrderStatisticsTest {
    
    private OrderStatisticsHeapImpl heap;
    private Integer[] array1;

    @Before
    public void setUp(){
        heap = new OrderStatisticsHeapImpl<>();
        array1 = new Integer[] { 14, 8, 12, 7, 9, -5, -2, 3, -10, 0 };
    }

    @Test
    public void Teste1(){
        assertEquals(-2, heap.getOrderStatistics(array1, 3));
        assertEquals(null, heap.getOrderStatistics(array1, 11));
        assertEquals(null, heap.getOrderStatistics(array1, -3));
        assertEquals((Integer) 14, heap.getOrderStatistics(array1, 10));
        assertEquals(-10, heap.getOrderStatistics(array1, 0));
    }
}
