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
		}
		else {
			ultimo.setProximo(novo);
		}
		ultimo = novo;
		qtdeElem++;
		
		/* inserção no início conforme o slide, colocando na ordem inversa
		NoLista novo = new NoLista( );
		novo.setInfo(valor);
		novo.setProximo(primeiro);
		this.primeiro = novo;
		qtdeElem++;
		*/
	}

	@Override
	public int buscar(int valor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void retirar(int valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean estaVazia() {
		return (this.primeiro == null);
	}

	@Override
	public String exibir() {
		String str = "[";
		NoLista p = primeiro;
		while (p != null) { //enquanto p ≠ null faça
		   str += p.getInfo()+", "; //print(p.info);
		   p = p.getProximo();  // avança o p
		}
		return str+"]";
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
