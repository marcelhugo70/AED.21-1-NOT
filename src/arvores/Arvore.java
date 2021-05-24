package arvores;

public class Arvore<T> {
	private NoArvore<T> raiz;

	public Arvore() {
		super();
		this.raiz = null;
	}

	public NoArvore<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NoArvore<T> raiz) {
		if (raiz != null) {
			this.raiz = raiz;
		}
	}

	public boolean vazia() {
		return (this.raiz == null);
	}

	public String toString() {
		if (this.vazia()) {
			return "<>";
		} else {
			return this.raiz.imprimePre();
		}
	}

	public NoArvore<T> pertence(T procurado) {
		if (this.vazia()) {
			return null;
		} else {
			return this.raiz.pertence(procurado);
		}
	}

	public int getAltura() {
		if (this.vazia()) {
			return -1;
		} else {
			return this.raiz.getAltura(0);
		}
	}
	
	public int getNivel(T info) {
		if (this.vazia()) {
			return -1;
		} else {
			return this.raiz.getNivel(info,0);
		}
	}
}
