package arvores;

public abstract class ArvoreBinariaAbstract<T> {
	private NoArvoreBinaria<T> raiz;

	public ArvoreBinariaAbstract() {
		super();
	}

	protected void setRaiz(NoArvoreBinaria<T> raiz) {
		this.raiz = raiz;
	}
	
	protected NoArvoreBinaria<T> getRaiz(){
		return this.raiz;
	}

	public boolean vazia() {
		return (this.raiz == null);
	}

	@Override
	public String toString() {
		if (this.vazia()) {
			return "< >";
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
