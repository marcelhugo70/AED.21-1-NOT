package arvores;

public class ArvoreBinaria<T> {
	private NoArvoreBinaria<T> raiz;

	public ArvoreBinaria() {
		super();
	}

	public void setRaiz(NoArvoreBinaria<T> raiz) {
		this.raiz = raiz;
	}

	public boolean vazia() {
		return (this.raiz == null);
	}

	@Override
	public String toString() {
		if (this.vazia()) {
			return "<>";
		} else {
			return this.raiz.imprimePre();
		}
	}
	
	public NoArvoreBinaria<T> pertence(T procurado){
		if (this.vazia()) {
			return null;
		}
		return raiz.pertence(procurado);
	}
}
