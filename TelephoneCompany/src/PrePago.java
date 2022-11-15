import java.util.Date;

public class PrePago extends Assinante{
	private float creditos;
	private int numRecargas;
	
	
	
	public PrePago(long cpf, String nome, int numero, int numChamadas, float creditos, int numRecargas) {
		super(cpf, nome, numero, numChamadas);
		this.creditos = creditos;
		this.numRecargas = numRecargas;
	}

	public void recarregar(Date data, float valor) {
		
	}
	
	public float fazerChamada(Date data, int duracao) {
		return 0;
	}
	
	public void imprimirFatura(int mes) {
		
	}
}
