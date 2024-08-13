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

}

