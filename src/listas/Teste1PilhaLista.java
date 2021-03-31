package listas;

public class Teste1PilhaLista {

	public static void main(String[] args) {
		PilhaLista<Integer> pilha = new PilhaLista<Integer>();
		pilha.push(5);
		pilha.push(4);
		pilha.push(10);
		pilha.push(2);
		pilha.push(10);

		System.out.println(pilha);
		System.out.println("Consulta ao topo = 10 = "+pilha.peek());
		System.out.println("Retirada do topo = 10 = "+pilha.pop());
		System.out.println(pilha);
		System.out.println("Pilha vazia? "+pilha.estaVazia());
		pilha.liberar();
		System.out.println(pilha);
		System.out.println("Pilha vazia? "+pilha.estaVazia());
		try { 
			pilha.pop();
			System.out.println("Não deveria ter chegado aqui!!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
