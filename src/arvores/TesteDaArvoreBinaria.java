package arvores;

public class TesteDaArvoreBinaria {
	public static void main(String args[]) {
		NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
		NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
		NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, no4, no5);
		NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<>(7);
		NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6, no7, null);
		  
		NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, null, no6);
		 
		NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);
		 
		ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
		arvore.setRaiz(no1);
		System.out.println(arvore);
		
		System.out.println(arvore.pertence(7));
		System.out.println(arvore.pertence(10));
		System.out.println(arvore.pertence(1));
		System.out.println(arvore.pertence(4));
	}
	
}