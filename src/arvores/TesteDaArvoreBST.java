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
	}

}
