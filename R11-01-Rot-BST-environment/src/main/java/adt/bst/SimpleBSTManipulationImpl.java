package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		BSTNode<T> node1 = (BSTNode<T>) tree1.getRoot();
		BSTNode<T> node2 = (BSTNode<T>) tree2.getRoot();
		return equalsRecursivo(node1, node2);
	}
	private boolean equalsRecursivo(BSTNode<T> node1, BSTNode<T> node2){
		if (node1.isEmpty() && node2.isEmpty()){
			return true;
		}
		if (node1.getData().equals(node2.getData())){
			return true;
		}
		if (!node1.getData().equals(node2.getData()) || node1.isEmpty() || node2.isEmpty()){
			return false;
		}
		return (equalsRecursivo((BSTNode<T>) node1.getLeft(),(BSTNode<T>)node2.getLeft()) && equalsRecursivo((BSTNode<T>) node1.getRight(),(BSTNode<T>)node2.getRight()));
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		BSTNode<T> node1 = (BSTNode<T>) tree1.getRoot();
		BSTNode<T> node2 = (BSTNode<T>) tree2.getRoot();
		return isSimilarRecursivo(node1,node2);
	}
	private boolean isSimilarRecursivo(BSTNode<T> node1, BSTNode<T> node2){
		if (node1.isEmpty() && node2.isEmpty()){
			return true;
		}
		else if (node1.isEmpty()||node2.isEmpty()){
			return false;
		}
		return (isSimilarRecursivo((BSTNode<T>)node1.getLeft(),(BSTNode<T>)node2.getLeft()) && isSimilarRecursivo((BSTNode<T>)node1.getRight(), (BSTNode<T>)node2.getRight()));
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		if (k > tree.size()){
			return null;
		}
		BSTNode<T> minimo = tree.minimum();
		return orderStatisticsRecursive(tree,minimo,k);
	}
	private T orderStatisticsRecursive(BST<T> arvore, BSTNode<T> menor, int k){
		if(k<=1){
			if (!menor.isEmpty()){
				return menor.getData();
			}
			else{
				return null;
			}
		}
		arvore.remove(menor.getData());
		BSTNode<T> novoMenor = arvore.minimum();
		return orderStatisticsRecursive(arvore, novoMenor, k-1);
	}

}