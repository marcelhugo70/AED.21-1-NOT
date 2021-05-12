package arvores;

import java.util.Random;
import java.util.Scanner;

public class TesteArvoreBSTInteirosAleatorios {

	public static void main(String[] args) {
		int qtd = 0;
		int aux = 0;
		ArvoreBST<Integer> arvore = new ArvoreBST<Integer>();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Insira a quantidade de nós da arvore:");
		qtd = teclado.nextInt();
		Random gerador = new Random();
		if (qtd > 0) {
			int vetor[] = new int[qtd];
			for (int i = 0; i < qtd; i++) { // insere aleatoriamente
				aux = gerador.nextInt(100_000); // salva um numero aleatorio em AUX
				arvore.inserir(aux); // insere AUX na arvore
				vetor[i] = aux; // insere AUX no vetor
			}
			System.out.println(arvore);
			for (int i = 0; i < 2*qtd; i++) { // remove aleatoriamente baseado no index do vetor
				aux = gerador.nextInt(qtd); // aleatoriza um index do vetor
				arvore.retirar(vetor[aux]); // retira o valor baseado no vetor
				System.out.println(vetor[aux] + " retirado: ");
				System.out.println(arvore);
			}
		}
	}

}
