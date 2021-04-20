package arvores;

public class NoArvoreBST<T extends Comparable> extends NoArvoreBinaria<T> {

	public NoArvoreBST(T info) {
		super(info);
	}

	public NoArvoreBST<T> buscar(T procurado){
		if (this.getInfo().equals(procurado)) {
			return this;
		}
		if (this.getInfo().compareTo(procurado) >= 0) { // procurado é menor que o valor, então vai pra esquerda
			if (this.getEsq() != null) {
				return ((NoArvoreBST<T>)this.getEsq()).buscar(procurado);
			}
			else {
				return null;
			}
		}
		else {
			if (this.getDir() != null) {
				NoArvoreBST<T> direita = (NoArvoreBST<T>)this.getDir(); 
				return direita.buscar(procurado);
			}
			else {
				return null;
			}
		}
	}

	public void inserir(T elemento) {
		if (this.getInfo().compareTo(elemento) >= 0) { // elemento é menor que o valor, então vai pra esquerda
			if (this.getEsq() != null) {
				((NoArvoreBST<T>)this.getEsq()).inserir(elemento);
			}
			else {
				this.setEsq(new NoArvoreBST<>(elemento));
			}
		}
		else {
			if (this.getDir() != null) {
				NoArvoreBST<T> direita = (NoArvoreBST<T>)this.getDir(); 
				direita.inserir(elemento);
			}
			else {
				this.setDir(new NoArvoreBST<>(elemento));
			}
		}
	}
}
