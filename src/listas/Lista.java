package listas;

public interface Lista {

	void inserir(int valor);

	int buscar(int valor);

	void retirar(int valor);

	boolean estaVazia();

	String exibir();

	Lista copiar();

	void concatenar(Lista outra);

	int getTamanho();

	int pegar(int posicao);

	Lista dividir();

}