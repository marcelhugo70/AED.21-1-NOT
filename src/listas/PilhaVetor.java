package listas;

public class PilhaVetor<T> implements Pilha<T> {
// Daniel Busarello
	private T[] data;
	private int limit;
	private int size;

	public PilhaVetor(int limit) {
		this.limit = limit;
		data = (T[]) new Object[limit];
	}

	@Override
	public void push(T data) {
		if (size < limit) {
			this.data[size] = data;
			size++;
		} else {
			throw new IndexOutOfBoundsException("Limite máximo da pilha alcançado");
		}

	}

	@Override
	public T pop() {
		T temp = this.peek();
		size--;
		this.data[size] = null;
		return temp;
	}

	@Override
	public T peek() {
		if (this.estaVazia()) {
			throw new IndexOutOfBoundsException("Pilha vazia");
		}
		return this.data[size-1];
	}

	@Override
	public boolean estaVazia() {
		if (size == 0)
			return true;
		return false;
	}

	@Override
	public void liberar() {
		this.data = (T[]) new Object[limit];
		this.size = 0;
	}

	public String toString() {
		String str = "[base=";
		for (int i=0; i < this.size; i++) {
			str += data[i]+",";
		}
		return str+"=topo]";
	}

}
