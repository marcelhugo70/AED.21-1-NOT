package mapas;

import java.math.BigInteger;

/*
 * Esta implementação de MapaDispersao não realiza o tratamento de colisão.
 * @author Marcel Hugo
 * 
 * Dupla: xxx & yyy
 */

public class MapaDispersao<K, T> {

	private ObjetoMapa<K, T>[] tabela;

	public MapaDispersao(int quantidade) {
		BigInteger bi = BigInteger.valueOf(quantidade * 2);
		this.tabela = new ObjetoMapa[bi.nextProbablePrime().intValue()];
	}

	private int calcularHash(K chave) {
		// calcula índice do vetor
		return (chave.hashCode() & 0x7fffffff) % tabela.length;
	}

	public boolean inserir(K chave, T valor) {
		int index = calcularHash(chave);

		if (tabela[index] == null) { // se posição estiver vazia, guarda o par<chave,valor>
			ObjetoMapa<K, T> om = new ObjetoMapa<K, T>();
			om.setChave(chave);
			om.setValor(valor);
			tabela[index] = om;
			return true;
		} else { // já possui um objeto na posição
			return false;
		}

	}

	public T buscar(K chave) {
		int index = calcularHash(chave);
		if (tabela[index] == null) {
			return null;
		}
		return tabela[index].getValor();
	}

	public T remover(K chave) {
		int index = calcularHash(chave);
		if (tabela[index] == null) {
			return null;
		}
		T temp = tabela[index].getValor();
		tabela[index] = null;
		return temp;
	}
}
