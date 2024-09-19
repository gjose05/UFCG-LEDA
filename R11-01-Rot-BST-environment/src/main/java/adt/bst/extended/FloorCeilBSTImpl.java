package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		for (int i = 0; i < array.length; i++){
			this.insert(array[i]);
		}
		return floorRecursivo((BSTNode<Integer>) this.root, numero);
	}
	private Integer floorRecursivo(BSTNode<Integer> node, double numero){
		Integer resp = null;
		if(!node.isEmpty()){
			if (node.getData() == numero){
				return node.getData();
			}
			if (node.getData() > numero){
				return floorRecursivo((BSTNode<Integer>) node.getLeft(), numero);
			}
			else{
				resp = floorRecursivo((BSTNode<Integer>) node.getRight(),numero);
			}
		}
		if (resp != null){
			return resp;
		}
		else{
			return node.getData();
		}
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for (int i =0; i < array.length; i++){
			this.insert(array[i]);
		}
		return ceilRecursivo((BSTNode<Integer>) this.root, numero);
	}
	private Integer ceilRecursivo(BSTNode<Integer> node, double numero){
		Integer resp = null;
		if(!node.isEmpty()){
			if (node.getData() == numero){
				return node.getData();
			}
			if (node.getData() < numero){
				return ceilRecursivo((BSTNode<Integer>) node.getRight(), numero);
			}
			else{
				resp = ceilRecursivo((BSTNode<Integer>) node.getLeft(), numero);
			}
		}
		if (resp != null){
			return resp;
		}
		else{
			return node.getData();
		}
	}
}