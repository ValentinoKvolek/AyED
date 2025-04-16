package main.java.tp3.ejercicio1;

import main.java.tp1.ejercicio8.Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {
		int altura =0;

		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		queue.enqueue(this); // encolo raiz;

		while (!queue.isEmpty()) {

			int cantNodos = queue.size(); // cantidad de nodos en este nivel

			for (int i = 0; i < cantNodos; i++) {

				GeneralTree<T> actual = queue.dequeue();

				for (GeneralTree<T> child : actual.getChildren()) {
					if (child != null && !child.isEmpty()) {
						queue.enqueue(child);
					}
				}
			}
			altura++;
		}
			
		return altura;
	}
	
	public int nivel(T dato){

		int numNivel=0;

		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();

		queue.enqueue(this);

		while(!queue.isEmpty()){

			int cantNodos = queue.size();

			for (int i=0; i<cantNodos; i++){

				GeneralTree<T> actual = queue.dequeue();

				if(actual.getData().equals(dato)) {
					return numNivel;
				}
				for (GeneralTree<T> hijo : actual.getChildren()){
					if(hijo != null && !hijo.isEmpty()){
						queue.enqueue(hijo);
					}
				}
			}
			numNivel++;
		}
		return -1; //si no lo encontro
	  }

	public int ancho(){

		int max = 0;

		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		queue.enqueue(this);
		while(!queue.isEmpty()){

			int cantNodos = queue.size();

			if(cantNodos > max){
				max=cantNodos;
			}

			for (int i=0; i<cantNodos; i++){

				GeneralTree<T> actual = queue.dequeue();

				for (GeneralTree<T> hijo : actual.getChildren()){
					if(hijo != null && !hijo.isEmpty()){
						queue.enqueue(hijo);
					}
				}
			}
		}
		return max;
	}
}