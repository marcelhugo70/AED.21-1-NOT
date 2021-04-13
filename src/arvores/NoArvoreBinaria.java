package arvores;

public class NoArvoreBinaria<T> {
	private T info;
	private NoArvoreBinaria<T> esq;
	private NoArvoreBinaria<T> dir;

	public NoArvoreBinaria(T info) {
		this.info = info;
	}

	public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
		this.info = info;
		this.esq = esq;
		this.dir = dir;
	}

	public NoArvoreBinaria<T> pertence(T procurado) {
		if (this.info.equals(procurado)) {
			return this;
		} else {
			NoArvoreBinaria<T> resultado = null;
			if (this.esq != null) {
				resultado = this.esq.pertence(procurado);
			}
			if (resultado != null) {
				return resultado; 
			}
			if (this.dir != null) {
				return this.dir.pertence(procurado);
			}
			else {
				return null;
			}
		}
	}

	public String imprimePre() {
		String impressao = "<" + this.info + " ";
		if (this.esq != null) {
			impressao += this.esq.imprimePre();
		} else
			impressao += "<>";
		if (this.dir != null) {
			impressao += this.dir.imprimePre();
		} else
			impressao += "<>";
		return impressao + ">";
	}

	@Override
	public String toString() {
		return this.info.toString() ;
	}
	
	
}
