
public class Assinante {
	private long cpf;
	private String nome;
	private int numero;
	protected int numChamadas;

	public Assinante(long cpf, String nome, int numero, int numChamadas) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.numero = numero;
		this.numChamadas = numChamadas;
	}

	public long getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return "Assinante [cpf=" + cpf + ", nome=" + nome + ", numero=" + numero + ", numChamadas=" + numChamadas + "]";
	}

}
