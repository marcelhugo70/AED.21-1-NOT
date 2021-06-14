package ordenacao;

public class ClasseDePesquisa<T extends Comparable<T>> {
	public int pesquisaLinear(T[] vetor, T elem) {
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i].equals(elem)) {
				return i;
			}
		}
		return -1;
	}

	public int buscaBinaria(T[] vetor, T elem) {
		int inicio = 0;
		int fim = vetor.length - 1;
		int meio;

		while (inicio <= fim) {
			meio = (inicio + fim) / 2;
			if (elem.compareTo(vetor[meio]) < 0) {
				fim = meio - 1;
			} else if (elem.compareTo(vetor[meio]) > 0) {
				inicio = meio + 1;
			} else {
				return meio;
			}
		}
		return -1;
	}
}
