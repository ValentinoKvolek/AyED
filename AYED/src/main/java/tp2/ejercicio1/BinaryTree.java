package main.java.tp2.ejercicio1;

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree <T> {

	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;


	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}

	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {

	  	if (this.isLeaf()) {
			return 1;
		}
		  int contadorHojas = 0;
		if(this.hasLeftChild()) {
			contadorHojas += this.getLeftChild().contarHojas();
		}

		if(this.hasRightChild()) {
			contadorHojas += this.getRightChild().contarHojas();
		}

		return contadorHojas;
	}


    	 
    public BinaryTree<T> espejo(){

		if (this.isLeaf()) {
			return this;
		}

		// en este caso al intercambiar, aunque se NUll uno de los dos o los dos inclusive.
		//no hay error ya que solamente estamos asignando un valor null no estamos accediendo.

		BinaryTree<T> temp = this.leftChild;
		this.leftChild = this.rightChild;
		this.rightChild = temp;

		if (this.hasLeftChild()) {
			this.leftChild = this.leftChild.espejo();
		}
		if (this.hasRightChild()) {
			this.rightChild = this.rightChild.espejo();
		}
		return this;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		if(n > m) {
			return;
		}
		if(n > 0){
			if(this.hasLeftChild()) {
				this.leftChild.entreNiveles(n-1, m-1);
			}
			if(this.hasRightChild()) {
				this.rightChild.entreNiveles(n-1, m-1);
			}
		} else if (m>=0) {
			System.out.println(this);
			if(this.hasLeftChild()) {
				this.leftChild.entreNiveles(0, m-1);
			}
			if(this.hasRightChild()) {
				this.rightChild.entreNiveles(0, m-1);
			}

		}

	}
		
}

