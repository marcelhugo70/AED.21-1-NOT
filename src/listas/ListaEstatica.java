package listas;

public class ListaEstatica<T> implements Lista<T> {
	private T[] info;
	private int tamanho;
	
	public ListaEstatica() {
		info = (T[]) new Object[10];
		tamanho = 0;
	}
	
	@Override
	public void inserir(T valor) {
		if (tamanho == info.length) {
			this.redimensionar();
		}
		info[tamanho] = valor;
		tamanho++;
	}
	
	private void redimensionar() {
		T[] novo = (T[]) new Object[tamanho+10];
		
		for (int i=0; i < tamanho; i++) {
			novo[i] = info[i];
		}
		info = novo;
	}
	
	@Override
	public int buscar(T valor) {
		for (int i=0; i < tamanho; i++) {
			if (info[i] == valor) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public void retirar(T valor) {
		int posicao = this.buscar(valor);
		if (posicao != -1) {
			for (int i=posicao; i < tamanho-1; i++) {
				info[i] = info[i+1];
			}
			tamanho--;
		}
	}
	
	@Override
	public boolean estaVazia() {
		return (tamanho == 0);
		/*
		if (tamanho == 0) {
			return true;
		}else {
			return false;
		}
		*/
	}
	
	@Override
	public String exibir() {
		String str = "[";
		for (int i=0; i < tamanho; i++) {
			str += info[i]+", ";
		}
		str += "]";
		return str;
	}
	
	@Override
	public Lista<T> copiar() {
		Lista<T> nova = new ListaEstatica<>();
		for (int i=0; i < tamanho; i++) {
			nova.inserir(info[i]);
		}
		return nova;
	}
	
	@Override
	public void concatenar(Lista<T> outra) {
		for (int i=0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}
	}
	
	@Override
	public int getTamanho() {
		return tamanho;
	}
	
	@Override
	public T pegar(int posicao) {
		if (posicao < 0 || posicao >= tamanho) {
			throw new ArrayIndexOutOfBoundsException("Posição inválida "+posicao);
		}
		return info[posicao];
	}
	
	@Override
	public Lista<T> dividir() {
		Lista<T> nova = new ListaEstatica<>();
		int metade = tamanho/2;
		for (int i=metade; i < tamanho; i++) {
			nova.inserir(info[i]);
		}
		tamanho = metade;
		return nova;
	}
}
