package listas;

public interface Lista<T> {

	void inserir(T valor);

	int buscar(T valor);

	void retirar(T valor);

	boolean estaVazia();

	String exibir();

	Lista<T> copiar();

	void concatenar(Lista<T> outra);

	int getTamanho();

	T pegar(int posicao);

	Lista<T> dividir();

}