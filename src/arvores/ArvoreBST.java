package arvores;

public class ArvoreBST<T extends Comparable> extends ArvoreBinariaAbstract<T> {

	public NoArvoreBST<T> encontraMenor() { // esquerda
		if (this.vazia()) {
			return null;
		}
		NoArvoreBST<T> aux = (NoArvoreBST<T>) this.getRaiz();
		while (aux.getEsq() != null) {
			aux = (NoArvoreBST<T>) aux.getEsq();
		}
		return aux;
	}

	public NoArvoreBST<T> encontraMaior() { // direita
		if (this.vazia()) {
			return null;
		}
		NoArvoreBST<T> aux = (NoArvoreBST<T>) this.getRaiz();
		while (aux.getDir() != null) {
			aux = (NoArvoreBST<T>) aux.getDir();
		}
		return aux;
	}

	public NoArvoreBST<T> descobreAntecessor(T elemento) {
		NoArvoreBST<T> noElemento = this.buscar(elemento);
		if (noElemento == null) {
			return null;
		}

		if (noElemento.getEsq() != null) {
			noElemento = (NoArvoreBST<T>) noElemento.getEsq();
			while (noElemento.getDir() != null) {
				noElemento = (NoArvoreBST<T>) noElemento.getDir();
			}
			return noElemento;
		} else {
			NoArvoreBST<T> pai = this.descobrirPai(noElemento);
			while (pai != null && pai.getInfo().compareTo(noElemento.getInfo()) >= 0) {
				pai = descobrirPai(pai); // vai subindo até achar um menor
			}
			return pai;
		}
	}
	
	public NoArvoreBST<T> descobreSucessor(T elemento) {
		NoArvoreBST<T> noElemento = this.buscar(elemento);
		if (noElemento == null) {
			return null;
		}

		if (noElemento.getDir() != null) {
			noElemento = (NoArvoreBST<T>) noElemento.getDir();
			while (noElemento.getEsq() != null) {
				noElemento = (NoArvoreBST<T>) noElemento.getEsq();
			}
			return noElemento;
		} else {
			NoArvoreBST<T> pai = this.descobrirPai(noElemento);
			while (pai != null && pai.getInfo().compareTo(noElemento.getInfo()) <= 0) {
				pai = descobrirPai(pai); // vai subindo até achar um maior
			}
			return pai;
		}
	}

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

	private NoArvoreBST<T> descobrirPai(NoArvoreBST<T> filho) {
		if (filho == this.getRaiz()) {
			return null;
		}
		NoArvoreBST<T> pai = (NoArvoreBST<T>) this.getRaiz();
		while (pai.getEsq() != filho && pai.getDir() != filho) {
			if (filho.getInfo().compareTo(pai.getInfo()) < 0)
				pai = (NoArvoreBST<T>) pai.getEsq();
			else
				pai = (NoArvoreBST<T>) pai.getDir();
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
			NoArvoreBST<T> filho = (NoArvoreBST<T>) (noRemover.getEsq() == null ? noRemover.getDir()
					: noRemover.getEsq());
			if (ehRaiz) {
				this.setRaiz(filho);
			} else {
				pai.substituirFilho(filho, noRemover.getInfo());
			}
		} else { // 2 filhos
			NoArvoreBST<T> noSucessor = noRemover.getNoSucessor();
			// NoArvoreBST<T> paiNoSucessor = (NoArvoreBST<T>)
			// this.descobrirPai(noSucessor);
			T info = noSucessor.getInfo();
			this.retirar(noSucessor);
			noRemover.setInfo(info);
		}

	}

}
