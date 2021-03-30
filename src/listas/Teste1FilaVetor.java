package listas;

public class Teste1FilaVetor {

	public static void main(String[] args) {
		FilaVetor<Integer> fila = new FilaVetor<Integer>(5);
		fila.inserir(50);
		fila.inserir(40);
		fila.inserir(30);
		fila.inserir(20);
		fila.inserir(10);
		try { 
			fila.inserir(5);
			System.out.println("Não deveria ter chegado aqui!!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(fila);
		System.out.println("Consulta ao início = 50 = "+fila.peek());
		System.out.println("Retirada do início = 50 = "+fila.retirar());
		System.out.println(fila);
		System.out.println("fila vazia? "+fila.estaVazia());
		System.out.println("Retirada do início = 40 = "+fila.retirar());
		System.out.println("Retirada do início = 30 = "+fila.retirar());
		fila.inserir(100);
		fila.inserir(200);
		System.out.println(fila);
		fila.liberar();
		System.out.println("Liberada="+fila);
		System.out.println("fila vazia? "+fila.estaVazia());
		try { 
			fila.retirar();
			System.out.println("Não deveria ter chegado aqui!!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
