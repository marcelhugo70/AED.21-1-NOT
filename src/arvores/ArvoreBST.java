package arvores;

public class ArvoreBST<T extends Comparable> extends ArvoreBinariaAbstract<T> {

	public NoArvoreBST<T> buscar(T procurado){
		if (this.vazia()) {
			return null;
		}
		return ((NoArvoreBST<T>)this.getRaiz()).buscar(procurado);
	}
	
	public void inserir(T elemento){
		if (this.vazia()) {
			NoArvoreBST<T> novo = new NoArvoreBST<>(elemento);
			this.setRaiz(novo);
		}
		else {
			((NoArvoreBST<T>)this.getRaiz()).inserir(elemento);
		}
	}
}
