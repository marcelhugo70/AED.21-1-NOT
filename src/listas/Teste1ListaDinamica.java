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
			System.out.println("Buscar 50 = "+lista.buscar(50));
			System.out.println("Buscar 91 = "+lista.buscar(91));
			System.out.println("Buscar 100 = "+lista.buscar(100));
			lista.retirar(100);
			lista.retirar(50);
			System.out.println("Lista após retiradas = "+lista.exibir());
			System.out.println("Buscar 50 = "+lista.buscar(50));
			System.out.println("Buscar 91 = "+lista.buscar(91));
			lista.retirar(91);
			System.out.println("Buscar após retirada 91 = "+lista.buscar(91));
			lista.inserir(150);
			System.out.println("Lista após inserção = "+lista.exibir());
	}

}
