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
		arvore.inserir(72);
		System.out.println(arvore.toString());
		
		System.out.println("Menor = "+arvore.encontraMenor());
		System.out.println("Maior = "+arvore.encontraMaior());
		System.out.println("Antecessores -------");
		System.out.println(arvore.descobreAntecessor(11));
		System.out.println(arvore.descobreAntecessor(50));
		System.out.println(arvore.descobreAntecessor(20));
		System.out.println(arvore.descobreAntecessor(72));
		System.out.println(arvore.descobreAntecessor(100));
		System.out.println("Sucessores -------");
		System.out.println(arvore.descobreSucessor(11));
		System.out.println(arvore.descobreSucessor(50));
		System.out.println(arvore.descobreSucessor(20));
		System.out.println(arvore.descobreSucessor(72));
		System.out.println(arvore.descobreSucessor(100));
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
