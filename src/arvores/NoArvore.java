package arvores;

public class NoArvore<T> {
	private T info;
	private NoArvore<T> filho;
	private NoArvore<T> irmao;

	public NoArvore(T info) {
		this.info = info;
		this.filho = null;
		this.irmao = null;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public String imprimePre() {
		String impressao = "<" + this.info;
		if (this.filho != null) {
			impressao += filho.imprimePre();
		}
		impressao += ">";
		if (this.irmao != null) {
			impressao += irmao.imprimePre();
		}
		return impressao;
	}

	public void inserirFilho(NoArvore<T> no) {
		if (no != null) {
			no.irmao = this.filho;
			this.filho = no;
		}
	}

	public NoArvore<T> pertence(T procurado) {
		NoArvore<T> noBuscado = null;

		if (this.info.equals(procurado)) {
			return this;
		} else {
			if (filho != null)
				noBuscado = this.filho.pertence(procurado);

			if (irmao != null && noBuscado == null) {
				noBuscado = this.irmao.pertence(procurado);
			}
		}

		return noBuscado;
	}

	@Override
	public String toString() {
		return this.info.toString();
	}
	
	public int getAltura(int nivel) {
		int alturaFilho = 0;
		if (this.filho != null) {
			alturaFilho = this.filho.getAltura(nivel+1);
		}
		int alturaIrmao = nivel;
		if (this.irmao != null) {
			alturaIrmao = this.irmao.getAltura(nivel);
		}
		return Math.max(alturaFilho, alturaIrmao);
	}
	
	public int getNivel(T procurado, int nivel) {
		if (this.info.equals(procurado)) {
			return nivel;
		} else {
			int nivelPesquisado = -1;
			if (filho != null)
				nivelPesquisado = this.filho.getNivel(procurado,nivel+1);

			if (irmao != null && nivelPesquisado == -1) {
				nivelPesquisado = this.irmao.getNivel(procurado,nivel);
			}
			return nivelPesquisado;
		}

	}
}
