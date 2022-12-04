
public class Assinante {
	private long cpf;
	private String nome;
	private long numero;
	protected Chamada[] chamadas = new Chamada[5]; //declarando uma variavel chamada Chamadas do tipo lista de chamadas. O valor da variavel é um vetor chamada com o valor max 5
	protected int numChamadas; //quando cria o assinante ela tem 0

	public Assinante(long cpf, String nome, long numero) {
		this.cpf = cpf;
		this.nome = nome;
		this.numero = numero;
	}

	public long getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return "Assinante [cpf=" + cpf + ", nome=" + nome + ", numero=" + numero + ", numChamadas=" + numChamadas + "]";
	}

}
