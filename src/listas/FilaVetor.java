package listas;

public class FilaVetor<T> implements Fila<T> {

	private T[] info;
	private int limite;
	private int tamanho;
	private int inicio;

	public FilaVetor(int limite) {
		info = (T[]) new Object[limite];
		this.limite = limite;
		this.tamanho = 0;
		this.inicio = 0;
	}

	@Override
	public void inserir(T valor) {
		if (limite == tamanho) {
			throw new RuntimeException("Fila cheia");
		}
		int posicao = (inicio + tamanho) % limite;
		info[posicao] = valor;
		tamanho++;
	}

	@Override
	public T retirar() {
		T valor = peek();
		info[inicio] = null;
		inicio = (inicio + 1) % limite;
		tamanho--;
		return valor;
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new RuntimeException("Fila vazia");
		}
		return info[inicio];
	}

	@Override
	public boolean estaVazia() {
		if (tamanho == 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void liberar() {
		this.info = (T[]) new Object[limite];
		this.tamanho = 0;
		this.inicio = 0;
	}

	public String toString() {
		String str = "[";
		int pos;
		for (int i = 0; i < this.tamanho; i++) {
			pos = (inicio+i) % limite;
			str += info[pos] + ",";
		}
		return str + "]";
	}

}
