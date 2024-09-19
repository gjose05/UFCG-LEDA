package adt.bst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.bst.BSTImpl;
import adt.bst.extended.FloorCeilBSTImpl;
import adt.bt.BTNode;

public class TestesSimplesBTM {

	private BSTImpl<Integer> tree;
    private SimpleBSTManipulationImpl<Integer> oi;
    private BSTImpl<Integer> novaTree;
    private FloorCeilBSTImpl ola;

	private void fillTree() {
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		for (int i : array) {
			tree.insert(i);
		}
        Integer[] array2 = { 6, 23, -33, 5, 9, 1, 0, 74, 12, 67, 231, -37};
		for (int i : array2) {
			novaTree.insert(i);
		}
	}

	@Before
	public void setUp() {
		tree = new BSTImpl<>();
        oi = new SimpleBSTManipulationImpl<>();
        novaTree = new BSTImpl<>();
        Integer[] novoArray = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        ola = new FloorCeilBSTImpl();
	}

    @Test
    public void Teste1(){
        fillTree();
        assertEquals(true, oi.isSimilar(tree, novaTree));
        assertEquals(true, oi.isSimilar(tree, tree));
        assertEquals(null,oi.orderStatistic(tree, 13));
        assertEquals((Integer)232,oi.orderStatistic(tree, 12));
    }

    @Test
    public void Teste2(){
        Integer[] novoArray = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        assertEquals((Integer)9, ola.ceil(novoArray, 8));
        assertEquals((Integer)6, ola.floor(novoArray, 8));

    }
}