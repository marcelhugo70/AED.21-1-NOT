package listas;

public class ListaEstatica {
	private int[] info;
	private int tamanho;
	
	public ListaEstatica() {
		info = new int[10];
		tamanho = 0;
	}
	
	public void inserir(int valor) {
		if (tamanho == info.length) {
			this.redimensionar();
		}
		info[tamanho] = valor;
		tamanho++;
	}
	
	private void redimensionar() {
		int[] novo = new int[tamanho+10];
		
		for (int i=0; i < tamanho; i++) {
			novo[i] = info[i];
		}
		info = novo;
	}
	
	public int buscar(int valor) {
		for (int i=0; i < tamanho; i++) {
			if (info[i] == valor) {
				return i;
			}
		}
		return -1;
	}
	
	public void retirar(int valor) {
		int posicao = this.buscar(valor);
		if (posicao != -1) {
			for (int i=posicao; i < tamanho-1; i++) {
				info[i] = info[i+1];
			}
			tamanho--;
		}
	}
	
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
	
	public String exibir() {
		String str = "[";
		for (int i=0; i < tamanho; i++) {
			str += info[i]+", ";
		}
		str += "]";
		return str;
	}
	
	public ListaEstatica copiar() {
		ListaEstatica nova = new ListaEstatica();
		for (int i=0; i < tamanho; i++) {
			nova.inserir(info[i]);
		}
		return nova;
	}
	
	public void concatenar(ListaEstatica outra) {
		for (int i=0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public int pegar(int posicao) {
		if (posicao < 0 || posicao >= tamanho) {
			throw new ArrayIndexOutOfBoundsException("Posição inválida "+posicao);
		}
		return info[posicao];
	}
	
	public ListaEstatica dividir() {
		ListaEstatica nova = new ListaEstatica();
		int metade = tamanho/2;
		for (int i=metade; i < tamanho; i++) {
			nova.inserir(info[i]);
		}
		tamanho = metade;
		return nova;
	}
}
