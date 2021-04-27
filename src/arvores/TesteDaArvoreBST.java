package arvores;

public class TesteDaArvoreBST {

	public static void main(String[] args) {
		ArvoreBST<Integer> arvore = new ArvoreBST<>();
		
		arvore.inserir(41);
		arvore.inserir(20);
		arvore.inserir(65);
		arvore.inserir(11);
		arvore.inserir(29);
		arvore.inserir(32);
		arvore.inserir(50);
		arvore.inserir(91);
		arvore.inserir(72);
		arvore.inserir(99);
		System.out.println(arvore.toString());
		arvore.retirar(20);
		System.out.println(arvore);
		arvore.retirar(50);
		System.out.println(arvore);
		arvore.retirar(72);
		System.out.println(arvore);
		arvore.retirar(32);
		System.out.println(arvore);
		arvore.retirar(41);
		System.out.println(arvore);
		
	}

}
