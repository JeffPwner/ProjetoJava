import java.util.Date;
import java.util.GregorianCalendar;

public class PosPago extends Assinante {
	private float assinatura;

	public PosPago(long cpf, String nome, int numero, float assinatura) {
		super(cpf, nome, numero);
		this.assinatura = assinatura;
	}

	public void fazerChamada(GregorianCalendar data, int duracao) {
		this.assinatura = duracao * 1.04f;
		// this.chamadas.add(new Chamada(data, duracao));

		// if numChamadas > 0
		this.chamadas[this.numChamadas - 1] = new Chamada(data, duracao);
		this.numChamadas = this.numChamadas - 1;

		System.out.println(this.numChamadas);
	}

	public void mostrarChamadas() {
		for (int i = 0; i < 2; i++) {
			System.out.println(this.chamadas[i]);
		}
	}
	
	/*
	public static void main(String[] args) {

		PosPago p = new PosPago(2, "nome", 55, 10f);

		p.fazerChamada(new Date(), 10);
		p.fazerChamada(new Date(), 100);
		p.fazerChamada(new Date(), 100);

		p.mostrarChamadas();

	}
	*/

}
