package listas;

public class Teste1PilhaVetor {

	public static void main(String[] args) {
		// Vinícius Manuel Martins
		PilhaVetor<Integer> pilha = new PilhaVetor<Integer>(5);
		pilha.push(5);
		pilha.push(4);
		pilha.push(3);
		pilha.push(2);
		pilha.push(1);
		try { 
			pilha.push(10);
			System.out.println("Não deveria ter chegado aqui!!!");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(pilha);
		System.out.println(pilha.peek());
		System.out.println(pilha.pop());
		System.out.println(pilha);
		System.out.println("Pilha vazia? "+pilha.estaVazia());
		pilha.liberar();
		System.out.println(pilha);
		System.out.println("Pilha vazia? "+pilha.estaVazia());
		try { 
			pilha.pop();
			System.out.println("Não deveria ter chegado aqui!!!");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
}
