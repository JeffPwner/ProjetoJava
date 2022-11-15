import java.util.Date;

public class PosPago extends Assinante{
	private float assinatura;

	public PosPago(long cpf, String nome, int numero, int numChamadas, float assinatura) {
		super(cpf, nome, numero, numChamadas);
		this.assinatura = assinatura;
	}
	
	public void fazerChamada(Date data, int duracao) {
		
	}
	
	public void imprimirFatura(int mes) {
		
	}
}
