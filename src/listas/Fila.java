package listas;

public interface Fila<T> {
	void inserir(T info);
	T retirar();
	T peek();
	boolean estaVazia();
	void liberar();
}
