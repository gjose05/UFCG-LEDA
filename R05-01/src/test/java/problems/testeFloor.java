package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class testeFloor {

    public FloorBinarySearchImpl oi;

    @Before
    public void inicializa(){
        oi = new FloorBinarySearchImpl();
    }

    @Test
    public void test1(){
        Integer[] array = (new Integer[]  {10,3,2,4,1,0});
        assertEquals((Integer)4,oi.floor(array, 8));
    }

    @Test
    public void test2(){
        Integer[] array = (new Integer[]  {10,3,2,4,1,0});
        assertEquals(null,oi.floor(array, 0));
    }

    @Test
    public void test3(){
        Integer[] array = (new Integer[]  {});
        assertEquals(null,oi.floor(array, 8));
    }

    @Test
    public void test4(){
        Integer[] array = (new Integer[]  {3,3,3,3});
        assertEquals((Integer)3,oi.floor(array, 4));
    }

    @Test
    public void test5(){
        Integer[] array = (new Integer[]  {10,3,2,4,1,0});
        assertEquals((Integer)10,oi.floor(array,11));
    }

    @Test
    public void test6(){
        Integer[] array = (new Integer[]  {10,3,6,4,2,0});
        assertEquals((Integer)0,oi.floor(array,1));
    }
}

