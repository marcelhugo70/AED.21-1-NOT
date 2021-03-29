package listas;

public interface Pilha<T> {
	//Artur Ruan
	void push(T valor);
	T pop();
	T peek();
	boolean estaVazia();
	void liberar();
}
