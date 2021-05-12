package arvores;

public class NoArvoreBST<T extends Comparable> extends NoArvoreBinaria<T> {

	public NoArvoreBST(T info) {
		super(info);
	}

	public NoArvoreBST<T> buscar(T procurado) {
		if (this.getInfo().equals(procurado)) {
			return this;
		}
		if (this.getInfo().compareTo(procurado) >= 0) { // procurado é menor que o valor, então vai pra esquerda
			if (this.getEsq() != null) {
				return ((NoArvoreBST<T>) this.getEsq()).buscar(procurado);
			} else {
				return null;
			}
		} else {
			if (this.getDir() != null) {
				NoArvoreBST<T> direita = (NoArvoreBST<T>) this.getDir();
				return direita.buscar(procurado);
			} else {
				return null;
			}
		}
	}

	public void inserir(T elemento) {
		if (this.getInfo().compareTo(elemento) >= 0) { // elemento é menor que o valor, então vai pra esquerda
			if (this.getEsq() != null) {
				((NoArvoreBST<T>) this.getEsq()).inserir(elemento);
			} else {
				this.setEsq(new NoArvoreBST<>(elemento));
			}
		} else {
			if (this.getDir() != null) {
				NoArvoreBST<T> direita = (NoArvoreBST<T>) this.getDir();
				direita.inserir(elemento);
			} else {
				this.setDir(new NoArvoreBST<>(elemento));
			}
		}
	}

	public void substituirFilho(NoArvoreBST<T> novoFilho, T info) {
		if (info.compareTo(this.getInfo()) < 0) {
			this.setEsq(novoFilho);
		} else {
			this.setDir(novoFilho);
		}
	}

	public boolean ehFolha() {
		return (this.getEsq() == null && this.getDir() == null);
	}

	public boolean possuiApenasUmFilho() {
		return (this.getEsq() != null && this.getDir() == null) || (this.getEsq() == null && this.getDir() != null);
	}

	public NoArvoreBST<T> getNoSucessor() {
		NoArvoreBST<T> noSucessor = (NoArvoreBST<T>)this.getDir();

		if (noSucessor == null) {
			return null;
		}
		while (noSucessor.getEsq() != null) {
			noSucessor = (NoArvoreBST<T>)noSucessor.getEsq();
		}
		return noSucessor;
	}

	// ordem simétrica ou central ou em ordem
	public String imprimeEmOrdem() {
		String impressao = "";
		if (this.getEsq() != null) {
			impressao += ((NoArvoreBST)this.getEsq()).imprimeEmOrdem();
		} 
		impressao += this.getInfo() + " ";
		if (this.getDir() != null) {
			impressao += ((NoArvoreBST)this.getDir()).imprimeEmOrdem();
		} 
		return impressao;
	}
}
