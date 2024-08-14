package orderStatistic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class testeQuick {

    private QuickSelect oi;

    @Before
    public void inicio(){
        oi = new QuickSelect<>();
    }

    @Test
    public void test1(){
        Integer[] array = (new Integer[]  {10,3,2,4,1,0});
		assertEquals((Integer)1,oi.quickSelect(array,2));
    }
}
