package ordenacao;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import classes.Veiculo;


class ClasseParaTestarPesquisa {

	private static Veiculo[] vetor;
	private static Integer[] vetorInts;
	private static String[] vetorStrings;
	private static int tamanho = 500;
	
	public static void main(String[] args) {
		initializeClass();
		long ultimoNanoTime, tempoExecucao;


		ClasseDePesquisa<Veiculo> meuAlgoritmo = new ClasseDePesquisa<>();
		{
			Veiculo[] vetorCopiado = Arrays.copyOf(vetor, tamanho);
			Arrays.sort(vetorCopiado);
			System.out.println("Vetor com " + tamanho + " veículos");
			// inicialmente v terá uma placa existente
			Veiculo v = new Veiculo();
			v.setPlaca(vetor[0].getPlaca());
			int posicao;
			ultimoNanoTime = System.nanoTime();
			posicao = meuAlgoritmo.pesquisaLinear(vetorCopiado,v);
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Pesquisa linear COM sucesso " + tamanho + " veículos em "+tempoExecucao+" ns. Posição = "+posicao);
			
			ultimoNanoTime = System.nanoTime();
			posicao = meuAlgoritmo.buscaBinaria(vetorCopiado,v);
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Pesquisa binária COM sucesso " + tamanho + " veículos em "+tempoExecucao+" ns. Posição = "+posicao);

			// agora v terá uma placa inexistente
			v.setPlaca("NAO-9999");
			ultimoNanoTime = System.nanoTime();
			posicao = meuAlgoritmo.pesquisaLinear(vetorCopiado,v);
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Pesquisa linear SEM sucesso " + tamanho + " veículos em "+tempoExecucao+" ns. Posição = "+posicao);

			ultimoNanoTime = System.nanoTime();
			posicao = meuAlgoritmo.buscaBinaria(vetorCopiado,v);
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Pesquisa binária SEM sucesso " + tamanho + " veículos em "+tempoExecucao+" ns. Posição = "+posicao);
			
		}

		ClasseDePesquisa<Integer> meuAlgoritmo2 = new ClasseDePesquisa<>();
		{
			Integer[] vetorCopiado = Arrays.copyOf(vetorInts, tamanho);
			Arrays.sort(vetorCopiado);
			System.out.println("Vetor com " + tamanho + " inteiros");

			int posicao;
			ultimoNanoTime = System.nanoTime();
			posicao = meuAlgoritmo2.pesquisaLinear(vetorCopiado,vetorInts[0]);
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Pesquisa linear COM sucesso " + tamanho + " inteiros em "+tempoExecucao+" ns. Posição = "+posicao);
			
			ultimoNanoTime = System.nanoTime();
			posicao = meuAlgoritmo2.buscaBinaria(vetorCopiado,vetorInts[0]);
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Pesquisa binária COM sucesso " + tamanho + " inteiros em "+tempoExecucao+" ns. Posição = "+posicao);

			ultimoNanoTime = System.nanoTime();
			posicao = meuAlgoritmo2.pesquisaLinear(vetorCopiado,-200);
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Pesquisa linear SEM sucesso " + tamanho + " inteiros em "+tempoExecucao+" ns. Posição = "+posicao);

			ultimoNanoTime = System.nanoTime();
			posicao = meuAlgoritmo2.buscaBinaria(vetorCopiado,-200);
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Pesquisa binária SEM sucesso " + tamanho + " inteiros em "+tempoExecucao+" ns. Posição = "+posicao);

		}
		
		ClasseDePesquisa<String> meuAlgoritmo3 = new ClasseDePesquisa<>();
		{
			String[] vetorCopiado = Arrays.copyOf(vetorStrings, tamanho);
			Arrays.sort(vetorCopiado);
			System.out.println("Vetor com " + tamanho + " Strings");
			
			int posicao;
			ultimoNanoTime = System.nanoTime();
			posicao = meuAlgoritmo3.pesquisaLinear(vetorCopiado,vetorStrings[0]);
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Pesquisa linear COM sucesso " + tamanho + " Strings em "+tempoExecucao+" ns. Posição = "+posicao);
			
			ultimoNanoTime = System.nanoTime();
			posicao = meuAlgoritmo3.buscaBinaria(vetorCopiado,vetorStrings[0]);
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Pesquisa binária COM sucesso " + tamanho + " Strings em "+tempoExecucao+" ns. Posição = "+posicao);

			ultimoNanoTime = System.nanoTime();
			posicao = meuAlgoritmo3.pesquisaLinear(vetorCopiado,"NAO EXISTE");
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Pesquisa linear SEM sucesso " + tamanho + " Strings em "+tempoExecucao+" ns. Posição = "+posicao);

			ultimoNanoTime = System.nanoTime();
			posicao = meuAlgoritmo3.buscaBinaria(vetorCopiado,"NAO EXISTE");
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Pesquisa binária SEM sucesso " + tamanho + " Strings em "+tempoExecucao+" ns. Posição = "+posicao);
		}
	}

	public static void initializeClass() {
		vetor = new Veiculo[tamanho];
		Veiculo veic;
		// geração dos dados
		String nome, placa, modelo;
		int ano;

		for (int i = 0; i < vetor.length; i++) {
			nome = GeradorAleatorioPesquisa.geraNome() + " " + i;
			placa = GeradorAleatorioPesquisa.geraPlaca();
			modelo = GeradorAleatorioPesquisa.geraModelo();
			ano = GeradorAleatorioPesquisa.geraAno();
			vetor[i] = new Veiculo(placa, modelo, ano, nome);
		}

		Random r = new Random();
		vetorInts = new Integer[vetor.length];
		for (int i = 0; i < vetorInts.length; i++) {
			vetorInts[i] = r.nextInt(vetorInts.length*1000);
		}
		
		vetorStrings = new String[vetor.length];
		for (int i = 0; i < vetorStrings.length; i++) {
			vetorStrings[i] = GeradorAleatorioPesquisa.geraNome()+" "
								+GeradorAleatorioPesquisa.geraModelo()+" "
								+GeradorAleatorioPesquisa.geraNome();
		}
	}
}

class GeradorAleatorioPesquisa {

	private static Random geraNumero = new Random();
	private static String[] nomes = { "José", "Maria", "Pedro", "João", "Mario", "Paulo", "Paula", "Sandra", "André",
			"Carla" };
	private static String[] modelos = { "Gol", "Mobi", "Fox", "Fusca", "C3", "Captur", "i30", "Fiesta", "Fit",
			"Picanto" };

	private static int anoAtual = (LocalDate.now().getYear());

	public static String geraNome() {
		return nomes[geraNumero.nextInt(10)];
	}

	public static String geraPlaca() {
		String placa = "";
		for (int i = 0; i < 3; i++) {
			placa += (char) (65 + geraNumero.nextInt(26)); // ASCII 65 = A
		}
		placa += "-";
		for (int i = 0; i < 4; i++) {
			placa += (char) (48 + geraNumero.nextInt(10)); // ASCII 48 = 0
		}

		return placa;
	}

	public static String geraModelo() {
		return modelos[geraNumero.nextInt(10)];
	}

	public static int geraAno() {
		int redutor = geraNumero.nextInt(10);
		if (redutor > 8) {
			redutor = geraNumero.nextInt(60);
		} else {
			redutor = geraNumero.nextInt(20);
		}

		return anoAtual - redutor;
	}
}
