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
		while (p != null && p.getInfo()!=valor) {
			anterior = p;
			p = p.getProximo();
		}
		if (p!=null) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void concatenar(Lista outra) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getTamanho() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int pegar(int posicao) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Lista dividir() {
		// TODO Auto-generated method stub
		return null;
	}

}
