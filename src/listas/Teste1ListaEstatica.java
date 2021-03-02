package listas;

import java.util.ArrayList;

public class Teste1ListaEstatica {

	public static void main(String[] args) {
		ListaEstatica lista = new ListaEstatica();
		lista.inserir(50);
		lista.inserir(-15);
		lista.inserir(12);
		lista.inserir(28);
		lista.inserir(91);

		
		// similar a 
		ArrayList<Integer> listaS = new ArrayList<>();
		listaS.add(50);
		listaS.add(-15);
		listaS.add(12);
		listaS.add(28);
		listaS.add(91);
	}

}
