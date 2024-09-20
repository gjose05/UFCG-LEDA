package adt.heap;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import adt.heap.extended.FloorCeilHeapImpl;

public class FloorCeilTest {

    private FloorCeilHeapImpl floor;

	@Before
	public void setUp() {
		Comparator<Integer> comparator = new ComparatorMaxHeap<>();
        this.floor = new FloorCeilHeapImpl(comparator);
	}

    @Test
    public void Teste1(){
        Integer[] array1 = new Integer[] { 14, 8, 12, 7, 9, -5, -2, 3, -10, 0 };
        assertEquals((Integer) 9, floor.floor(array1, (double) 10));
    }

    @Test
    public void Teste2(){
        Integer[] array1 = new Integer[] { 14, 8, 12, 7, 9, -5, -2, 3, -10, 0 };
        assertEquals((Integer) 12, floor.ceil(array1, (double) 10));
    }

}
