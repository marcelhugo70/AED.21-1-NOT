package arvores;

public class ArvoreBST<T extends Comparable> extends ArvoreBinariaAbstract<T> {

	public NoArvoreBST<T> buscar(T procurado) {
		if (this.vazia()) {
			return null;
		}
		return ((NoArvoreBST<T>) this.getRaiz()).buscar(procurado);
	}

	public void inserir(T elemento) {
		if (this.vazia()) {
			NoArvoreBST<T> novo = new NoArvoreBST<>(elemento);
			this.setRaiz(novo);
		} else {
			((NoArvoreBST<T>) this.getRaiz()).inserir(elemento);
		}
	}
	
	private NoArvoreBST<T> descobrirPai(NoArvoreBST<T> filho){
		NoArvoreBST<T> pai = (NoArvoreBST<T>)this.getRaiz();
		while (pai.getEsq() != filho && pai.getDir() != filho) {
			if (filho.getInfo().compareTo(pai.getInfo()) < 0)
				pai = (NoArvoreBST<T>)pai.getEsq();
			else 
				pai = (NoArvoreBST<T>)pai.getDir();
		}
		return pai;
	}
	
	public void retirar(T elemento) {
		NoArvoreBST<T> noRemover = this.buscar(elemento);
		
		if (noRemover != null) {
			this.retirar(noRemover);
		}
	}
	
	private void retirar(NoArvoreBST<T> noRemover) {
		boolean ehRaiz = this.getRaiz() == noRemover;
		NoArvoreBST<T> pai = null;
		if (!ehRaiz) {
			pai = this.descobrirPai(noRemover);
		}
		
		if (noRemover.ehFolha()) {
			if (ehRaiz) {
				this.setRaiz(null);
			} else {
				pai.substituirFilho(null, noRemover.getInfo());
			}
		} else if (noRemover.possuiApenasUmFilho()) {
			NoArvoreBST<T> filho = (NoArvoreBST<T>) (noRemover.getEsq() == null ? noRemover.getDir() : noRemover.getEsq());
			if (ehRaiz) {
				this.setRaiz(filho);
			} else {
				pai.substituirFilho(filho, noRemover.getInfo());
			}
		} else {  // 2 filhos
			NoArvoreBST<T> noSucessor = noRemover.getNoSucessor();
			//NoArvoreBST<T> paiNoSucessor = (NoArvoreBST<T>) this.descobrirPai(noSucessor);
			T info = noSucessor.getInfo();
			this.retirar(noSucessor);
			noRemover.setInfo(info);
		}

	}
	
}
