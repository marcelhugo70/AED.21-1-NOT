package listas;

public class Teste1ListaDinamica {

		public static void main(String[] args) {
			Lista lista = new ListaEncadeada();
			lista.inserir(50);
			lista.inserir(-15);
			lista.inserir(12);
			lista.inserir(28);
			lista.inserir(91);
			System.out.println("Lista original = "+lista.exibir());
			

	}

}
