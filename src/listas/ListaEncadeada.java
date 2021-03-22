package listas;

public class ListaEncadeada implements Lista {
	private NoLista primeiro;
	private NoLista ultimo;
	private int qtdeElem;

	@Override
	public void inserir(int valor) {
		// inserção ao final, colocando numa ordem mais normal/natural
		NoLista novo = new NoLista();
		novo.setInfo(valor);
		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProximo(novo);
		}
		ultimo = novo;
		qtdeElem++;

		/*
		 * inserção no início conforme o slide, colocando na ordem inversa NoLista novo
		 * = new NoLista( ); novo.setInfo(valor); novo.setProximo(primeiro);
		 * this.primeiro = novo; qtdeElem++;
		 */
	}

	@Override
	public int buscar(int valor) {
		/*
		 * NoLista p ← primeiro; enquanto (p ≠ null) faça se p.info = v então retornar
		 * p; fim-se; p ← p.proximo; fim-enquanto; retornar null;
		 */
		int posicao = 0;
		NoLista p = primeiro;
		while (p != null) {
			if (p.getInfo() == valor) {
				return posicao;
			}
			posicao++;
			p = p.getProximo();
		}
		return -1;
	}

	@Override
	public void retirar(int valor) {
		/*
		 * NoLista anterior ← null; NoLista p ← primeiro;
		 * 
		 * // procura nó que contém dado a ser removido, // guardando o anterior
		 * enquanto (p ≠ null) e (p.info ≠ v) faça anterior ← p; p ← p.proximo;
		 * fim-enquanto;
		 * 
		 * // Se achou nó, retira-o da lista se (p ≠ null) então se anterior = null
		 * então this.primeiro ← p.proximo; senão anterior.proximo ← p.proximo; fim-se;
		 * fim-se;
		 * 
		 */
		NoLista anterior = null;
		NoLista p = primeiro;
		while (p != null && p.getInfo() != valor) {
			anterior = p;
			p = p.getProximo();
		}
		if (p != null) {
			qtdeElem--;
			if (anterior == null) {
				primeiro = p.getProximo();
			} else {
				anterior.setProximo(p.getProximo());
			}
			if (ultimo == p) {
				ultimo = anterior;
			}
		}

	}

	@Override
	public boolean estaVazia() {
		return (this.primeiro == null);
	}

	@Override
	public String exibir() {
		String str = "[";
		NoLista p = primeiro;
		while (p != null) { // enquanto p ≠ null faça
			str += p.getInfo() + ", "; // print(p.info);
			p = p.getProximo(); // avança o p
		}
		return str + "]";
	}

	@Override
	public Lista copiar() {
		ListaEncadeada nova = new ListaEncadeada();
		NoLista p = primeiro;
		while (p != null) {
			nova.inserir(p.getInfo());
			p = p.getProximo();
		}

		return nova;
	}

	@Override
	public void concatenar(Lista outra) {
		for (int i = 0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}
	}

	@Override
	public int getTamanho() {
		return qtdeElem;
	}

	@Override
	public int pegar(int posicao) {
		if (posicao < 0 || posicao >= this.getTamanho()) {
			throw new IndexOutOfBoundsException("Posição inválida " + posicao);
		}
		NoLista p = primeiro;
		int conta = 0;
		while (p != null) {
			if (posicao == conta) {
				return p.getInfo();
			}
			conta++;
			p = p.getProximo();
		}
		// Nunca deveria chegar aqui....
		return Integer.MIN_VALUE;
		/*
		 * p = this.primeiro; for (int i=0; i != posicao; i++) { p = p.getProximo(); }
		 * return p.getInfo();
		 */
	}

	@Override
	public Lista dividir() {
		ListaEncadeada metadeLista = new ListaEncadeada();
		NoLista itemAtual = this.primeiro;
		int index = 0;
		int indiceMetadeLista = this.getTamanho() / 2 - 1;

		while (itemAtual != null) {
			if (index == indiceMetadeLista) {
				this.ultimo = itemAtual;
			}

			if (index > indiceMetadeLista) {
				metadeLista.inserir(itemAtual.getInfo());
				this.qtdeElem--;
			}

			itemAtual = itemAtual.getProximo();
			index++;
		}
		this.ultimo.setProximo(null);
		return metadeLista;
	}

}
