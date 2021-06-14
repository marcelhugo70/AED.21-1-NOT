package ordenacao;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public void sort(T[] vetor) {
		boolean troca=false;
		T temp;
		for (int i=vetor.length-1; i > 0; i--) {
			troca = false;
			for (int j=0; j < i; j++) {
				if (vetor[j].compareTo(vetor[j+1]) > 0) {
					temp = vetor[j];
					vetor[j] = vetor[j+1];
					vetor[j+1] = temp;
					troca = true;
				}
			}
			if (!troca) {
				return;
			}
		}
		
	}
}
